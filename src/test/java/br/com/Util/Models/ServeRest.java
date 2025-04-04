package br.com.Util.Models;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static io.restassured.RestAssured.given;

public class ServeRest {

    @Test
    @DisplayName("GetToken")
    public String token(){
        String baseURI = "https://serverest.dev";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("login.json");

        String token = given()
                .contentType(ContentType.JSON)
                .body(inputStream)
                .when()
                .post("/login")
                .then()
                .extract()
                .path("accessToken");
        return token;
    }
}
