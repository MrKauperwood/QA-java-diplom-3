package stellarburgers.apiresources;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.junit.Assert;
import stellarburgers.apiresources.requests.LoginRequest;
import stellarburgers.apiresources.requests.RegisterUserRequest;
import stellarburgers.apiresources.responses.AuthorizationAndRegistrationResponse;
import stellarburgers.apiresources.responses.FailedResponse;
import stellarburgers.apiresources.responses.FullUserInformation;
import stellarburgers.apiresources.responses.LoginResponse;

import java.util.HashMap;

import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_OK;
import static stellarburgers.apiresources.SendRequest.*;
import static stellarburgers.resources.Steps.generateDataForNewUser;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class UserSteps {

    @Step("Register new user")
    public static FullUserInformation registerNewUser() {
        HashMap<String, String> newUserData = generateDataForNewUser();
        RegisterUserRequest registerUserRequest = new RegisterUserRequest(
                newUserData.get("email"),
                newUserData.get("password"),
                newUserData.get("name"));

        Response response = sendRequestRegisterNewUser(registerUserRequest);
        if (response.getStatusCode() != SC_OK) {
            FailedResponse failedResponse = response.as(FailedResponse.class);
            Assert.assertEquals("User wasn't created. Error msg:\n" + failedResponse.getMessage(), SC_OK, response.getStatusCode());
        }
        FullUserInformation fullUserInformation = new FullUserInformation(
                response.as(AuthorizationAndRegistrationResponse.class).getAccessToken(),
                registerUserRequest);

        return fullUserInformation;
    }

    @Step("Get token")
    public static String getToken(HashMap<String, String> registeredUser) {
        LoginRequest loginRequest = new LoginRequest(registeredUser.get("email"), registeredUser.get("password"));
        Response loginResponse = sendRequestLoginUser(loginRequest);
        loginResponse.then().statusCode(SC_OK);
        return loginResponse.as(LoginResponse.class).getAccessToken();
    }

    @Step("Get token from RegisterUserRequest")
    public static String getTokenFromClass(RegisterUserRequest registerUserRequest) {
        LoginRequest loginRequest = new LoginRequest(registerUserRequest.getEmail(), registerUserRequest.getPassword());
        Response loginResponse = sendRequestLoginUser(loginRequest);
        loginResponse.then().statusCode(SC_OK);
        return loginResponse.as(LoginResponse.class).getAccessToken();
    }

    @Step("Login user")
    public static LoginResponse loginUnderUser(RegisterUserRequest registeredUser) {
        LoginRequest loginRequest = new LoginRequest(registeredUser.getEmail(), registeredUser.getPassword());
        Response loginResponse = sendRequestLoginUser(loginRequest);
        loginResponse.then().statusCode(SC_OK);
        return loginResponse.as(LoginResponse.class);
    }

    @Step("Delete registered user")
    public static void deleteUser(String token) {
        Response createOrderResponse = sendRequestDeleteUser(token);
        assert (createOrderResponse.getStatusCode() == SC_ACCEPTED);
    }


}
