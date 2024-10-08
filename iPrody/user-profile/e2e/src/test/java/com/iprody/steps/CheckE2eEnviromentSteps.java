package com.iprody.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class CheckE2eEnviromentSteps {

    @Given("API Service is started")
    public void given() {
    }

    @When("I run test")
    public void when() {
    }

    @Then("Test should be finished successfully")
    public void then() {
        Assertions.assertTrue(true);
    }

}
