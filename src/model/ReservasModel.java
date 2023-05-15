package model;

import java.sql.Date;

public class ReservasModel {
    private Integer id;
    private Date dateEntered;
    private Date dateOut;
    private float value;
    private String methodPayment;

    public ReservasModel(Date dateEntered, Date dateOut, float value, String methodPayment) {
        this.dateEntered = dateEntered;
        this.dateOut = dateOut;
        this.value = value;
        this.methodPayment = methodPayment;
    }

    public ReservasModel(){}

    public Integer getId() {
        return id;
    }

    public Date getDateEntered() {
        return dateEntered;
    }

    public void setDateEntered(Date dateEntered) {
        this.dateEntered = dateEntered;
    }

    public Date getDateOut() {
        return dateOut;
    }

    public void setDateOut(Date dateOut) {
        this.dateOut = dateOut;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public void setMethodPayment(String methodPayment) {
        this.methodPayment = methodPayment;
    }
}
