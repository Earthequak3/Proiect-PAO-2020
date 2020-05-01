package com.company.persistance;

import com.company.AngajatiService;
import com.company.Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistence_Project {

    private static Persistence_Project service = null;
    private final static String PATH = "Proiect.csv";

    public Persistence_Project() {
        System.out.println("Constructor");
    }

    public static Persistence_Project getInstance() {
        if (service == null)
            service = new Persistence_Project();
        return service;
    }

    public void readProjectFromFile(AngajatiService service) {

        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Project p = new Project(service.get_Manager_byname(dataFields[0]),dataFields[1]);
                service.lista_proiecte.add(p);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " projects!");

    }
}
