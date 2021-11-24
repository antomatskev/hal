package hal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import hal.model.Payment;

public class PaymentDao {

    private static final String INSERT_PERSON_SQL = "INSERT INTO payment" +
            " (personId, income, sum, status) VALUES " +
            " (?,?,?,?);";
    private static final String UPDATE_PERSON_SQL = "update payment set personId=?,income=?," +
            "sum=?,status=? where id=?";
    private static final String DELETE_PERSON_SQL = "delete from payment where id=?";
    private static final String ALL_PERSONS_SQL = "select * from payment";
    private static final String RECORD_BY_PERSON_ID_SQL = "select * from payment where id=?";
    private final String DB_URL = "jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq";
    private final String DB_USER = "xxpiazwq";
    private final String DB_PASS = "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX";
    private final String CLASS_NAME = "org.postgresql.Driver";

    public int create(Payment payment) throws ClassNotFoundException {
        int result = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PERSON_SQL)) {
            preparedStatement.setLong(1, payment.getPersonId());
            preparedStatement.setDouble(2, payment.getIncome());
            preparedStatement.setDouble(3, payment.getSum());
            preparedStatement.setString(4, payment.getStatus());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.gc();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public int update(Payment payment) throws ClassNotFoundException {
        int result = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PERSON_SQL)) {
            preparedStatement.setLong(1, payment.getPersonId());
            preparedStatement.setDouble(2, payment.getIncome());
            preparedStatement.setDouble(3, payment.getSum());
            preparedStatement.setString(4, payment.getStatus());
            preparedStatement.setLong(5, payment.getId());

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
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PERSON_SQL)) {
            preparedStatement.setLong(1, id);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return status;
    }

    public List<Payment> getAll() throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        List<Payment> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_PERSONS_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getLong("id"));
                payment.setPersonId(rs.getLong("personId"));
                payment.setIncome(rs.getDouble("income"));
                payment.setSum(rs.getDouble("sum"));
                payment.setStatus(rs.getString("status"));
                list.add(payment);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public Payment getById(Long id) throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        Payment payment = null;
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(RECORD_BY_PERSON_ID_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                payment = new Payment();
                payment.setId(rs.getLong("id"));
                payment.setPersonId(rs.getLong("personId"));
                payment.setIncome(rs.getDouble("income"));
                payment.setSum(rs.getDouble("sum"));
                payment.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return payment;
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