package com.cyrex.awsimageuploader;

import com.cyrex.awsimageuploader.profile.UserProfileDataAccessService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UserProfileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserProfileDataAccessService service;

    /*
    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {

        UserProfile alex = new UserProfile(
                UUID.fromString("72202d84-1aa1-4055-86fe-a8c545fc5ff8"), "alex", null);

        List<UserProfile> allEmployees = Arrays.asList(alex);

        given(service.).willReturn(allEmployees);

        mvc.perform(get("api/v1/user-profile")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is(alex.getName())));
    }
    */


    @Test
    public void getShouldgiveUserProfileList() throws Exception {
        this.mockMvc.perform(get("api/v1/user-profile")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}
