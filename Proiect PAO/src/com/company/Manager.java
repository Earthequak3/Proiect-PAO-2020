package com.company;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Angajati{
    public Manager(String first_name, String last_name, String domeniul, int status){
        super(first_name,last_name,domeniul,status);

    }
    public Manager(Angajati a){
        super(a.getFirst_name(),a.getLast_name(),a.domeniul_str,a.status);
    }
    public Manager(){}
    public int limit;
    @Override
    public boolean check_limit(){
        if(limit == 4)
            return false;
        return true;
    }

    public List<Employee> lista_Employee = new ArrayList<>();
    public void Afisare_echipa(){
        for(Employee a : lista_Employee){
            System.out.println(a.getName());
        }
    }


}
