package com.company.model;

import com.company.util.Utilities;

import java.util.Date;



public class Child implements Comparable<Child>{
    private int childId;
    private String child_name;
    private Gender gender;
    private Date doB;
    private String vaccine;
    private String mother_name;
    private Date mother_DoB;


    public Child() {
        this.childId = childId;
        this.child_name = child_name;
        this.gender = gender;
        this.doB = doB;
        this.vaccine = vaccine;
        this.mother_name = mother_name;
        this.mother_DoB = mother_DoB;
    }

    Utilities u = new Utilities();
    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChild_name() {
        return child_name;
    }

    public void setChild_name(String child_name) {
        this.child_name = child_name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getDoB() {
        return doB;
    }

    public void setDoB(Date doB) {
        this.doB = doB;
    }

    public String getVaccine() {
        return vaccine;
    }

    public void setVaccine(String vaccine) {
        this.vaccine = vaccine;
    }

    public String getMother_name() {
        return mother_name;
    }

    public void setMother_name(String mother_name) {
        this.mother_name = mother_name;
    }

    public Date getMother_DoB() {
        return mother_DoB;
    }

    public void setMother_DoB(Date mother_DoB) {
        this.mother_DoB = mother_DoB;
    }

    @Override
    public int hashCode() {
        String id = u.IntegerToString(childId);
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : (id.hashCode()));
        return result;
    }

    @Override
    public String toString(){
        return "Child{"+
                "child_name='" + child_name + '\'' +
                ", gender=" + gender + '\'' +
                ", doB=" + doB + '\'' +
                ", vaccine=" + vaccine + '\'' +
                ", mother_name=" + mother_name + '\'' +
                ", mother_DoB=" + mother_DoB + '\'' +
                  '}';
    }
    @Override
    public int compareTo(Child child) {
        int compareIds = child.getChildId();
        return this.childId - compareIds;
    }
   }
