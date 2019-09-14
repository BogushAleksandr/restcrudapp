package com.ua.SPAREST.backside.restcrudapp.entity;

public class Employee {
    private int id;
    private String firstName;
    private boolean active;
    private int departmentID;

    public Employee(int id, String firstName, boolean active, int departmentID) {
        this.id = id;
        this.firstName = firstName;
        this.active = active;
        this.departmentID = departmentID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }
}
