package com.company.entities;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Angajat {

    public int project;
    public int limit;
    public List<Employee> listaEmployee = new ArrayList<>();

    public Manager(String first_name, String last_name, String domeniul, int status) {
        super(first_name, last_name, domeniul, status);
        this.project = 0;

    }

    public Manager(Angajat a) {
        super(a.getFirstName(), a.getLastName(), a.domeniulStr, a.status);
        this.project = 0;
    }

    @Override
    public boolean check_limit() {
        return limit != 4;
    }

    public void Afisare_echipa() {
        for (Employee a : listaEmployee) {
            System.out.println(a.getName());
        }
    }


}
