package com.exemplo.controler;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.net.URI;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.exemplo.dtos.EnderecoDto;
import com.exemplo.exeption.StatusCode400Exeption;

public class RequestCep 
{
    public EnderecoDto request(String cep) throws StatusCode400Exeption, IOException, InterruptedException
    {
        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/")).build();
        HttpResponse<String> response = client
            .send(request, HttpResponse.BodyHandlers.ofString());

        if(response.statusCode() == 400) throw new StatusCode400Exeption();

        return objectMapper.readValue(response.body(), EnderecoDto.class);
    }
}
