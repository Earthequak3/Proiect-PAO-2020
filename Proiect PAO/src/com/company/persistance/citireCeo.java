package com.company.persistance;

import com.company.services.angajatiService;
import com.company.entities.Ceo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class citireCeo {

    private static citireCeo service = null;
    private final static String PATH = "CEO.csv";


    public static citireCeo getInstance() {
        if (service == null)
            service = new citireCeo();
        return service;
    }

    public  void readPersonsFromFile(angajatiService service) {


        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");

                Ceo a = new Ceo(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                service.listaAngajati.add(a);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " CEOs!");


    }
}