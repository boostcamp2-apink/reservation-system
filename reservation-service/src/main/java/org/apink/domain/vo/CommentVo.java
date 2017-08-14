package org.apink.domain.vo;

import org.apink.domain.Comment;

import java.util.List;

public class CommentVo extends Comment {

    private List<Integer> images;

    public List<Integer> getImages() {
        return images;
    }

    public void setImages(List<Integer> images) {
        this.images = images;
    }
}
