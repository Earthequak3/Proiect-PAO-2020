package com.company;
import java.util.Date;

public class Project {

    Manager manager;
    String nume;
    Date date;
    Project(Manager b,String nume){
        this.manager = b;
        this.nume = nume;
        this.date = new Date();
    }


}


