package org.apink.domain.vo;

import org.apink.domain.Comment;

import java.util.List;

public class CommentVo extends Comment {

    private List<Integer> images;
    private String userName;

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
