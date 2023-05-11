package controller;

import dao.ReservasDAO;
import factory.ConnectionFactory;
import views.ReservasView;

import java.text.SimpleDateFormat;

public class ReservasController {

	private ReservasDAO reservasDAO;
	private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	public ReservasController() {
		var factory = new ConnectionFactory();
		this.reservasDAO = new ReservasDAO(factory.recoverConnection());
	}

	public void getData() {
		
		System.out.println("date_entered " + simpleDateFormat.format(ReservasView.txtFechaEntrada.getDate()));
		System.out.println("date_out " + simpleDateFormat.format(ReservasView.txtFechaSalida.getDate()));
		System.out.println("method_payment " + ReservasView.txtFormaPago.getSelectedItem().toString());

	}

}
