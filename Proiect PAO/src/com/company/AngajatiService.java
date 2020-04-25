package com.company;

import com.company.expetion.PersonNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class AngajatiService {

    private final static String EMPLOYEE_PATH = "Employee.csv";
    private final static String MANAGER_PATH = "Manager.csv";
    private final static String CEO_PATH = "CEO.csv";
    private final static String PROJECT_PATH = "Proiect.csv";
    private BufferedWriter writer;
    private List<Project> lista_proiecte;
    private List<Angajat> lista_angajati;
    private List<Manager> lista_manageri;
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

    public void afisare_manageri(){
        for (Manager ang : lista_manageri) {
            System.out.println(ang.getName());

        }
    }

    public void afis_manager_proiect() {

        for (Manager ang : lista_manageri) {
            if(ang.limit !=0 && ang.project == 0)
            System.out.println(ang.getName());

        }
    }


    public void creare_proiect(String nume,String nume_m) {

            Project p = new Project(get_Manager_byname(nume_m), nume);
            lista_proiecte.add(p);
            return;

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
        Collections.sort(lista_angajati,new Compare());
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

    public <T> void  readPersonsFromFile(T obiect) {

        if (obiect instanceof CEO) {
            int k = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(CEO_PATH))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");

                    CEO a = new CEO(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                    lista_angajati.add(a);
                    k++;
                    }


            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return;
            }
            System.out.println("Successfully read " + k + " CEOs!");
        }

        if (obiect instanceof Manager) {
            int k = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(MANAGER_PATH))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");

                    Manager a = new Manager(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                    lista_angajati.add(a);
                    lista_manageri.add(a);
                    k++;
                }


            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return;
            }
            System.out.println("Successfully read " + k + " managers!");
        }

        if (obiect instanceof Employee) {
            int k = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(EMPLOYEE_PATH))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Angajat a = new Angajat(dataFields[0], dataFields[1], dataFields[2], Integer.parseInt(dataFields[3]));
                    Employee b = new Employee(a,disponibil(a));
                    lista_angajati.add(b);
                    k++;
                }


            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return;
            }
            System.out.println("Successfully read " + k + " employees!");
        }

        if(obiect instanceof Project){
            int k = 0;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PROJECT_PATH))) {
                String currentLine;
                while ((currentLine = bufferedReader.readLine()) != null) {
                    String[] dataFields = currentLine.split(",");
                    Project p = new Project(get_Manager_byname(dataFields[0]),dataFields[1]);
                    lista_proiecte.add(p);
                    k++;
                }


            } catch (IOException e) {
                System.out.println("Could not read data from file: " + e.getMessage());
                return;
            }
            System.out.println("Successfully read " + k + " projects!");
        }
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
