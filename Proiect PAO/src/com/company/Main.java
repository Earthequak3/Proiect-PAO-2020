package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        CEO CEO = new CEO();
        Manager manager = new Manager();
        Employee emp = new Employee();
        Project project = new Project();

        AngajatiService servicii = new AngajatiService();

        servicii.logs("citire_csv_CEO");
        servicii.readPersonsFromFile(CEO);
        servicii.logs("citire_csv_manageri");
        servicii.readPersonsFromFile(manager);
        servicii.logs("citire_csv_angajati");
        servicii.readPersonsFromFile(emp);
        servicii.logs("citire_csv_proiect");
        servicii.readPersonsFromFile(project);



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

                    if (g == 1) {
                        Angajat a = new Angajat(name, lname, domeniul, g);
                        Employee l = new Employee(a,servicii.disponibil(a));
                        System.out.println(servicii.disponibil(l).getLast_name());
                        servicii.add_Angajat(l);
                        servicii.disponibil(l).lista_Employee.add(l);
                    } else {
                        Angajat a = new Angajat(name, lname, domeniul, g);
                        Manager t = new Manager(a);
                        servicii.add_Angajat(t);
                    }
                    servicii.logs("Citirea unui angajat");
                    break;
                case (2):
                    servicii.afisare_angajati();
                    servicii.writePersonsToFile();
                    servicii.logs("Afisarea_angajati");
                    break;
                case(3):
                    System.out.println("Numele angajatului");
                     name = in.nextLine();
                  System.out.println(servicii.getAngajat_byname(name).calc_salariu());
                  servicii.logs("Calcularea salariului" + name);
                  break;
                case(4):
                    System.out.println("Numele angajatului");
                   name = in.nextLine();
                    System.out.println(servicii.Lista.get(name).getReal_id());
                    if(servicii.getAngajat_byname(name).status == 1){
                        System.out.println("ID-ul managerului responsabil este : ");
                        System.out.println(servicii.Lista.get(name).getSef_id());
                    }
                    servicii.logs("Aflarea ID-ului angajatului" + name);
                    break;
                case(5):
                    servicii.sort_angajati();
                    servicii.afisare_angajati();
                    servicii.logs("Afisare_angajati dupa rank");
                    break;
                case(6):
                    System.out.println("Numele angajatului");
                    name = in.nextLine();
                    servicii.get_Manager_byname(name).Afisare_echipa();
                    servicii.logs("Afisare_echipa_manager" + name);
                    break;
                case(7):
                    servicii.afis_manager_proiect();
                    servicii.logs("Afisare_manageri_eligibili");
                    break;
                case(8):
                    System.out.println("Numele Proiectului");
                    name = in.nextLine();
                    System.out.println("Numele Managerului");
                    String name_m = in.nextLine();
                   servicii.creare_proiect(name,name_m);
                   servicii.logs("Adaugare proiect _ " + name);
                   break;
                case(9):
                    servicii.afisare_proiecte();
                    servicii.logs("Afisare_proiecte");
                    break;
                case(10):
                    System.out.println("Numele angajatului");
                    name = in.nextLine();
                    System.out.println("Ce procent?");
                    int procent = in.nextInt();
                    servicii.marire(servicii.getAngajat_byname(name),procent);
                    break;
                case(11):
                    servicii.writePersonsToFile();
                    break;
            }




        }
    }
}
