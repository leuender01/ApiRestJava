package com.exemplo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import  static org.junit.jupiter.api.Assertions.assertThrows;
        

import com.exemplo.controler.RequestCep;
import com.exemplo.dtos.EnderecoDto;
import com.exemplo.exeption.StatusCode400Exeption;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RequestCepTest 
{
    @Test
    public void testStatusCode400() 
    {
        RequestCep requestCep = new RequestCep();
        String valor = "Status code 400";
        StatusCode400Exeption exeption = assertThrows(StatusCode400Exeption.class, () -> {
            EnderecoDto  enderecoDto = requestCep.request("7446377");
            System.out.println(enderecoDto);
        });
        assertEquals(valor, exeption.getMessage());
    }
    @Test
    public void testStatusCode200()
    {
        RequestCep requestCep = new RequestCep();
        try {
            EnderecoDto  enderecoDto = requestCep.request("74463770");
            System.out.println(enderecoDto);
            assertTrue( true );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(false);
        }
    }
    @Test
    public void CompletableFutureTest() throws InterruptedException, ExecutionException
    {
        RequestCep requestCep = new RequestCep();
        CompletableFuture<String> completableFuture =  CompletableFuture.supplyAsync(() -> {
            try {
                EnderecoDto enderecoDto = requestCep.request("01001000");
                return enderecoDto.toString();
            } catch (Exception e) {
                return null;
            }
        });
        for (int i = 0; i < 10000; i++) {
            System.out.print("te");
            }
        
        assertTrue(completableFuture.get() != null);
    }
}
