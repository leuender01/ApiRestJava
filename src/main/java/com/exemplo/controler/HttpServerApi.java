package com.exemplo.controler;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;
import com.exemplo.controler.endpoints.RotaRoot;

public class HttpServerApi
{
    private int port;
    private HttpServer server;
    public HttpServerApi(int port) throws IOException
    {
        this.server = HttpServer.create(new InetSocketAddress(port), 0);
        this.server.createContext("/", new RotaRoot());
        this.server.setExecutor(null);
        this.port = port;
    }
    public void execult()
    {
        this.server.start();
        System.out.println("Servidor rodando na porta http://localhost:" + this.port + "/");
    }
}
