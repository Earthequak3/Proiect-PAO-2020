package com.company.entities;


public class Angajat {

    public static int ID;
    protected int status;
    protected String domeniulStr;
    private String firstName;
    private String lastName;
    private String real_id;
    private int domeniul;

    public Angajat(String firstName, String lastName, String domeniul, int status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.domeniulStr = domeniul;
        if (domeniul.equals("info"))
            this.domeniul = 2;
        else this.domeniul = 1;
        this.status = status;


        ID++;
        real_id = "" + status + this.domeniul + ID;
    }

    public String getSefId() {
        return "Nu am sef";
    }

    public double calc_salariu() {
        if (domeniul == 2)
            return 1000 * domeniul * status;
        else return (1000 * 1.5 * status);
    }

    public boolean check_limit() {
        return true;
    }

    //O succesiune de functii get

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDomeniul() {
        return domeniul;
    }

    public String getDomeniulStr() {
        return domeniulStr;
    }

    public int getStatus() {
        return status;
    }

    public String getReal_id() {
        return real_id;
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}
