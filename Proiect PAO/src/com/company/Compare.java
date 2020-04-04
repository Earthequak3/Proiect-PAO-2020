package com.company;

import java.util.Comparator;

public class Compare implements Comparator<Angajati> {

    @Override
    public int compare(Angajati o1, Angajati o2) {
        return o1.status - o2.status;
    }
}