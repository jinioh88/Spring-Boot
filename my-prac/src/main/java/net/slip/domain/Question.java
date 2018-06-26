package net.slip.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Question {
    @Id
    @GeneratedValue
    private Long id;

    private String writer;
    @Lob
    private String contents;
    private String title;
    private LocalDateTime createDate;

    public Question() {
    }

    public Question(String writer, String contents, String title) {
        super();
        this.writer = writer;
        this.contents = contents;
        this.title = title;
        this.createDate = LocalDateTime.now();
    }

    public void update(String title, String contents) {
        this.title = title;
        this.contents = contents;
        this.createDate = LocalDateTime.now();
    }


}
