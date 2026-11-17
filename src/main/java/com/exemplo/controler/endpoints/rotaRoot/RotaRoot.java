package com.exemplo.controler.endpoints.rotaRoot;
import java.io.IOException;
import java.io.OutputStream;

import com.exemplo.dtos.JsonReposta;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;


public class RotaRoot implements HttpHandler 
{
    @Override
    public void handle(HttpExchange exchange) throws IOException 
    {
        String response;
        String method = exchange.getRequestMethod();
        exchange.getResponseHeaders().set("Content-Type", "application/json");

        if(method.toUpperCase().equals("GET"))
        {
            response = response("Ola mundo!");
            exchange.sendResponseHeaders(200, response.getBytes().length);
        } else {
            response =  response("Mensagem invalida!");
            exchange.sendResponseHeaders(400, response.getBytes().length);
        }

        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
    private String response(String data) throws JsonProcessingException
    {
        ObjectMapper json = new ObjectMapper();
        JsonReposta jsonReposta = new JsonReposta(data);
        return json.writeValueAsString(jsonReposta);
    }
}
