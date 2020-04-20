package com.company;

public class Employee extends Angajati {

    private String sef_id;

    public Employee(String first_name, String last_name, String domeniul, int status,Manager sef){
        super(first_name,last_name,domeniul,status);
        sef_id = sef.getReal_id();
        sef.limit++;


    }
    public Employee(Angajati a,Manager sef){
        super(a.getFirst_name(),a.getLast_name(),a.domeniul_str,a.status);
        sef_id = sef.getReal_id();
        sef.limit++;

    }

    public String getSef_id(){
        return sef_id;
    }



}