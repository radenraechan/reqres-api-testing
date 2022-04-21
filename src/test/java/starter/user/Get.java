package starter.user;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;

public class Get {

    protected static String url = "https://reqres.in/api/";

    @Step("I set GET api endpoints")
    public String setApiEndpoint() {
        return url + "users/2";
    }

    @Step("I send GET HTTP request")
    public void sendGetHttpRequest() {
        SerenityRest.given().get(setApiEndpoint());
    }

    @Step("I receive valid HTTP response")
    public void validateHttpResponseCode(int code) {
        restAssuredThat(response -> response.statusCode(code));
    }

    @Step("I receive valid data for detail user")
    public void validateDataDetailUser() {
        restAssuredThat(response -> response.body("'data'.'id'", equalTo(2)));
        restAssuredThat(response -> response.body("'data'.'first_name'", equalTo("Janet")));
    }

    @Step("I set invalid GET api endpoints")
    public String setInvalidApiEndpoint() {
        return url + "users/x";
    }

    @Step("I send invalid GET HTTP request")
    public void sendInvalidGetHttpRequest() {
        SerenityRest.given().get(setInvalidApiEndpoint());
    }

    @Step("I don't receive valid HTTP response")
    public void validateInvalidHttpResponseCode(int code) {
        restAssuredThat(response -> response.statusCode(code));
    }

    @Step("I don't receive valid data for detail user")
    public void validateInvalidDataDetailUser() {
        restAssuredThat(response -> response.body("'data'.'id'", equalTo(null)));
        restAssuredThat(response -> response.body("'data'.'first_name'", equalTo(null)));
    }

}
