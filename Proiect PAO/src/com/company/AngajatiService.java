package com.company;

import com.company.expetion.PersonNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class AngajatiService {


    private BufferedWriter writer;
    public  List<Project> lista_proiecte;
    public  List<Angajat> lista_angajati;
    public List<Manager> lista_manageri;
    HashMap<String, Angajat> Lista = new HashMap<>();

  /*  File Employee_file = new File(EMPLOYEE_PATH);
    File economistFile = new File(MANAGER_PATH);
    File mecanicFile = new File(CEO_PATH);
    File dirgnrlFile = new File(PROJECT_PATH);

   */

    public AngajatiService() throws IOException{
        this.writer = Files.newBufferedWriter(Paths.get("audit.csv"));
        this.lista_manageri = new ArrayList<>();
        this.lista_angajati = new ArrayList<>();
        this.lista_proiecte = new ArrayList<>();

    }



    public void add_Angajat(Angajat a) {

        lista_angajati.add(a);
        Lista.put(a.getName(),a);
        if(a.status == 2) {
            Manager b = new Manager(a);
            lista_manageri.add(b);
        }

    }

    public void afisare_angajati() {
        for (Angajat ang : lista_angajati) {
            System.out.println(ang.getName());

        }
    }
/*
    public void afisare_manageri(){
        for (Manager ang : lista_manageri) {
            System.out.println(ang.getName());

        }
    }
*/
    public void afis_manager_proiect() {

        for (Manager ang : lista_manageri) {
            if(ang.limit !=0 && ang.project == 0)
            System.out.println(ang.getName());

        }
    }


    public void creare_proiect(String nume,String nume_m) {

            Project p = new Project(get_Manager_byname(nume_m), nume);
            lista_proiecte.add(p);

    }
    public void afisare_proiecte(){
            for(Project p : lista_proiecte)
            {
                System.out.println(p.date);
                System.out.println(p.nume);
                System.out.println("Manager responsabil:");
                System.out.println(p.manager.getName());
            }
    }

    public void sort_angajati(){
        lista_angajati.sort(new Compare());
    }

    public Manager disponibil(Angajat a){
        Manager m = new Manager(a);
      for (Manager ang : lista_manageri){
          String domeniul = "";
          if(ang.domeniul == 2)  domeniul = "info";
          if(ang.check_limit() && domeniul.equals(a.domeniul_str))
          return ang;
          }

            return m;
        }
        public Angajat getAngajat_byname(String name){
            for(Angajat ang : lista_angajati) {
                if (ang.getName().equalsIgnoreCase(name))
                    return ang;
        }
            throw new PersonNotFoundException("Could not find person: " + name);
    }

    public Manager get_Manager_byname(String name){
        for(Manager ang : lista_manageri) {
            if (ang.getName().equalsIgnoreCase(name))
                return ang;
        }
        throw new PersonNotFoundException("Could not find person: " + name);
    }

    public void marire(Angajat a,int procent){
        double b = (a.calc_salariu() * procent) / 100;
        System.out.println(a.calc_salariu() + b);

    }




    public void writePersonsToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.csv"))) {
            for (Angajat ang : lista_angajati) {
                bufferedWriter.write(ang.getName() + ", Salariul:" + ang.calc_salariu() + ", ID:" + ang.getReal_id());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully wrote " + lista_angajati.size() + " persons!");
    }

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
