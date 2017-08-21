package org.apink.mapper;

import org.apink.domain.Comment;
import org.apink.domain.vo.CommentImageVo;
import org.apink.domain.vo.CommentVo;
import org.apink.util.PagingHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CommentMapper {

    List<CommentVo> selectByProductId(int productId, PagingHandler pagingHandler);

    int insert(Comment comment);
}
