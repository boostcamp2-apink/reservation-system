package org.apink.domain.vo;

import org.apink.domain.Comment;

import java.util.List;

public class CommentVo extends Comment {

    private String username;
    private List<Integer> images;
    private String userName;

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
