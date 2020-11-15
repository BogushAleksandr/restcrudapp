package com.ua.SPAREST.backside.restcrudapp.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Bogush Aleksandr
 * @version 1.0
 * @since 15-11-2020
 */

@ApiModel(description = "All details about the Deparment.")
public class Department {
    @ApiModelProperty(notes = "ID of Department", name = "id")
    private int id;
    @ApiModelProperty(notes = "Name of Department", name = "name")
    private String name;


    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name;
    }
}
