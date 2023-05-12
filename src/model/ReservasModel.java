package model;

import java.sql.Date;

public class ReservasModel {
    private Integer id;
    private Date date_entered;
    private Date date_out;
    private float value;
    private String method_payment;

    public ReservasModel(Date date_entered, Date date_out, float value, String method_payment) {
        this.date_entered = date_entered;
        this.date_out = date_out;
        this.value = value;
        this.method_payment = method_payment;
    }

    public ReservasModel(){}

    public Integer getId() {
        return id;
    }

    public Date getDate_entered() {
        return date_entered;
    }

    public void setDate_entered(Date date_entered) {
        this.date_entered = date_entered;
    }

    public Date getDate_out() {
        return date_out;
    }

    public void setDate_out(Date date_out) {
        this.date_out = date_out;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getMethod_payment() {
        return method_payment;
    }

    public void setMethod_payment(String method_payment) {
        this.method_payment = method_payment;
    }
}
