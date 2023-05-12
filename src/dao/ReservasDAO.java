package dao;

import model.CalcularCosto;

import java.sql.Connection;
import java.time.LocalDate;


public class ReservasDAO {

    final private Connection con;

    public ReservasDAO(Connection con) {
        this.con = con;
    }

    public float calcularValorReserva(LocalDate dateEntered, LocalDate dateOut) {
        return CalcularCosto.calcularCostoPorDias(dateEntered, dateOut);
    }



}
