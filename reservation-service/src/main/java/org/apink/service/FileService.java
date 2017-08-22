package org.apink.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.util.List;

public interface FileService {

    List<Integer> addFiles(MultipartFile[] files, Integer userId);

    org.apink.domain.File getById(Integer fileId);

    FileInputStream getFileInputStream(String saveFileName);



}