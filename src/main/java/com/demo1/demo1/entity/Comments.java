package com.demo1.demo1.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comments")
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "comments", length = 2500)
    private String comments;

    @ManyToOne //Many(i.e. the class in which I write this annotation) & One(i.e. referring to this particular object-'video')
    @JoinColumn(name = "video_id") //i.e. create the FK(PK of 'Video' table) column-'video_id' in 'Comments' table.
    private Video video; //i.e. FK here(In 'Comments' entity class) is 'video'(reference variable of 'Video' entity class).

    public Video getVideo() { //i.e. get FK here relevant to 'Video' entity class.
        return video;
    }

    public void setVideo(Video video) { //i.e. set FK from 'Video' entity class.
        this.video = video;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}