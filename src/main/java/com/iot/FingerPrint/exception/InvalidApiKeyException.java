package com.iot.FingerPrint.exception;

public class InvalidApiKeyException extends RuntimeException{
    public InvalidApiKeyException(String message){
        super(message);
    }
}
