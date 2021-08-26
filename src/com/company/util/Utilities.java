package com.company.util;

import com.company.exceptions.InvalidDateFormat;
import com.company.model.Child;

import java.awt.print.Book;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Utilities {


        static SimpleDateFormat simpledate = new SimpleDateFormat("dd-mm-YYYY");
        public String toCamelCase(String genderCase){
            return genderCase.substring(0,1).toUpperCase()+genderCase.substring(1);
        }
        public String dateFormatter(Date date){
            return simpledate.format(date);
        }
        public static Date dateParser(String date) throws InvalidDateFormat {
            try {
                return simpledate.parse(date);
            } catch (ParseException e) {
                throw new InvalidDateFormat();
            }
        }

    public ArrayList<Child> resultSetToObjects(ResultSet rs) throws SQLException, ParseException, InvalidDateFormat {
        Utilities u = new Utilities();
        ArrayList<Child> records = new ArrayList<>();
        while (rs.next()){
            records.add(new Child());
        }
        return records;
    }

        public String IntegerToString(int n){
            return String.valueOf(n);
    }
}
