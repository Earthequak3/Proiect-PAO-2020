package com.company.persistance;

import com.company.services.angajatiService;
import com.company.entities.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class citireManageri {

    private static citireManageri service = null;
    private final static String PATH = "Manager.csv";



    public static citireManageri getInstance() {
        if (service == null)
            service = new citireManageri();
        return service;
    }

    public  void readPersonsFromFile(angajatiService service) {


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