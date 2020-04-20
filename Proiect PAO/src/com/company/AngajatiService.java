package com.company;

import com.company.expetion.PersonNotFoundException;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


public class AngajatiService {

    private List<Angajati> lista_angajati = new ArrayList<>();
    private List<Manager> lista_manageri = new ArrayList<>();
    HashMap<String,Angajati> Lista = new HashMap<>();


    public void add_Angajat(Angajati a) {

        lista_angajati.add(a);
        Lista.put(a.getName(),a);
        if(a.status == 2) {
            Manager b = new Manager(a);
            lista_manageri.add(b);
        }

    }

    public void afisare_angajati() {
        for (Angajati ang : lista_angajati) {
            System.out.println(ang.getName());

        }
    }

    public void afisare_manageri(){
        for (Manager ang : lista_manageri) {
            System.out.println(ang.getName());

        }
    }

    public void afis_manager_proiect() {

        for (Manager ang : lista_manageri) {
            if(ang.limit !=0 )
            System.out.println(ang.getName());

        }
    }

    public void sort_angajati(){
        Collections.sort(lista_angajati,new Compare());
    }

    public Manager disponibil(Angajati a){
        Manager m = new Manager(a);
      for (Manager ang : lista_manageri){
          String domeniul = "";
          if(ang.domeniul == 2)  domeniul = "info";
          if(ang.check_limit() && domeniul.equals(a.domeniul_str))
          return ang;
          }

            return m;
        }
        public Angajati getAngajat_byname(String name){
            for(Angajati ang : lista_angajati) {
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

    public void readPersonsFromFile() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("date.csv"))) {
            String currentLine;
            while ((currentLine = bufferedReader.readLine()) != null) {
                String[] dataFields = currentLine.split(",");

                Angajati a = new Angajati(dataFields[0], dataFields[1],dataFields[2],Integer.parseInt(dataFields[3]));
                if(a.status == 1) {
                    Employee b = new Employee(a, disponibil(a));
                    lista_angajati.add(b);
                    disponibil(b).lista_Employee.add(b);
                }
                else {
                Manager b = new Manager(a);
                    lista_angajati.add(b);
                    lista_manageri.add(b);
                }

            }
        } catch (IOException e) {
            System.out.println("Could not read data from file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully read " + lista_angajati.size() + " persons!");
    }

    public void writePersonsToFile() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("out.csv"))) {
            for (Angajati ang : lista_angajati) {
                bufferedWriter.write(ang.getName() + ", Salariul:" + ang.calc_salariu() + ", ID:" + ang.getReal_id());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.out.println("Could not write data to file: " + e.getMessage());
            return;
        }
        System.out.println("Successfully wrote " + lista_angajati.size() + " persons!");
    }


}
