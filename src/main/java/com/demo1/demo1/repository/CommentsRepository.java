package com.demo1.demo1.repository;

import com.demo1.demo1.entity.Comments;
import com.demo1.demo1.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentsRepository extends JpaRepository<Comments, Long> {

    //finder method
    List<Comments> findByVideo(Video video); //i.e. find by 'video'(FK)

    List<Comments> deleteByVideo(Video video);
}