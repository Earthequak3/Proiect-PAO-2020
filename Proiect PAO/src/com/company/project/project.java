package com.company.project;
import com.company.entities.Manager;

import java.util.Date;

public class project {

    public  Manager manager;
    public  String nume;
    public  Date date;
   public project(Manager b, String nume){
        this.manager = b;
        this.nume = nume;
        this.date = new Date();
        b.project ++;
    }



}


