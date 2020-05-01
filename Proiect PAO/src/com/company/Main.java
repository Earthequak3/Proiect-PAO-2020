package com.company;
import com.company.persistance.Persistance_CEO;
import com.company.persistance.Persistance_Manager;
import com.company.persistance.Persistence_Employee;
import com.company.persistance.Persistence_Project;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {


        Persistance_Manager persistance_manager = Persistance_Manager.getInstance();
        Persistence_Employee persistence_employee = Persistence_Employee.getInstance();
        Persistance_CEO persistance_ceo = Persistance_CEO.getInstance();
        Persistence_Project persistence_project = Persistence_Project.getInstance();
        AngajatiService servicii = new AngajatiService();

        servicii.logs("citire_csv_CEO");
        persistance_ceo.readPersonsFromFile(servicii);

        servicii.logs("citire_csv_manageri");
        persistance_manager.readPersonsFromFile(servicii);

        persistence_employee.readPersonsFromFile(servicii);
        servicii.logs("citire_csv_angajati");

        servicii.logs("citire_csv_proiect");
        persistence_project.readProjectFromFile(servicii);



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
                        Employee l = new Employee(a,servicii.disponibil(a));
                        System.out.println(servicii.disponibil(l).getLast_name());
                        servicii.add_Angajat(l);
                        servicii.disponibil(l).lista_Employee.add(l);
                    } else {
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
