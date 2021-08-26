package com.company.logic;

import com.company.exceptions.InvalidDateFormat;
import com.company.exceptions.UnableToLoadDriver;
import com.company.interfaces.LogicIn;
import com.company.model.Child;
import com.company.ui.ChildUI;
import com.company.util.DbUtil;
import com.company.util.Utilities;

import java.awt.print.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ChildLogic implements LogicIn<Child> {
    DbUtil db = new DbUtil();
    Utilities u = new Utilities();

    public ChildLogic() throws SQLException, UnableToLoadDriver, ParseException, InvalidDateFormat, ClassNotFoundException {
    }

    @Override
    public boolean add(Child child) throws SQLException {
        return (db.create("INSERT INTO child_tbl VALUES('"+child.getChildId()+"','"+child.getChild_name()+"','"+child.getGender()+"','"+u.dateFormatter(child.getDoB())+"','"+child.getMother_name()+"','"+u.dateFormatter(child.getMother_DoB())+"')")==0)?false:true;
    }

    @Override
    public boolean update(Child child, int childId) throws SQLException {
        return (db.update("UPDATE child_tbl SET childId='"+child.getChildId()+"',name='"+child.getChild_name()+"',gender='"+child.getGender()+"',`date`='"+u.dateFormatter(child.getDoB())+"'mother_name='"+child.getMother_name()+"',`mother_dob`='"+u.dateFormatter(child.getMother_DoB())+"' WHERE childId='"+childId+"'"))?false:true;
    }

    @Override
    public ResultSet read(Child child) throws SQLException {
        return db.readData("SELECT FROM child_tbl WHERE childId = '"+child.getChildId()+"'");
    }

    @Override
    public boolean delete(Child child) throws SQLException {
        return db.delete("DELETE FROM child_tbl WHERE childId='"+child.getChildId()+"'");
    }

    @Override
    public ResultSet search(String sql) throws SQLException {
        return db.readData(sql);
    }
    @Override
    public ResultSet displayAll() throws SQLException {
        return this.search("select * from child_tbl");
    }
    public ResultSet displaySingle(int childId) throws SQLException {
        return this.search("SELECT * FROM child_tbl WHERE childId='"+childId+"'");
    }
    public void deleteChild(int childId) throws SQLException, ParseException, InvalidDateFormat {
        if (this.checkIfExists(childId)){
            System.out.println("You are about to delete the book with the following details");
            ArrayList<Child> child = new Utilities().resultSetToObjects(this.displaySingle(childId));
            Child ch = child.get(0);
            System.out.println(ch);
            System.out.println("Do you want to proceed? y/n");
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().equalsIgnoreCase("y")){
                System.out.println((this.delete(ch))?"Successfully deleted":"failed to delete");
            }
        }
        else {
            System.out.println("child With such Id not found");
        }
    }
    public void updateChild(int childId) throws SQLException, ParseException, InvalidDateFormat {
        if (this.checkIfExists(childId)){
            System.out.println("You are about to update the book with the following details");
            ArrayList<Child> child = new Utilities().resultSetToObjects(this.displaySingle(childId));
            Child ch = child.get(0);
            System.out.println(child);
            System.out.println("Do you want to proceed? y/n");
            Scanner sc = new Scanner(System.in);
            if (sc.nextLine().equalsIgnoreCase("y")){
                Child newChild = new ChildUI().updateChild();
                System.out.println((this.update(newChild,childId))?"failed to update":"successfully updated");
            }
        }
        else {
            System.out.println("child not found");
        }
    }
    public boolean checkIfExists(int bookId) throws SQLException {
        ResultSet rs = db.readData("SELECT * FROM child_tbl WHERE bookId='"+bookId+"'");
        if (rs.next()){
            return true;
        }
        else {
            return false;
        }

    }
}
