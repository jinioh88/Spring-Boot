package com.example.fileupload;

import com.example.fileupload.repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class UploadController {
    @Autowired
    UploadFileRepository repository;
    private String baseDir = "/Users/osejin/fishImg/";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(HttpServletRequest request) {
        return "Upload";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletResponse response,
                                                        @RequestParam MultipartFile[] fileUpload) throws Exception {

        if(fileUpload!=null && fileUpload.length>0) {
            String formattedDate = baseDir + new SimpleDateFormat("yyyy"+ File.separator
                    +"MM"+File.separator+"dd").format(new Date());
            File f = new File(formattedDate);
            if(!f.exists()) {
                f.mkdirs();
            }

            for(MultipartFile file : fileUpload) {
                String uuid = UUID.randomUUID().toString();
                String saveFileName = formattedDate + File.separator+uuid+".jpeg";
                response.setContentLength((int)file.getSize());
                response.setContentType(file.getContentType());

                UploadFile file1 = new UploadFile();
                file1.setFileName(file.getOriginalFilename());
                System.out.println("==============");
                System.out.println("Upload file: " + file1);

                repository.saveInfo(saveFileName); // db에 파일 이름 저장.

                // 저장소에 원본 저장
                try(InputStream in = file.getInputStream();
                    FileOutputStream out = new FileOutputStream(saveFileName)){
                    int count = 0;
                    byte[] buffer = new byte[1024];
                    while((count=in.read(buffer))!=-1) {
                        out.write(buffer,0,count);
                    }
                }catch(Exception e) {
                    e.getMessage();
                }
            }
        }
        return "Success";
    }

}
