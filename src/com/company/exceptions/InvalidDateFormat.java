package com.company.exceptions;

public class InvalidDateFormat extends Exception {
    public InvalidDateFormat() {
        super("Invalid date entered");
    }
}
