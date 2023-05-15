package dao;

import model.HuespedModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HuespedDAO {

    final private Connection con;

    public HuespedDAO(Connection con) {
        this.con = con;
    }

    public void guardar(HuespedModel huesped) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO tb_guests "
                            + "(name, last_name, date_born, nationality, phone, tb_bookings_id)"
                            + " VALUES(?, ?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                ejecutaRegistro(huesped, statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void ejecutaRegistro(HuespedModel huesped, PreparedStatement statement) throws SQLException {
        // Corresponde a cada interrogante en orden, se le envia el valor de la
        // coleccion
        statement.setString(1, huesped.getName());
        statement.setString(2, huesped.getLastName());
        statement.setDate(3, huesped.getDateBorn());
        statement.setString(4, huesped.getNationality());
        statement.setString(5, huesped.getPhone());
        statement.setInt(6, huesped.getBookingId());

        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();

        // try-with-resources nos permite cerrar automaticamento los recursos que tenga
        // el meotodo AutoCloseable
        try (resultSet) {
            while (resultSet.next()) {
                System.out.println(String.format("Fue insertado el huesped %s", resultSet.getInt(1)));
            }
        }
    }

    public void closeConnection() {
        try {
            this.con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
