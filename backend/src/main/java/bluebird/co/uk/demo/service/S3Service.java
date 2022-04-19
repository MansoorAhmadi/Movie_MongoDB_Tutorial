package bluebird.co.uk.demo.service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class S3Service implements FileService{

    public static final String S3BUCKET_NAME = "movie-mongo-bucket";
    //the IDE will complain about a constructor, that's why we added the @RequiredArgsConstructor
    private final AmazonS3Client awsS3Client;

    @Override
    public String uploadFile(MultipartFile file) {
        //uploading the file or video to AWS S3 - save the data to Database Mongo

        //prepare a key
        //Extract the filename extension from the given Java resource path, import the package org.springframework.util.StringUtils;
        String fileNameExtension = StringUtils.getFilenameExtension(file.getOriginalFilename());

        //Generating a random id for the fileNameExtension
        String key = UUID.randomUUID().toString() + "." + fileNameExtension;

        //Amazon AWS S3 API, to get the content type, size
        ObjectMetadata metadata = new ObjectMetadata();

        metadata.setContentLength(file.getSize());
        metadata.setContentType(file.getContentType());

        //to send the video to AWS
        //putObject(the S3 bucket name)
        //key - which is a random id
        //metadata - which is the content type and size
        try {
            awsS3Client.putObject(S3BUCKET_NAME, key, file.getInputStream(), metadata);
        } catch (IOException ioException) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Exception occurred while uploading");
        }

        //allowing the video as public
        awsS3Client.setObjectAcl(S3BUCKET_NAME, key, CannedAccessControlList.PublicRead);

        //we return url from the bucket
        return awsS3Client.getResourceUrl(S3BUCKET_NAME, key);
    }

}
