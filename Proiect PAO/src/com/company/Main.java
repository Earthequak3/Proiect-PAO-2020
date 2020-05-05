package com.company;

import com.company.entities.Angajat;
import com.company.entities.Employee;
import com.company.entities.Manager;
import com.company.persistance.citireCeo;
import com.company.persistance.citireEmployee;
import com.company.persistance.citireManageri;
import com.company.persistance.citireProiect;
import com.company.services.angajatiService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        citireManageri persistanceManager = citireManageri.getInstance();
        citireEmployee persistenceEmployee = citireEmployee.getInstance();
        citireCeo persistanceCeo = citireCeo.getInstance();
        citireProiect persistenceProiect = citireProiect.getInstance();
        angajatiService service = new angajatiService();

        service.logs("citire_csv_CEO");
        persistanceCeo.readPersonsFromFile(service);

        service.logs("citire_csv_manageri");
        persistanceManager.readPersonsFromFile(service);

        persistenceEmployee.readPersonsFromFile(service);
        service.logs("citire_csv_angajati");

        service.logs("citire_csv_proiect");
        persistenceProiect.readProjectFromFile(service);



        int k = 99;

        while (k != 0) {
        System.out.println("Apasati tasta corespunzatoare comenzii:");
        System.out.println("1.Cititi un angajat");
        System.out.println("2.Afisati lista angajatilor");
        System.out.println("3.Calcularea salariului unui angajat dupa nume");
        System.out.println("4.Afla ID-ul unui angajat folosind numele");
        System.out.println("5.Afisare angajati sortati dupa rank");
        System.out.println("6.Afisarea echipei unui manager");
        System.out.println("7.Afisare lista managerilor care pot coordona un proiect");
        System.out.println("8.Adaugare proiect nou");
        System.out.println("9.Afisare proiecte");
        System.out.println("10.Marire salariala");
        System.out.println("11.Scriere CSV");
        System.out.println("0.Pentru a iesi din program");

        Scanner in = new Scanner(System.in);
            k = in.nextInt();
            in.nextLine();
            switch (k) {

                case (1):
                    System.out.println("First name:");
                   String name = in.nextLine();
                    System.out.println("Last name:");
                    String lname = in.nextLine();
                    System.out.println("Domeniul: 1.Info/2.Resurse Umane?");
                    int d = in.nextInt();
                    String domeniul = "";
                    if (d == 1) domeniul = "info";
                    System.out.println("Status: 1.Angajat/2.Manager");
                    int g = in.nextInt();

                    Angajat a = new Angajat(name, lname, domeniul, g);
                    if (g == 1) {
                        Employee l = new Employee(a,service.isAvailable(a));
                        System.out.println(service.isAvailable(l).getLastName());
                        service.addAngajat(l);
                        service.isAvailable(l).listaEmployee.add(l);
                    } else {
                        Manager t = new Manager(a);
                        service.addAngajat(t);
                    }
                    service.logs("Citirea unui angajat");
                    break;
                case (2):
                    service.printEmployees();
                    service.writePersonsToFile();
                    service.logs("Afisarea_angajati");
                    break;
                case(3):
                    System.out.println("Numele angajatului");
                     name = in.nextLine();
                  System.out.println(service.getAngajatByname(name).calc_salariu());
                  service.logs("Calcularea salariului" + name);
                  break;
                case(4):
                    System.out.println("Numele angajatului");
                   name = in.nextLine();
                    System.out.println(service.lista.get(name).getReal_id());
                    if(service.getAngajatByname(name).getStatus() == 1){
                        System.out.println("ID-ul managerului responsabil este : ");
                        System.out.println(service.lista.get(name).getSefId());
                    }
                    service.logs("Aflarea ID-ului angajatului" + name);
                    break;
                case(5):
                    service.sortAngajati();
                    service.printEmployees();
                    service.logs("Afisare_angajati dupa rank");
                    break;
                case(6):
                    System.out.println("Numele angajatului");
                    name = in.nextLine();
                    service.getManagerByname(name).Afisare_echipa();
                    service.logs("Afisare_echipa_manager" + name);
                    break;
                case(7):
                    service.printProjectManager();
                    service.logs("Afisare_manageri_eligibili");
                    break;
                case(8):
                    System.out.println("Numele Proiectului");
                    name = in.nextLine();
                    System.out.println("Numele Managerului");
                    String name_m = in.nextLine();
                   service.createProject(name,name_m);
                   service.logs("Adaugare proiect _ " + name);
                   break;
                case(9):
                    service.printProjects();
                    service.logs("Afisare_proiecte");
                    break;
                case(10):
                    System.out.println("Numele angajatului");
                    name = in.nextLine();
                    System.out.println("Ce procent?");
                    int procent = in.nextInt();
                    service.raising(service.getAngajatByname(name),procent);
                    service.logs("Marire salariu _ " + name + " cu " + procent + " % ");
                    break;
                case(11):
                    service.writePersonsToFile();
                    service.logs("Scriere in fisier csv");
                    break;
            }




        }
    }
}
