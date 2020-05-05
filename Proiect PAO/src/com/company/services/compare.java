package com.company.services;

import com.company.entities.Angajat;

import java.util.Comparator;

public class compare implements Comparator<Angajat> {

    @Override
    public int compare(Angajat o1, Angajat o2) {
        return o1.getStatus()- o2.getStatus();
    }
}