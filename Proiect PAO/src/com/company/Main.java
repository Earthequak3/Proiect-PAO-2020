package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        AngajatiService servicii = new AngajatiService();

        servicii.readPersonsFromFile();
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
                        Angajati a = new Angajati(name, lname, domeniul, g);
                        Employee l = new Employee(a,servicii.disponibil(a));
                        System.out.println(servicii.disponibil(l).getLast_name());
                        servicii.add_Angajat(l);
                        servicii.disponibil(l).lista_Employee.add(l);
                    } else {
                        Angajati a = new Angajati(name, lname, domeniul, g);
                        Manager t = new Manager(a);
                        servicii.add_Angajat(t);
                    }
                    break;
                case (2):
                    servicii.afisare_angajati();
                   // servicii.writePersonsToFile();
                    break;
                case(3):
                    System.out.println("Numele angajatului");
                     name = in.nextLine();
                  System.out.println(servicii.getAngajat_byname(name).calc_salariu());
                  break;
                case(4):
                    System.out.println("Numele angajatului");
                   name = in.nextLine();
                    System.out.println(servicii.Lista.get(name).getReal_id());
                    if(servicii.getAngajat_byname(name).status == 1){
                        System.out.println("ID-ul managerului responsabil este : ");
                        System.out.println(servicii.Lista.get(name).getSef_id());
                    }
                    break;
                case(5):
                    servicii.sort_angajati();
                    servicii.afisare_angajati();
                    break;
                case(6):
                    System.out.println("Numele angajatului");
                    name = in.nextLine();
                    servicii.get_Manager_byname(name).Afisare_echipa();
                    break;
                case(7):
                    servicii.afis_manager_proiect();
                case(11):
                    servicii.writePersonsToFile();
            }




        }
    }
}
