package com.example.demo;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class BasicBullhorn {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;

    @NotNull
    @Size(min = 3)
    public String title;

    @NotNull
    @Size(min = 10)
    public String content;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "MM-dd-YY")
    private Date postedDate;

    @NotNull
    @Size(min = 2)
    public String postedBy;

    public BasicBullhorn(){

    }

    public BasicBullhorn(@NotNull @Size(min = 3) String title, @NotNull @Size(min = 10) String content, @NotNull @Size(min = 2) String postedBy) {
        this.title = title;
        this.content = content;
        this.postedBy = postedBy;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(Date postedDate) {
        this.postedDate = postedDate;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }
}
