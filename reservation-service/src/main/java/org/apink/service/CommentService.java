package org.apink.service;

import org.apink.domain.vo.CommentVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface CommentService {

    List<CommentVo> getByProductId(int productId, PagingHandler pagingHandler);

    int addComment(CommentVo commentVo);

}
