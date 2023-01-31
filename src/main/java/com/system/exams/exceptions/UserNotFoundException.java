package com.system.exams.exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(){
        super("This username does not exist in the database, please try again");
    }
    public UserNotFoundException(String message){
        super(message);
    }
}
