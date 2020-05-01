package com.company.persistance;

import com.company.AngajatiService;
import com.company.CEO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistance_CEO{

    private static Persistance_CEO service = null;
    private final static String PATH = "CEO.csv";

    public Persistance_CEO() {
        System.out.println("Constructor");
    }

    public static Persistance_CEO getInstance() {
        if (service == null)
            service = new Persistance_CEO();
        return service;
    }

    public  void readPersonsFromFile(AngajatiService service) {


        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");

                CEO a = new CEO(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                service.lista_angajati.add(a);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " CEOs!");


    }
}