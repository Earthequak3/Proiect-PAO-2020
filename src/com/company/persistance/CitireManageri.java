package com.company.persistance;

import com.company.entities.Manager;
import com.company.services.AngajatiService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireManageri {

    private final static String PATH = "Citire CSV/Manager.csv";
    private static CitireManageri service = null;

    public static CitireManageri getInstance() {
        if (service == null)
            service = new CitireManageri();
        return service;
    }

    public void readPersonsFromFile(AngajatiService service) {


        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");

                Manager a = new Manager(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                service.listaAngajati.add(a);
                service.listaManageri.add(a);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " managers!");


    }
}