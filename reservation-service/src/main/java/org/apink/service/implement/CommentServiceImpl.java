package org.apink.service.implement;

import org.apink.domain.Comment;
import org.apink.domain.CommentImage;
import org.apink.domain.vo.CommentImageVo;
import org.apink.domain.vo.CommentVo;
import org.apink.mapper.CommentMapper;
import org.apink.mapper.FileMapper;
import org.apink.service.CommentService;
import org.apink.util.PagingHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;
    private FileMapper fileMapper;


    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper,FileMapper fileMapper){

        this.commentMapper = commentMapper;
        this.fileMapper = fileMapper;
    }


    @Override
    public List<CommentVo> getByProductId(int productId, PagingHandler pagingHandler) {
        List<CommentVo> commentVos = commentMapper.selectByProductId(productId,pagingHandler);
        List<Integer> comments = commentVos.stream()
                .map(CommentVo::getId)
                .collect(Collectors.toList());

        List<CommentImageVo> images = fileMapper.selectByCommentsId(comments);

        Map<Integer,List<Integer>> commentsImages = images.stream()
                .collect(Collectors.groupingBy(CommentImageVo::getCommentId,
                        Collectors.mapping(CommentImageVo::getFileId,Collectors.toList())));

        for(CommentVo commentVo : commentVos){
            commentVo.setImages(commentsImages.get(commentVo.getId()));
        }

        return commentVos;


    }

    @Override
    @Transactional
    public int addComment(CommentVo commentVo) {
        int commentId;
        List<Integer> images = commentVo.getImages();
        List<CommentImage> commentImages = new ArrayList<>();
        fileMapper.updateDeleteFlag(images);
        commentId = commentMapper.insert((Comment)commentVo);
        for(int i=0;i<images.size();i++){
            CommentImage commentImage = new CommentImage();
            commentImage.setCommentId(commentId);
            commentImage.setFileId(images.get(i));
            commentImages.add(commentImage);
        }
        fileMapper.insertComment(commentImages);

        return 1;
    }
}
