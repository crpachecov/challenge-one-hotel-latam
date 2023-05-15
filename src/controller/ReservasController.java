package controller;

import dao.ReservasDAO;
import factory.ConnectionFactory;
import model.CalcularCosto;
import model.ReservasModel;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ReservasController {

	private ReservasDAO reservasDAO;

	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDAO = new ReservasDAO(factory.recoverConnection());
	}

	public int guardarReserva(ReservasModel reserva){
		return this.reservasDAO.guardar(reserva);
	}


	public float calcularValorReserva(Date date_entered, Date date_out) {
		try {
			LocalDate dateEntered = date_entered.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			LocalDate dateOut = date_out.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

			return CalcularCosto.calcularCostoPorDias(dateEntered, dateOut);
		}catch (Exception e){
			throw new RuntimeException(e);
		}
	}
}
