package stellarburgers.apiresources.requests;

import java.util.List;

/**
 * Author: Alexey Bondarenko
 * Date: 06.06.2022
 */
public class CreateOrderRequest {

    private List<String> ingredients;

    public CreateOrderRequest(List<String> ingredients) {
        this.ingredients = ingredients;
    }
}
