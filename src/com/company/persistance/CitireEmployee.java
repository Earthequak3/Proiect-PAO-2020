package com.company.persistance;

import com.company.entities.Angajat;
import com.company.entities.Employee;
import com.company.services.AngajatiService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireEmployee {

    private final static String PATH = "Citire CSV/Employee.csv";
    private static CitireEmployee service = null;

    public static CitireEmployee getInstance() {
        if (service == null)
            service = new CitireEmployee();
        return service;
    }

    public void readPersonsFromFile(AngajatiService service) {


        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Angajat a = new Angajat(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                Employee b = new Employee(a, service.isAvailable(a));
                service.listaAngajati.add(b);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " employees!");


    }
}
