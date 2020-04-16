package com.cyrex.awsimageuploader;

import com.cyrex.awsimageuploader.profile.UserProfile;
import com.cyrex.awsimageuploader.profile.UserProfileService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileServiceTest {

    @Autowired
    private UserProfileService userProfileService;

    private static final MockMultipartFile multipartFileJPEG = new MockMultipartFile(
            "file", "test.jpg", "image/jpeg", "test image content".getBytes());
    private static final MockMultipartFile multipartFileGIF = new MockMultipartFile(
            "file", "test2.gif", "image/gif", "test image content".getBytes());
    private static final MockMultipartFile multipartFilePNG = new MockMultipartFile(
            "file", "test3.png", "image/png", "test image content".getBytes());
    private static final MockMultipartFile notAnImage = new MockMultipartFile(
            "file", "test.txt", "text/html", "test text content".getBytes());
    private static final byte[] emptyArray = new byte[0];
    private static final MockMultipartFile emptyFile = new MockMultipartFile("emptyfile", emptyArray);


    @Test
    public void should_be_an_image() {
        userProfileService.isImage(multipartFileJPEG);
        userProfileService.isImage(multipartFileGIF);
        userProfileService.isImage(multipartFilePNG);
        // Test is Successful if no exception is thrown
    }

    @Test
    public void should_throw_exception_on_non_image() {
        try {
            // since text/html is not an image file, it should throw an exception with message
            userProfileService.isImage(notAnImage);
        } catch (IllegalStateException e) {
            assertEquals("File must be an image [text/html]", e.getMessage());
        }
    }

    @Test
    public void should_throw_when_file_empty() {
        try {
            userProfileService.isFileEmpty(emptyFile);
        } catch (IllegalStateException e) {
            assertEquals("Cannot upload empty file [0]", e.getMessage());
        }
    }

    @Test
    public void givenProfileUUID_whenGetUserProfile_then_Return_UserProfileObject() {
        UserProfile sasan = userProfileService.getUserProfileOrThrow(
                UUID.fromString("72202d84-1aa1-4055-86fe-a8c5c7fc5ff8"));
        assertEquals("sasanjaghori", sasan.getUsername());
    }

}
