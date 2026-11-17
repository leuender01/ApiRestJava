package com.exemplo.endpoints;
import java.io.IOException;
import com.sun.net.httpserver.HttpExchange;

public class EndpointLivros extends Endpoints 
{
    @Override
    public String taskEndpoint(HttpExchange exchange) throws IOException 
    {
        String method = exchange.getRequestMethod();
        System.out.println("Ouve uma requisição metodo " + method);
        
        String response =  "{\"message\" : \"Ok\"}";
        exchange.sendResponseHeaders(200, response.length());
        return response;
    }
}
