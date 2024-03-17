package com.vitorlucascrispim.cubochallenge.exceptions;

public class ExceptionGenerica extends RuntimeException{

    public ExceptionGenerica(String message){
        super(message);
    }

    public ExceptionGenerica(String message,Throwable cause) {
        super(message,cause);
    }
}
