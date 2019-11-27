package com.main.sqlcrud.message.response;

public class ResponseMessage{
    private int code;
    private String message;

    public ResponseMessage() {
    }
    
    public ResponseMessage(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

   

   
}