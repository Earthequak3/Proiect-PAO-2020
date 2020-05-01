package com.company.persistance;

import com.company.Angajat;
import com.company.AngajatiService;
import com.company.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistence_Employee {

    private static Persistence_Employee service = null;
    private final static String PATH = "Employee.csv";

    public Persistence_Employee() {
        System.out.println("Constructor");
    }

    public static Persistence_Employee getInstance() {
        if (service == null)
            service = new Persistence_Employee();
        return service;
    }

    public  void readPersonsFromFile(AngajatiService service) {


            int k = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Angajat a = new Angajat(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                    Employee b = new Employee(a,service.disponibil(a));
                    service.lista_angajati.add(b);
                    k++;
                }


            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return;
            }
            System.out.println("Successfully read " + k + " employees!");



    }
}
