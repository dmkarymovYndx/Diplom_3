package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import ru.yandex.praktikum.api.UserDataClient;

import static io.restassured.RestAssured.given;

import static ru.yandex.praktikum.constants.Endpoints.*;

public class ApiActions {

    // регистрация пользователя
    @Step
    public static Response userRegister(String email, String password, String name) {

        RestAssured.baseURI = STELLARBURGERS_URL;
        UserDataClient user = new UserDataClient(email, password, name);

        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(USER_REGISTER);

    }

    // авторизация пользователя
    @Step
    public static Response userLogin(String email, String password) {

        RestAssured.baseURI = STELLARBURGERS_URL;
        UserDataClient user = new UserDataClient(email, password);

        return given()
                .header("Content-type", "application/json")
                .and()
                .body(user)
                .when()
                .post(USER_LOGIN);

    }

    // удаление пользователя
    @Step
    public static void userDelete(String email, String password) {

        RestAssured.baseURI = STELLARBURGERS_URL;
        Response loginResponse = userLogin(email, password);
        String accessToken = loginResponse.jsonPath().getString("accessToken");

        given()
                .header("Authorization", accessToken)
                .when()
                .delete(USER_AUTH);

    }

}
