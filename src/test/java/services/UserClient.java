package services;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.User;

public class UserClient {

    private static final String CREATE_ENDPOINT = "/api/auth/register";

    @Step("Создать пользователя через API")
    public Response createUser(User user) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .body(user)
                .post(CREATE_ENDPOINT);
    }
}