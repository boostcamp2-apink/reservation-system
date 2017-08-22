package org.apink.domain.vo;

import org.apink.domain.Product;

import java.util.List;

@SuppressWarnings("unused")
public class DetailPageProductVo extends Product {

    //products_display
    private String placeName;
    private String placeLot;
    private String placeStreet;
    private String tel;
    private String homepage;
    private String email;

    //products_detail
    private String content;

    //products_images
    private List<Integer> images;

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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return super.toString()+
                "DetailPageProductVo{" +
                "placeName='" + placeName + '\'' +
                ", placeLot='" + placeLot + '\'' +
                ", placeStreet='" + placeStreet + '\'' +
                ", tel='" + tel + '\'' +
                ", homepage='" + homepage + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", images=" + images +
                '}';
    }
}
