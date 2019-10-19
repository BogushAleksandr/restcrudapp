package com.ua.SPAREST.backside.restcrudapp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Employee. ")
public class Employee {
    @ApiModelProperty(notes = "ID of Employee", name = "id")
    private int id;
    @ApiModelProperty(notes = "Name of Employee", name = "firstName")
    private String firstName;
    @ApiModelProperty(notes = "Status active of Employee", name = "active")
    private boolean active;
    @ApiModelProperty(notes = "ID of Department", name = "departmentID")
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
