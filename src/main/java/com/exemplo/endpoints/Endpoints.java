package com.exemplo.endpoints;

import java.io.IOException;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public abstract class Endpoints implements HttpHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException
    {
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        String resposta = taskEndpoint(exchange);
        if(resposta == null || resposta.isEmpty())
        {
            resposta = "{\"erro\":\"Mensagem invalida!\"}";
            exchange.sendResponseHeaders(500, resposta.getBytes().length);
        }
        OutputStream out = exchange.getResponseBody();
        out.write(resposta.getBytes());
        out.close();
    }
    public abstract String taskEndpoint(HttpExchange exchange) throws IOException;
}