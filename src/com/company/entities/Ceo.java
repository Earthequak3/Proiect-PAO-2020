package com.company.entities;

public class Ceo extends Angajat {

    public Ceo(String first_name, String last_name, String domeniul, int status) {
        super(first_name, last_name, "CEO", 3);
    }


    @Override
    public double calc_salariu() {
        return 9000;
    }
}


