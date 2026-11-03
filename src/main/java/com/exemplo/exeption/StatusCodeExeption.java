package com.exemplo.exeption;

public abstract class StatusCodeExeption extends RuntimeException 
{
    public StatusCodeExeption(String menssagem) { super(menssagem); }

}
