package com.company.ui;

import com.company.exceptions.InvalidDateFormat;
import com.company.model.Child;
import com.company.model.Gender;
import com.company.util.Utilities;

import java.text.ParseException;
import java.util.Scanner;

public class ChildUI {
        static Scanner sc = new Scanner(System.in);
        static Child child = new Child();
        Utilities utility = new Utilities();
        public static Child captureChildDetails() throws ParseException, InvalidDateFormat {
            System.out.println("Enter child ID");
            child.setChildId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter name of child");
            child.setChild_name(sc.nextLine());
            System.out.println("Enter the gender of child");
            child.setGender(Gender.valueOf(sc.nextLine()));
            System.out.println("Enter Child's DoB");
            child.setDoB(Utilities.dateParser(sc.nextLine()));
            System.out.println("Enter name of mother");
            child.setChild_name(sc.nextLine());
            System.out.println("Enter date of birth of mother");
            child.setMother_DoB(Utilities.dateParser(sc.nextLine()));
            return child;
        }
        public static Child updateChild() throws InvalidDateFormat {
            System.out.println("Enter child ID");
            child.setChildId(sc.nextInt());
            sc.nextLine();
            System.out.println("Enter name of child");
            child.setChild_name(sc.nextLine());
            System.out.println("Enter the gender of child");
            child.setGender(Gender.valueOf(sc.nextLine()));
            System.out.println("Enter Child's DoB");
            child.setDoB(Utilities.dateParser(sc.nextLine()));
            System.out.println("Enter name of mother");
            child.setChild_name(sc.nextLine());
            System.out.println("Enter date of birth of mother");
            child.setMother_DoB(Utilities.dateParser(sc.nextLine()));
            return child;
        }

        public static int searchChild(){
            System.out.println("Enter child Id");
            int id= sc.nextInt();
            sc.nextLine();
            return id;
        }

        public static int deleteChild() {
            System.out.println("Enter details of child to delete");
            return searchChild();
        }
        public static void childMenu() throws InvalidDateFormat, ParseException {
            int choice;
            System.out.println("Welcome to Child Clinic Journey System");
            System.out.println("Select your option bellow");
            System.out.println(" 1. Add new Child\n" +
                    " 2. Search Child\n" +
                    " 3. Delete Child\n" +
                    " 0. Exit\n");
            choice = sc.nextInt();
            sc.nextLine();
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    captureChildDetails();
                    break;
                case 2:
                    searchChild();
                    break;
                case 3:
                    deleteChild();
                    break;
            }while (choice != 0);
        }
}

