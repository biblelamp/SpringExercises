package com.iprody;

import com.iprody.user.profile.Application;
import com.iprody.user.profile.test.ApiClient;
import com.iprody.user.profile.test.controller.UserApi;
import com.iprody.user.profile.test.controller.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = Application.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    static final String DEFAULT_URI = "http://localhost";
    static final String REST_CONTROLLER_URL = "/api";

    @Value("${local.server.port}")
    private int port;

    private ApiClient apiClient;

    private UserApi userApi;

//    @BeforeAll
//    public static void setUp() {
//        apiClient = new ApiClient();
//        apiClient.setBasePath("http://localhost:8080/api");
//
//        userApi = new UserApi(apiClient);
//    }

    @Test
    public void addUser() {
        apiClient = new ApiClient();
        apiClient.setBasePath(DEFAULT_URI + ":" + port + REST_CONTROLLER_URL);
        userApi = new UserApi(apiClient);

        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("John");
        userDTO.setLastName("Smith");
        Integer userId = userApi.addUser(userDTO);

        Assertions.assertNotNull(userId);
    }
}
