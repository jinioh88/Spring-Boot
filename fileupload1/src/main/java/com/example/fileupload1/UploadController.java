package com.example.fileupload1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.UUID;

import static java.io.File.createTempFile;
import static java.io.File.separator;

@Controller
public class UploadController {
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
    String uploadPath = "C:/upload/images";

    @RequestMapping(value = "/upload/uploadForm",method = RequestMethod.GET)
    public String uploadForm() {
        logger.info(uploadPath);
        return "uploadForm";
    }

    @RequestMapping(value = "/upload/uploadForm", method = RequestMethod.POST)
    public ModelAndView uploadForm(MultipartFile file, ModelAndView mav) throws Exception {
        logger.info("파일이름 : "+file.getOriginalFilename());
        String savedName = file.getOriginalFilename();
        savedName = uploadFiles(savedName,file.getBytes());

        mav.setViewName("uploadResult.html");
        mav.addObject("saveName",savedName);

        return mav;
    }

    //UUID 생성
    private String uploadFiles(String originalName, byte[] fileData) throws Exception {
        UUID uuid = UUID.randomUUID();
        String saveName = uuid.toString()+"_"+originalName;
        File target = new File(uploadPath,saveName);
        try{
        FileCopyUtils.copy(fileData,target);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return saveName;
    }
}
