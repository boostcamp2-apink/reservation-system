package org.apink.mapper;

import org.apink.domain.File;

public interface FileMapper {

    int insert(File file);

    File selectById(int id);



}
