package hal.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import hal.model.Illness;
import hal.model.Person;

public class IllnessDao {

    private static final String INSERT_ILLNESS_SQL = "INSERT INTO illness" +
            " (personId, startDate, endDate, diagnosis, medicalDoctor, notes) VALUES " +
            " (?,?,?,?,?,?);";
    private static final String UPDATE_ILLNESS_SQL = "update illness set personId=?,startDate=?," +
            "endDate=?,diagnosis=?,medicalDoctor=?,notes=? where id=?";
    private static final String DELETE_ILLNESS_SQL = "delete from illness where id=?";
    private static final String ALL_ILLNESSES_SQL = "select * from illness";
    private static final String RECORD_BY_ILLNESS_ID_SQL = "select * from illness where id=?";
    private final String DB_URL = "jdbc:postgresql://hattie.db.elephantsql.com/xxpiazwq";
    private final String DB_USER = "xxpiazwq";
    private final String DB_PASS = "lYYEfiXK1z2GPt9DiCi_dH_X1MSprLiX";
    private final String CLASS_NAME = "org.postgresql.Driver";

    public int create(Illness illness) throws ClassNotFoundException {
        int result = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ILLNESS_SQL)) {
            preparedStatement.setLong(1, illness.getPersonId());
            preparedStatement.setString(2, illness.getStartDate());
            preparedStatement.setString(3, illness.getEndDate());
            preparedStatement.setString(4, illness.getDiagnosis());
            preparedStatement.setString(5, illness.getMedicalDoctor());
            preparedStatement.setString(6, illness.getNotes());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
            System.gc();
        } catch (SQLException e) {
            printSQLException(e);
        }
        return result;
    }

    public int update(Illness illness) throws ClassNotFoundException {
        int result = 0;
        Class.forName(CLASS_NAME);
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ILLNESS_SQL)) {
            preparedStatement.setLong(1, illness.getPersonId());
            preparedStatement.setString(2, illness.getStartDate());
            preparedStatement.setString(3, illness.getEndDate());
            preparedStatement.setString(4, illness.getDiagnosis());
            preparedStatement.setString(5, illness.getMedicalDoctor());
            preparedStatement.setString(6, illness.getNotes());
            preparedStatement.setLong(8, illness.getId());

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
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ILLNESS_SQL)) {
            preparedStatement.setLong(1, id);
            status = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }

        return status;
    }

    public List<Illness> getAll() throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        List<Illness> list = new ArrayList<>();
        try (Connection connection = DriverManager
                .getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(ALL_ILLNESSES_SQL)) {
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Illness illness = new Illness();
                illness.setId(rs.getLong("id"));
                illness.setPersonId(rs.getLong("personId"));
                illness.setStartDate(rs.getString("startDate"));
                illness.setEndDate(rs.getString("endDate"));
                illness.setDiagnosis(rs.getString("diagnosis"));
                illness.setMedicalDoctor(rs.getString("medicalDoctor"));
                illness.setNotes(rs.getString("notes"));
                list.add(illness);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return list;
    }

    public Illness getById(Long id) throws ClassNotFoundException {
        Class.forName(CLASS_NAME);
        Illness illness = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
             PreparedStatement preparedStatement = connection.prepareStatement(RECORD_BY_ILLNESS_ID_SQL)) {
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                illness = new Illness();
                illness.setId(rs.getLong("id"));
                illness.setPersonId(rs.getLong("personId"));
                illness.setStartDate(rs.getString("startDate"));
                illness.setEndDate(rs.getString("endDate"));
                illness.setDiagnosis(rs.getString("diagnosis"));
                illness.setMedicalDoctor(rs.getString("medicalDoctor"));
                illness.setNotes(rs.getString("notes"));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return illness;
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