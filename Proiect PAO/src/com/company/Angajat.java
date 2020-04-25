package com.company;


public class Angajat {

    private String first_name;
    private String last_name;
    public static int ID;
    private String real_id;
    protected int status;
    protected int domeniul;
    protected String domeniul_str;
    public String getSef_id(){
        return "Nu am sef";
    }

    public Angajat(String first_name, String last_name, String domeniul, int status){
        this.first_name = first_name;
        this.last_name = last_name;
       this.domeniul_str = domeniul;
        if(domeniul.equals("info"))
        this.domeniul = 2;
        else this.domeniul = 1;
        this.status = status;


        ID++;
        real_id = "" + status + this.domeniul + ID;
    }
    public Angajat(){
        this.first_name = "";
        this.last_name = "";
    }

    public String getReal_id(){
        return real_id;
    }

    public String getName() {
        return first_name + " " + last_name;
    }

    protected double calc_salariu(){
        if(domeniul == 2)
        return 1000*domeniul*status;
        else return (1000*1.5*status);
    }
    public String getFirst_name(){
        return first_name;
    }
    public String getLast_name(){
        return last_name;
    }
    public boolean check_limit(){
        return true;
    }


}
