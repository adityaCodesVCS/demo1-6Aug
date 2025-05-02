package com.demo1.demo1.controller;

import com.demo1.demo1.entity.Comments;
import com.demo1.demo1.entity.Video;
import com.demo1.demo1.repository.CommentsRepository;
import com.demo1.demo1.repository.VideoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentsController {

    private CommentsRepository commentsRepository;
    private VideoRepository videoRepository;

    public CommentsController(CommentsRepository commentsRepository, VideoRepository videoRepository) {
        this.commentsRepository = commentsRepository;
        this.videoRepository = videoRepository;
    }

    //Ist way to supply comments in DB.
    //http://localhost:8080/api/v1/comments?videoId=4
    @PostMapping
    public ResponseEntity<Comments> createComment(
            @RequestBody Comments comment,
            @RequestParam long videoId
    ) {
        Optional<Video> video = videoRepository.findById(videoId);
        Video vid = video.get(); //Here, 'vid'(Entity Class-Video's object) contains record detail related to Id='videoId' from 'Video' table of DB.
        comment.setVideo(vid); //i.e. set FK in 'comment'(Entity class-Comments's object) from 'vid'(Entity Class-Video's object).
        commentsRepository.save(comment);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
    //OR
    //2nd way to supply comments in DB.
    //http://localhost:8080/api/v1/comments
//    @PostMapping
//    public ResponseEntity<Comments> createComment(
//            @RequestBody Comments comment //We supply nested JSON to backend from POSTMAN.
//    ) {
//        commentsRepository.save(comment);
//        return new ResponseEntity<>(comment, HttpStatus.CREATED);
//    }

    //http://localhost:8080/api/v1/comments?videoId=3
    @GetMapping
    public ResponseEntity<List<Comments>> getAllComments(
            @RequestParam Long videoId
    ) {
        Optional<Video> video = videoRepository.findById(videoId);
        Video vid = video.get();
        List<Comments> comments = commentsRepository.findByVideo(vid);
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }

}
