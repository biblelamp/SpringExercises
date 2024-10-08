package com.iprody;

import com.iprody.user.profile.UserProfileApplication;
import com.iprody.user.profile.test.ApiClient;
import com.iprody.user.profile.test.controller.UserApi;
import com.iprody.user.profile.test.controller.dto.UserDTO;
import jakarta.annotation.PostConstruct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = UserProfileApplication.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    static final String DEFAULT_URI = "http://localhost";
    static final String REST_CONTROLLER_URL = "/api";

    @LocalServerPort //@Value("${local.server.port}")
    private int port;

    private UserApi userApi;

    @PostConstruct
    public void setUp() {
        ApiClient apiClient = new ApiClient();
        apiClient.setBasePath(DEFAULT_URI + ":" + port + REST_CONTROLLER_URL);
        userApi = new UserApi(apiClient);
    }

    @Test
    public void addUser() {
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Smith");
        Integer userId = userApi.addUser(userDTO);

        Assertions.assertNotNull(userId);
    }
}
