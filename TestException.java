package fr.sciam;

public class TestException extends Exception {

    public String notValue(String message){
        message = "no value";
        return message;
    }
}
