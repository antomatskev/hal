package hal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import hal.model.Person;

public class PersonDao {

    private static final String INSERT_PERSON_SQL = "INSERT INTO person" +
            " (personalCode, firstName, lastName, address, email, bankAccount, insurance) VALUES " +
            " (?,?,?,?,?,?,?);";
    private static final String UPDATE_PERSON_SQL = "update person set personalCode=?,firstName=?," +
            "lastName=?,address=?,email=?,bankAccount=?,insurance=? where id=?";
    private static final String DELETE_PERSON_SQL = "delete from person where id=?";
    private static final String ALL_PERSONS_SQL = "select * from person";
    private static final String RECORD_BY_PERSON_ID_SQL = "select * from person where id=?";
    private final String DB_URL = "jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq";
    private final String DB_USER = "xxpiazwq";
    private final String DB_PASS = "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX";
    private final String CLASS_NAME = "org.postgresql.Driver";

    public int create(Person person) throws ClassNotFoundException {
        int result = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON_SQL)) {
            preparedStatement.setString(1, person.getPersonalCode());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getAddress());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getBankAccount());
            preparedStatement.setString(7, person.getInsurance());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.gc();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public int update(Person person) throws ClassNotFoundException {
        int result = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_SQL)) {
            preparedStatement.setString(1, person.getPersonalCode());
            preparedStatement.setString(2, person.getFirstName());
            preparedStatement.setString(3, person.getLastName());
            preparedStatement.setString(4, person.getAddress());
            preparedStatement.setString(5, person.getEmail());
            preparedStatement.setString(6, person.getBankAccount());
            preparedStatement.setString(7, person.getInsurance());
            preparedStatement.setLong(8, person.getId());

            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.gc();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public int delete(Long id) throws ClassNotFoundException {
        int status = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_SQL)) {
            preparedStatement.setLong(1, id);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return status;
    }

    public List<Person> getAll() throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        List<Person> list = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_PERSONS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Person person = new Person();
                person.setId(rs.getLong("id"));
                person.setPersonalCode(rs.getString("personalCode"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setAddress(rs.getString("address"));
                person.setEmail(rs.getString("email"));
                person.setBankAccount(rs.getString("bankAccount"));
                person.setInsurance(rs.getString("insurance"));
                list.add(person);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public Person getById(Long id) throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        Person person = null;
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(RECORD_BY_PERSON_ID_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                person = new Person();
                person.setId(rs.getLong("id"));
                person.setPersonalCode(rs.getString("personalCode"));
                person.setFirstName(rs.getString("firstName"));
                person.setLastName(rs.getString("lastName"));
                person.setAddress(rs.getString("address"));
                person.setEmail(rs.getString("email"));
                person.setBankAccount(rs.getString("bankAccount"));
                person.setInsurance(rs.getString("insurance"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return person;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}