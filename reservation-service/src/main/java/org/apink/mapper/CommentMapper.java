package org.apink.mapper;

import org.apink.domain.vo.CommentVo;
import org.apink.util.PagingHandler;

import java.util.List;

public interface CommentMapper {

    List<CommentVo> selectByProductId(int productId, PagingHandler pagingHandler);

}
