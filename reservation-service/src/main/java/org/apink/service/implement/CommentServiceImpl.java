package org.apink.service.implement;

import org.apink.domain.vo.CommentVo;
import org.apink.mapper.CommentMapper;
import org.apink.service.CommentService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper){
        this.commentMapper = commentMapper;
    }


    @Override
    public List<CommentVo> getByProductId(int productId, PagingHandler pagingHandler) {
        return commentMapper.selectByProductId(productId,pagingHandler);
    }
}
