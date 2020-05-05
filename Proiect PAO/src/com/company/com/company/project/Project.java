package com.company.project;
import com.company.entities.Manager;

import java.util.Date;

public class Project {

    public  Manager manager;
    public  String nume;
    public  Date date;
   public Project(Manager b, String nume){
        this.manager = b;
        this.nume = nume;
        this.date = new Date();
        b.project ++;
    }



}


