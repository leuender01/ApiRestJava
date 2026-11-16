package com.exemplo.controler.endpoints;
import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RotaRoot implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException 
    {
        String response = "Ola mundo";
        exchange.sendResponseHeaders(200, response.getBytes().length);
        
        System.out.println(exchange.getRemoteAddress() + " conectou!");
        OutputStream os = exchange.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
