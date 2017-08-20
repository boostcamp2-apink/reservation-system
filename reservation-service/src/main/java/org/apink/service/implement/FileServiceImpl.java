package org.apink.service.implement;

import org.apink.mapper.dao.FileDao;
import org.apink.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    @Value("${spring.file.upload-locations}")
    private String baseDir;

    private FileDao fileDao;

    @Autowired
    public void setFileDao(FileDao fileDao) {
        this.fileDao = fileDao;
    }

    @Override
    public List<Integer> addFiles(MultipartFile[] multipartFiles, Integer userId) {
        List<Integer> fileIdList = new ArrayList<Integer>();
        org.apink.domain.File file = new org.apink.domain.File();
        if (multipartFiles != null && multipartFiles.length > 0) {
            String formattedDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File directory = new File(baseDir + formattedDate);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            for (MultipartFile multipartFile : multipartFiles) {
                file.setContentType(multipartFile.getContentType());
                file.setFileName(multipartFile.getOriginalFilename());
                file.setFileLength(multipartFile.getSize());
                file.setSaveFileName(formattedDate + File.separator + UUID.randomUUID().toString()); // 실제 저장되는 파일의
                file.setUserId(userId);
                file.setDeleteFlag(1);

                try {
                    File serverFile = new File(baseDir + file.getSaveFileName());
                    multipartFile.transferTo(serverFile);

                    fileIdList.add(fileDao.insert(file));// 실제 파일을 저장함.
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }

        return fileIdList;
    }

    @Override
    public org.apink.domain.File getById(Integer fileId) {
        // TODO Auto-generated method stub
        return fileDao.selectById(fileId);
    }

    @Override
    public FileInputStream getFileInputStream(String saveFileName) {
        java.io.File readFile = new java.io.File(baseDir + saveFileName);
        if (!readFile.exists()) { // 파일이 존재하지 않다면
            throw new RuntimeException("file not found");
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(readFile);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

        return fis;
    }



}
