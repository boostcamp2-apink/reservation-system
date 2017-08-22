package org.apink.mapper;

import org.apink.domain.CommentImage;
import org.apink.domain.File;
import org.apink.domain.vo.CommentImageVo;

import java.util.List;

public interface FileMapper {

    int insert(File file);

    File selectById(int id);

    List<CommentImageVo> selectByCommentsId(List<Integer> comments);

    int updateDeleteFlag(List<Integer> filesId);

    int[] insertComment(List<CommentImage> commentsImages);



}
