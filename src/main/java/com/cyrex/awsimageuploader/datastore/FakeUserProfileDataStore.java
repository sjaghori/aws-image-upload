package com.cyrex.awsimageuploader.datastore;

import com.cyrex.awsimageuploader.profile.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class FakeUserProfileDataStore {

    private static final List<UserProfile> USER_PROFILE_LIST = new ArrayList<>();

    static {
        USER_PROFILE_LIST.add(new UserProfile(UUID.fromString("72202d84-1aa1-4055-86fe-a8c5c7fc5ff8"), "sasanjaghori", null));
        USER_PROFILE_LIST.add(new UserProfile(UUID.fromString("63d5745b-665f-4ac2-ba11-a769c823246a"), "denizoezalp", null));
        // USER_PROFILE_LIST.add(new UserProfile(UUID.randomUUID(), "denizoezalp", null));
    }

    public void addUser(UserProfile userProfile) {
        USER_PROFILE_LIST.add(userProfile);
    }

    public List<UserProfile> getUserProfiles() {
        return USER_PROFILE_LIST;
    }

}
