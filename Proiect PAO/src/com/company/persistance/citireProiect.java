package com.company.persistance;

import com.company.services.angajatiService;
import com.company.project.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class citireProiect {

    private static citireProiect service = null;
    private final static String PATH = "Proiect.csv";



    public static citireProiect getInstance() {
        if (service == null)
            service = new citireProiect();
        return service;
    }

    public void readProjectFromFile(angajatiService service) {

        int k = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");
                project p = new project(service.getManagerByname(dataFields[0]),dataFields[1]);
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
