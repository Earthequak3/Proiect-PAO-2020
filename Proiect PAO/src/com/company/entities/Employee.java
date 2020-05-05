package com.company.entities;

public class Employee extends Angajat {

    private String sef_id;

    public Employee(String first_name, String last_name, String domeniul, int status, Manager sef){
        super(first_name,last_name,domeniul,status);
        sef_id = sef.getReal_id();
        sef.limit++;


    }
    public Employee(Angajat a, Manager sef){
        super(a.getFirstName(),a.getLastName(),a.domeniulStr,a.status);
        sef_id = sef.getReal_id();
        sef.limit++;

    }


    public String getSefId(){
        return sef_id;
    }



}