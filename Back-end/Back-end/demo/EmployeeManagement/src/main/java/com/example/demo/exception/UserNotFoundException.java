package com.example.demo.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message) {
        //I call the constructor to pass the message ("User by id " + id + " was not found!" in this case) to the super class
        super(message);
    }
}
