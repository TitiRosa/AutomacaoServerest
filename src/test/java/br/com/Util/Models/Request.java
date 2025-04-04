package br.com.Util.Models;

import io.restassured.http.Method;
import io.restassured.mapper.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Request {
    private final ServeRest buscarToken = new ServeRest();
    private final ObjectMapper objectMapper;
    private final String url = "https://serverest.dev/";

    public Request() {
        objectMapper = new ObjectMapper() {
            @Override
            public Object deserialize(ObjectMapperDeserializationContext context) {
                return null;
            }

            @Override
            public Object serialize(ObjectMapperSerializationContext context) {
                return null;
            }
        };
    }


    private String obterToken(){
        return buscarToken.token();
    }
    public <T> boolean Get(String metodo, Class<T> type){
        Response response = given()
                .auth().oauth2(obterToken())
                .request(Method.GET, url + metodo);
    return objectMapper.equals(response.body().asString());
    }
}
