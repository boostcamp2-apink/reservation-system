package org.apink.domain;

import java.sql.Date;

@SuppressWarnings("unused")
public class ProductDisplay {

    private int id;
    private int product_id;
    private Date observation_time;
    private Date display_start;
    private Date display_end;
    private String place_name;
    private String place_lot;
    private String place_street;
    private String tel;
    private String homepage;
    private String email;


    @Override
    public String toString() {
        return "ProductDisplay{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", observation_time=" + observation_time +
                ", display_start=" + display_start +
                ", display_end=" + display_end +
                ", place_name='" + place_name + '\'' +
                ", place_lot='" + place_lot + '\'' +
                ", place_street='" + place_street + '\'' +
                ", tel='" + tel + '\'' +
                ", homepage='" + homepage + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public Date getObservation_time() {
        return observation_time;
    }

    public void setObservation_time(Date observation_time) {
        this.observation_time = observation_time;
    }

    public Date getDisplay_start() {
        return display_start;
    }

    public void setDisplay_start(Date display_start) {
        this.display_start = display_start;
    }

    public Date getDisplay_end() {
        return display_end;
    }

    public void setDisplay_end(Date display_end) {
        this.display_end = display_end;
    }

    public String getPlace_name() {
        return place_name;
    }

    public void setPlace_name(String place_name) {
        this.place_name = place_name;
    }

    public String getPlace_lot() {
        return place_lot;
    }

    public void setPlace_lot(String place_lot) {
        this.place_lot = place_lot;
    }

    public String getPlace_street() {
        return place_street;
    }

    public void setPlace_street(String place_street) {
        this.place_street = place_street;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
