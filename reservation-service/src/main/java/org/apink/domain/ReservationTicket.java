package org.apink.domain;

import java.sql.Date;

public class ReservationTicket {
    private  int reservationId;
    private int productPriceId;
    private int count;
    private Date createDate;
    private Date modifyDate;

    @Override
    public String toString() {
        return "ReservationTicket{" +
                "reservationId=" + reservationId +
                ", productPriceId=" + productPriceId +
                ", count=" + count +
                ", createDate=" + createDate +
                ", modifyDate=" + modifyDate +
                '}';
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getProductPriceId() {
        return productPriceId;
    }

    public void setProductPriceId(int productPriceId) {
        this.productPriceId = productPriceId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
