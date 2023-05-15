package dao;


import model.ReservasModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ReservasDAO {

    final private Connection con;

    public ReservasDAO(Connection con) {
        this.con = con;
    }


    public int guardar(ReservasModel reserva) {
        try {
            final PreparedStatement statement = con.prepareStatement(
                    "INSERT INTO tb_bookings "
                            + "(date_entered, date_out, value, method_payment)"
                            + " VALUES(?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            try (statement) {
                return ejecutaRegistro(reserva, statement);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int ejecutaRegistro(ReservasModel reserva, PreparedStatement statement) throws SQLException {
        int idReserva = 0;
        // Corresponde a cada interrogante en orden, se le envia el valor de la
        // coleccion
        statement.setDate(1, reserva.getDateEntered());
        statement.setDate(2, reserva.getDateOut());
        statement.setFloat(3, reserva.getValue());
        statement.setString(4, reserva.getMethodPayment());

        statement.execute();

        final ResultSet resultSet = statement.getGeneratedKeys();

        // try-with-resources nos permite cerrar automaticamento los recursos que tenga
        // el meotodo AutoCloseable
        try (resultSet) {
            while (resultSet.next()) {
                idReserva = resultSet.getInt(1);
                System.out.println(String.format("Fue insertado la reserva %s", idReserva));
            }
        }
        return idReserva;
    }
}
