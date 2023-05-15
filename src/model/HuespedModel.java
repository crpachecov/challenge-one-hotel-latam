package model;

import java.sql.Date;

public class HuespedModel {

    private Integer id;
    private String name;
    private String lastName;
    private Date dateBorn;
    private String nationality;
    private String phone;
    private Integer bookingId;

    public HuespedModel(String name, String lastName, Date dateBorn, String nationality, String phone, Integer bookingId){
        this.name = name;
        this.lastName = lastName;
        this.dateBorn = dateBorn;
        this.nationality = nationality;
        this.phone = phone;
        this.bookingId = bookingId;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateBorn() {
        return dateBorn;
    }

    public void setDateBorn(Date dateBorn) {
        this.dateBorn = dateBorn;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }


}
