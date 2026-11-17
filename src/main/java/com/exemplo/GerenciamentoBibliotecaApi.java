package com.exemplo;

import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

import com.exemplo.endpoints.EndpointLivros;
import com.exemplo.endpoints.Endpoints;
import com.sun.net.httpserver.HttpServer;

public class GerenciamentoBibliotecaApi
{
    private int port;
    private HttpServer server;
    private Map<String, Endpoints> endpoints = Map.of(
            "/livros",  new EndpointLivros()
    );
    public GerenciamentoBibliotecaApi() throws IOException 
    {
        Dotenv dotenv = Dotenv.load();
        this.port = Integer.valueOf(dotenv.get("PORT"));
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        configureContext();
    }
    private void configureContext()
    {
        for(Map.Entry<String, Endpoints> data : endpoints.entrySet())
        {
            server.createContext(data.getKey(), data.getValue());
        }

    }
    public void run()
    {
        System.out.println("Server rodado na http://localhost:8080/livros");
        server.start();
    }
}
