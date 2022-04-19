package bluebird.co.uk.demo.service;

import bluebird.co.uk.demo.model.Video;
import bluebird.co.uk.demo.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;

    public void uploadVideo(MultipartFile file){

        //getting the video url from S3 bucket
        String videoUrl = s3Service.uploadFile(file);

        //object of Video class to set the url from S3 into pojo class. To send it to Mongo
        Video video = new Video();
        video.setVideoUrl(videoUrl);

        //to save the url into Mongo, we need the repository
        videoRepository.save(video);

        //now call this upload video method inside the controller
    }
}
