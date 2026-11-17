package com.exemplo;


public class Main 
{
    public static void main( String[] args ) 
    {
        try {
            GerenciamentoBibliotecaApi gerenciamentoBibliotecaApi = new GerenciamentoBibliotecaApi();
            gerenciamentoBibliotecaApi.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
