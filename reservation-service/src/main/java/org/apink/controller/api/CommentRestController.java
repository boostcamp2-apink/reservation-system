package org.apink.controller.api;

import org.apink.domain.vo.CommentVo;
import org.apink.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentRestController {

    private CommentService commentService;


    @Autowired
    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public int addCommentByProductId(@RequestBody CommentVo comment){
        return commentService.addComment(comment);
    }
}
