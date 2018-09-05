package com.example.fileupload.repository;

import com.example.fileupload.UploadFile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadFileRepository extends JpaRepository<UploadFile,String> {
    default void saveInfo(String s) {
        UploadFile file = new UploadFile();
        file.setFileName(s);
        save(file);
    }
}
