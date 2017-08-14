package org.apink.domain.vo;

import org.apink.domain.Product;

import java.sql.Date;

public class ReservePageProductVo extends Product {

    private Date displayStart;
    private Date displayEnd;
    private String placeName;
    private String placeLot;
    private String placeStreet;

    @Override
    public String toString() {
        return  super.toString() +
                "ReservePageProductVo{" +
                "displayStart=" + displayStart +
                ", displayEnd=" + displayEnd +
                ", placeName='" + placeName + '\'' +
                ", placeLot='" + placeLot + '\'' +
                ", placeStreet='" + placeStreet + '\'' +
                '}';
    }

    public Date getDisplayStart() {
        return displayStart;
    }

    public void setDisplayStart(Date displayStart) {
        this.displayStart = displayStart;
    }

    public Date getDisplayEnd() {
        return displayEnd;
    }

    public void setDisplayEnd(Date displayEnd) {
        this.displayEnd = displayEnd;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getPlaceLot() {
        return placeLot;
    }

    public void setPlaceLot(String placeLot) {
        this.placeLot = placeLot;
    }

    public String getPlaceStreet() {
        return placeStreet;
    }

    public void setPlaceStreet(String placeStreet) {
        this.placeStreet = placeStreet;
    }
}