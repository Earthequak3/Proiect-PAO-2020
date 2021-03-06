package com.company.services;

import com.company.entities.Angajat;
import com.company.entities.Manager;
import com.company.expetion.PersonNotFoundException;
import com.company.project.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class angajatiService {


    private BufferedWriter writer;
    public  List<project> listaProiecte;
    public  List<Angajat> listaAngajati;
    public List<Manager> listaManageri;
    public Map<String, Angajat> lista = new HashMap<>();


    public angajatiService() {
      try{  this.writer = Files.newBufferedWriter(Paths.get("audit.csv"));
        }catch (IOException e) {
          System.out.println("Nu am putut deschide fisierul audit!");
      }

        this.listaManageri = new ArrayList<>();
        this.listaAngajati = new ArrayList<>();
        this.listaProiecte = new ArrayList<>();

    }



    public void addAngajat(Angajat a) {

        listaAngajati.add(a);
        lista.put(a.getName(),a);
        if(a.getStatus() == 2) {
            Manager b = new Manager(a);
            listaManageri.add(b);
        }

    }

    public void printEmployees() {
        for (Angajat ang : listaAngajati) {
            System.out.println(ang.getName());

        }
    }
// afiseaza managerii disponibili pentru preluarea unui proiect
    public void printProjectManager() {

        for (Manager ang : listaManageri) {
            if(ang.limit !=0 && ang.project == 0)
            System.out.println(ang.getName());

        }
    }


    public void createProject(String nume, String nume_m) {

            project p = new project(getManagerByname(nume_m), nume);
            listaProiecte.add(p);

    }
    public void printProjects(){
            for(project p : listaProiecte)
            {
                System.out.println(p.date);
                System.out.println(p.nume);
                System.out.println("Manager responsabil:");
                System.out.println(p.manager.getName());
            }
    }

    public void sortAngajati(){
        listaAngajati.sort(new compare());
    }
    // functie ce verifica existenta primului Manager disponibil
    // (care poate lua in echipa sa Angajati cu rank mai mic)
    
    public Manager isAvailable(Angajat a){
        Manager m = new Manager(a);
      for (Manager ang : listaManageri){
          String domeniul = "";
          if(ang.getDomeniul() == 2)  domeniul = "info";
          if(ang.check_limit() && domeniul.equals(a.getDomeniulStr()))
          return ang;
          }

            return m;
        }

        // functii de tip getter
        public Angajat getAngajatByname(String name){
            for(Angajat ang : listaAngajati) {
                if (ang.getName().equalsIgnoreCase(name))
                    return ang;
        }
            throw new PersonNotFoundException("Could not find person: " + name);
    }

    public Manager getManagerByname(String name){
        for(Manager ang : listaManageri) {
            if (ang.getName().equalsIgnoreCase(name))
                return ang;
        }
        throw new PersonNotFoundException("Could not find person: " + name);
    }
// functia pentru marirea salariuli
    public void raising(Angajat a, int procent){
        double b = (a.calc_salariu() * procent) / 100;
        System.out.println(a.calc_salariu() + b);

    }




    public void writePersonsToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.csv"))) {
            for (Angajat ang : listaAngajati) {
                bufferedWriter.write(ang.getName() + ", Salariul:" + ang.calc_salariu() + ", ID:" + ang.getReal_id());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully wrote " + listaAngajati.size() + " persons!");
    }
        //Functia audit
    public void logs(String action_name) {
        Date timestamp = new Date();
        String printLogs = action_name + ", " + timestamp;
        try {
            writer.write(printLogs);
            writer.newLine();
            writer.flush();
        }
        catch (IOException e){
            System.out.println("Problema la audit!");
        }
    }
}
