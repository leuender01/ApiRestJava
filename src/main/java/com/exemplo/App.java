package com.exemplo;

import com.exemplo.dtos.EnderecoDto;
import com.exemplo.exeption.StatusCode400Exeption;

public class App 
{
    public static void main( String[] args ) 
    {
        ApiRest apiRest = new ApiRest();
        try {
            EnderecoDto enderecoDto = apiRest.request("74463770");
            System.out.println(enderecoDto);
        } catch (StatusCode400Exeption e) {
            System.out.println("\033[31;1m" + e.getMessage() + "\033[0m");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        /*
        try {
            Pessoa pessoa = new Pessoa("João", 30);
            String json = objectMapper.writeValueAsString(pessoa);
            System.out.println(json);

            String jsonExemploString = "{\"nome\":\"Leuender\",\"idade\":30}";
            Pessoa pessoaConvertida = objectMapper.readValue(jsonExemploString, Pessoa.class);
            System.out.println(pessoaConvertida);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        */
    }
}
