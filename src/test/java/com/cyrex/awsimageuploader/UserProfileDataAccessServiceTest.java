package com.cyrex.awsimageuploader;

import com.cyrex.awsimageuploader.profile.UserProfile;
import com.cyrex.awsimageuploader.profile.UserProfileDataAccessService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserProfileDataAccessServiceTest {

    @Autowired
    private UserProfileDataAccessService userProfileDataAccessService;

    @Test
    public void should_return_userProfilesList() {
        List<UserProfile> userProfileList = userProfileDataAccessService.getUserProfiles();
        assertNotNull(userProfileList);
    }

    @Test
    public void should_add_new_profiles() {
        List<UserProfile> userProfileList = userProfileDataAccessService.getUserProfiles();
        userProfileList.add(new UserProfile(
                UUID.fromString("72202d84-1aa1-4055-86fe-a8c545fc5ff8"), "alex", null));
    }


}
