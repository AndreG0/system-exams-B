package com.system.exams.exceptions;

public class UserFoundException extends Exception{

    public UserFoundException(){
        super("This username already exists, please try again");
    }
    public UserFoundException(String message){
        super(message);
    }
}
