package org.apink.controller;

import org.apink.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileController {

    private FileService fileService;

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping(path = "/fileManage")
    public String file() {
        return "files";
    }

    @PostMapping
    @ResponseBody
    public List<Integer> create(@RequestParam("file") MultipartFile[] files, HttpSession session,
                                HttpServletResponse response) throws IOException {

        //TODO ArgumentResolver session
        return fileService.addFiles(files, 1);

    }

    @GetMapping(path = "/{id}")
    public void getFile(@PathVariable Integer id, HttpServletResponse response) throws IOException {
        org.apink.domain.File file = fileService.getById(id);

        if (fileResponseMapper(file, response)) {
            FileInputStream fis;
            fis = fileService.getFileInputStream(file.getSaveFileName());

            try {
                FileCopyUtils.copy(fis, response.getOutputStream()); // 파일을 저장할때도 사용할 수 있다.
                response.getOutputStream().flush();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            } finally {
                try {
                    fis.close();
                } catch (Exception ex) {
                }
            }
        }
        return;

    }

    @PutMapping
    public void registFile() {

    }

    private boolean fileResponseMapper(org.apink.domain.File file, HttpServletResponse response) throws IOException {
        if (file == null) {
            response.sendRedirect("/resources/img/noimage.png");
            return false;
        } else {
            response.setHeader("Content-Disposition", "inline; filename=\"" + file.getFileName() + "\";");
            // 구브라우저 미구현.
            response.setHeader("Content-Transfer-Encoding", "binary");
            response.setHeader("Content-Type", file.getContentType());
            response.setHeader("Content-Length", "" + file.getFileLength());
            response.setHeader("Pragma", "no-cache;");
            response.setHeader("Expires", "-1;");
            return true;
        }
    }

}
