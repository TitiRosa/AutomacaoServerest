package br.com.Util.Models;

public class Request {
    private final ServeRest buscarToken = new ServeRest();
    private final String url = "https://serverest.dev/";
    private String obterToken(){
        return buscarToken.token();
    }
}
