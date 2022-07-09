package stellarburgers.apiresources.responses;

import stellarburgers.apiresources.requests.RegisterUserRequest;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class FullUserInformation {

    private String accessToken;
    private RegisterUserRequest userData;

    public FullUserInformation(String accessToken, RegisterUserRequest userData) {
        this.accessToken = accessToken;
        this.userData = userData;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public RegisterUserRequest getUserData() {
        return userData;
    }
}
