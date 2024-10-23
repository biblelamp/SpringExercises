package com.iprody.steps;

import com.iprody.user.profile.UserProfileApplication;
import com.iprody.user.profile.controller.UserApi;
import com.iprody.user.profile.controller.dto.UserDTO;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.Map;

@SpringBootTest(classes = UserProfileApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
public class UserProfileSteps {

    @Autowired
    UserApi userApi;

    private UserDTO userDTO;
    private HttpStatusCode httpStatusCode;

    @Given("Create UserDTO")
    public void createUserDTO(Map<String, String> data) {
        userDTO = new UserDTO();
        userDTO.setFirstName(data.get("firstName"));
        userDTO.setLastName(data.get("lastName"));
    }

    @When("Sent post request to create User")
    public void createUser() {
        ResponseEntity<Integer> addUserResponse = userApi.addUser(userDTO);
        Integer userId = addUserResponse.getBody();
        httpStatusCode = addUserResponse.getStatusCode();
        Assertions.assertNotNull(userId);
    }

    @Then("Response code is {int}")
    public void responseCodeIs(int responseStatusCode) {
        Assertions.assertEquals(responseStatusCode, httpStatusCode.value());
    }
}
