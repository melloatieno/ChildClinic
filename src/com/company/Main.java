package com.company;

import com.company.exceptions.InvalidDateFormat;
import com.company.ui.ChildUI;

import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws InvalidDateFormat, ParseException {
        ChildUI childUI = new ChildUI();
        ChildUI.childMenu();
    }
}
