package controller;

import dao.ReservasDAO;
import factory.ConnectionFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class ReservasController {

	private ReservasDAO reservasDAO;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDAO = new ReservasDAO(factory.recoverConnection());
	}


	public float calcularValorReserva(Date date_entered, Date date_out) {
		LocalDate dateEntered;
		LocalDate dateOut;
		try {
			dateEntered = date_entered.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			dateOut = date_out.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		}catch (Exception e){
			throw new RuntimeException(e);
		}

		return this.reservasDAO.calcularValorReserva(dateEntered, dateOut);
	}
}
