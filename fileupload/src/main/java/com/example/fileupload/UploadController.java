package com.example.fileupload;

import com.example.fileupload.repository.UploadFileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UploadController {
    @Autowired
    UploadFileRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showForm(HttpServletRequest request) {
        return "Upload";
    }

    @RequestMapping(value = "/doUpload", method = RequestMethod.POST)
    public String handleFileUpload(HttpServletRequest request,
                                                        @RequestParam MultipartFile[] fileUpload) throws Exception {
        if(fileUpload!=null && fileUpload.length>0) {
            for(MultipartFile file : fileUpload) {
                System.out.println("Saving file: " + file.getOriginalFilename());

                UploadFile file1 = new UploadFile();
                file1.setFileName(file.getOriginalFilename());
                file1.setData(file.getBytes());
                repository.save(file1);
                System.out.println(file1);
            }
        }
        return "Success";
    }

}
