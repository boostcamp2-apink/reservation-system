package org.apink.domain.vo;

import org.apink.domain.ProductPrice;

public class ReservationTicketVo extends ProductPrice {

    private int reservationId;
    private int count;


    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
