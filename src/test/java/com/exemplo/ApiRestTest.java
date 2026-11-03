package com.exemplo;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import  static org.junit.jupiter.api.Assertions.assertEquals;
import  static org.junit.jupiter.api.Assertions.assertThrows;
import com.exemplo.dtos.EnderecoDto;
import com.exemplo.exeption.StatusCode400Exeption;

public class ApiRestTest 
{
    @Test
    public void testStatusCode400() 
    {
        ApiRest apiRest = new ApiRest();
        String valor = "Status code 400";
        StatusCode400Exeption exeption = assertThrows(StatusCode400Exeption.class, () -> {
            EnderecoDto  enderecoDto = apiRest.request("7446377");
            System.out.println(enderecoDto);
        });
        assertEquals(valor, exeption.getMessage());
    }
    @Test
    public void testStatusCode200()
    {
        ApiRest apiRest = new ApiRest();
        try {
            EnderecoDto  enderecoDto = apiRest.request("74463770");
            System.out.println(enderecoDto);
            assertTrue( true );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            assertTrue(false);
        }
    }
}
