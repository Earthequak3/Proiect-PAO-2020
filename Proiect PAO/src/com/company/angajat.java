package com.company;

public class angajat extends Angajati {

    private String sef_id;

    public angajat(String first_name, String last_name, String domeniul, int status,Manager sef){
            super(first_name,last_name,domeniul,status);
            sef_id = "" + sef.status + sef.domeniul + ID;
            sef.limit++;

    }
    public angajat(Angajati a,Manager sef){
        super(a.getFirst_name(),a.getFirst_name(),a.domeniul_str,a.status);
        sef_id = "" + sef.status + sef.domeniul + ID;
        sef.limit++;
    }

    public String getSef_id(){
        return sef_id;
    }



}
