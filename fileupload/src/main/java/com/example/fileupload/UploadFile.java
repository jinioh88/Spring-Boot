package com.example.fileupload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class UploadFile {
    @Id
    @GeneratedValue
    private long id;
    private String fileName;

    @Lob
    @Column(length=1024000)
    private byte[] data;

}
