package org.apink.domain;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class Reservation extends Product{
    private int id;
    private int productId;
    private int userId;
    private String reservationName;
    private String reservationTel;
    private String reservationEmail;
    private Date reservationDate;
    private int reservationType;
    private int totalPrice;

    private List<ReservationTicket> reservationTickets;

    public Reservation() {
        reservationTickets = new ArrayList<>();
    }
    public List<ReservationTicket> getReservationTickets() {
        return reservationTickets;
    }

    public void addReservationTicket(ReservationTicket reservationTicket) {
        reservationTickets.add(reservationTicket);
    }
    public void setReservationTickets(List<ReservationTicket> reservationTickets) {
        this.reservationTickets = reservationTickets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getReservationName() {
        return reservationName;
    }

    public void setReservationName(String reservationName) {
        this.reservationName = reservationName;
    }

    public String getReservationTel() {
        return reservationTel;
    }

    public void setReservationTel(String reservationTel) {
        this.reservationTel = reservationTel;
    }

    public String getReservationEmail() {
        return reservationEmail;
    }

    public void setReservationEmail(String reservationEmail) {
        this.reservationEmail = reservationEmail;
    }

    public Date getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(Date reservationDate) {
        this.reservationDate = reservationDate;
    }

    public int getReservationType() {
        return reservationType;
    }

    public void setReservationType(int reservationType) {
        this.reservationType = reservationType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", productId=" + productId +
                ", userId=" + userId +
                ", reservationName='" + reservationName + '\'' +
                ", reservationTel='" + reservationTel + '\'' +
                ", reservationEmail='" + reservationEmail + '\'' +
                ", reservationDate=" + reservationDate +
                ", reservationType=" + reservationType +
                ", totalPrice=" + totalPrice +
                ", reservationTickets=" + reservationTickets +
                ", name=" + super.getName() +
                '}';
    }
}
