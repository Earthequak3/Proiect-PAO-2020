package com.company;

import javax.lang.model.type.NullType;
import java.sql.Array;
import java.util.*;


public class AngajatiService {

    private List<Angajati> listaAngajati = new ArrayList<>();
    private List<Manager> lista_manageri = new ArrayList<>();
    HashMap<String,Angajati> Lista = new HashMap<String, Angajati>();


    public void add_Angajat(Angajati a) {

        listaAngajati.add(a);
        Lista.put(a.getName(),a);
        if(a.status == 2) {
            Manager b = new Manager(a);
            lista_manageri.add(b);
        }

    }

    public void afisare_angajati() {
        for (Angajati ang : listaAngajati) {
            System.out.println(ang.getName());

        }
    }


    public void sort_angajati(){
        Collections.sort(listaAngajati,new Compare());
    }

    public Manager disponibil(Angajati a){
        Manager m = new Manager(a);
      for (Manager ang : lista_manageri){
          String domeniul = "";
          if(ang.domeniul == 2)  domeniul = "info";
          if(ang.check_limit() && domeniul == a.domeniul_str)
              return ang;
          }

      return m;
    }
    public Angajati getAngajat_byname(String name){
        for(Angajati ang : listaAngajati) {
            if (ang.getName().equalsIgnoreCase(name))
                return ang;
        }
        return new Angajati();
    }




}
