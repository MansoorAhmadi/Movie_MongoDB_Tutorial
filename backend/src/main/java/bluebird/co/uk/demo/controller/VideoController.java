package bluebird.co.uk.demo.controller;

import bluebird.co.uk.demo.service.VideoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/videos")
@RequiredArgsConstructor
public class VideoController {

    //will save the video URL into Mongo
    private final VideoService videoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void uploadVideo(@RequestParam ("file") MultipartFile file){
        //the controller should connect to the service layer, we will create the video-service layer
        videoService.uploadVideo(file);
    }


}

