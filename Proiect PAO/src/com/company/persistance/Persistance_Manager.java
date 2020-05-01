package com.company.persistance;

import com.company.AngajatiService;
import com.company.Manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistance_Manager{

    private static Persistance_Manager service = null;
    private final static String PATH = "Manager.csv";

    public Persistance_Manager() {
        System.out.println("Constructor");
    }

    public static Persistance_Manager getInstance() {
        if (service == null)
            service = new Persistance_Manager();
        return service;
    }

    public  void readPersonsFromFile(AngajatiService service) {


        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");

                Manager a = new Manager(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                service.lista_angajati.add(a);
                service.lista_manageri.add(a);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " managers!");


    }
}