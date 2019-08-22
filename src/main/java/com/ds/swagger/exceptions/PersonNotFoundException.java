package com.ds.swagger.exceptions;

public class PersonNotFoundException extends Exception {

    public PersonNotFoundException() {
        super("Person not found!!!");
    }
}
