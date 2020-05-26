package com.company.persistance;

import com.company.project.Project;
import com.company.services.AngajatiService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CitireProiect {

    private final static String PATH = "Citire CSV/Proiect.csv";
    private static CitireProiect service = null;

    public static CitireProiect getInstance() {
        if (service == null)
            service = new CitireProiect();
        return service;
    }

    public void readProjectFromFile(AngajatiService service) {

        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                Project p = new Project(service.getManagerByname(dataFields[0]), dataFields[1]);
                service.listaProiecte.add(p);
                k++;
            }


        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + k + " projects!");

    }
}
