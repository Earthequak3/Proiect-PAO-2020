package com.company.services;

import com.company.entities.Angajat;

import java.util.Comparator;

public class Compare implements Comparator<Angajat> {

    @Override
    public int compare(Angajat o1, Angajat o2) {
        if(o1.getStatus()- o2.getStatus() != 0)
        return o1.getStatus()- o2.getStatus();
        return o1.getName().compareToIgnoreCase(o2.getName());
    }

}