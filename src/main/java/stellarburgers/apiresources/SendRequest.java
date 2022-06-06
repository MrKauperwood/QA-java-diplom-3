package stellarburgers.apiresources;

import io.restassured.response.Response;
import stellarburgers.apiresources.requests.LoginRequest;
import stellarburgers.apiresources.requests.RegisterUserRequest;


import static io.restassured.RestAssured.given;
import static stellarburgers.apiresources.ApiConstants.*;
import static stellarburgers.apiresources.ApiHandlers.HANDLER_POST_LOGIN;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class SendRequest {

    public static Response sendRequestRegisterNewUser(RegisterUserRequest user) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(user)
                        .when()
                        .post(BASE_URI + ApiHandlers.HANDLER_POST_REGISTER_NEW_USER);
    }

    public static Response sendRequestLoginUser(LoginRequest userData) {
        return
                given()
                        .header("Content-type", "application/json")
                        .and()
                        .body(userData)
                        .when()
                        .post(BASE_URI + HANDLER_POST_LOGIN);
    }

    public static Response sendRequestDeleteUser(String token) {
        return
                given()
                        .header("Content-type", "application/json")
                        .header("authorization", token)
                        .when()
                        .delete(BASE_URI + ApiHandlers.HANDLER_DELETE_USER);
    }
}
