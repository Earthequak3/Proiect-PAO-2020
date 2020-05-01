package com.company;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Angajat {

    int project;
    public Manager(String first_name, String last_name, String domeniul, int status){
        super(first_name,last_name,domeniul,status);
        this.project = 0;

    }
    public Manager(Angajat a){
        super(a.getFirst_name(),a.getLast_name(),a.domeniul_str,a.status);
        this.project = 0;
    }

    public int limit;
    @Override
    public boolean check_limit(){
        return limit != 4;
    }

    public List<Employee> lista_Employee = new ArrayList<>();
    public void Afisare_echipa(){
        for(Employee a : lista_Employee){
            System.out.println(a.getName());
        }
    }


}
