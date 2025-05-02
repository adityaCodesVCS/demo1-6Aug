package com.demo1.demo1.controller;

import com.demo1.demo1.entity.Video;
import com.demo1.demo1.repository.VideoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    private VideoRepository videoRepository;

    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    //http://localhost:8080/api/v1/video
    @PostMapping
    public ResponseEntity<Video> createVideo(
            @RequestBody Video video
    ) {
        videoRepository.save(video);
        return ResponseEntity.ok(video);
        //return new ResponseEntity<>(video, HttpStatus.CREATED)
    }

    //http://localhost:8080/api/v1/video?id=1
    @DeleteMapping
    public void deleteVideo(
            @RequestParam long id
    ) {
        videoRepository.deleteById(id);
    }

}
