package com.company;

import java.util.Comparator;

public class Compare implements Comparator<Angajat> {

    @Override
    public int compare(Angajat o1, Angajat o2) {
        return o1.status - o2.status;
    }
}