package com.exemplo.controler;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import io.github.cdimascio.dotenv.Dotenv;

import com.exemplo.controler.endpoints.rotaRoot.RotaRoot;

public class HttpServerApi
{
    private int port;
    private HttpServer server;
    public HttpServerApi() throws IOException
    {
        Dotenv dotenv = Dotenv.configure().load();
        int portEnv = Integer.valueOf( dotenv.get("PORT") );
        server = HttpServer.create(new InetSocketAddress(portEnv), 0);
        server.createContext("/", new RotaRoot());
        server.setExecutor(null);
        this.port = portEnv;
    }
    public void execult()
    {
        this.server.start();
        System.out.println("Servidor rodando na porta http://localhost:" + this.port + "/");
    }
}
