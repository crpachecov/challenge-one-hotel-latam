package controller;

import dao.HuespedDAO;
import dao.ReservasDAO;
import factory.ConnectionFactory;
import model.HuespedModel;

public class HuespedController {

    private HuespedDAO huespedDAO;

    public HuespedController() {
        var factory = new ConnectionFactory();
        this.huespedDAO = new HuespedDAO(factory.recoverConnection());
    }

    public void guardarHuesped(HuespedModel huesped) {
        this.huespedDAO.guardar(huesped);
    }

    public void closeConnection() {
    	this.huespedDAO.closeConnection();
    }
}
