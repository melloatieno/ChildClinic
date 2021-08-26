package com.company.exceptions;

public class UnableToLoadDriver extends Exception{
    public UnableToLoadDriver() {
        super("Unable to load mysql jdbc driver class");
    }
}
