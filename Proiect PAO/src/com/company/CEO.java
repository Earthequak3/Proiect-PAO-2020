package com.company;

public class CEO extends Angajat{

    public CEO(String first_name,String last_name, String domeniul,int status){
        super(first_name,last_name,"CEO",3);
    }


    @Override
    protected double calc_salariu() {
        return 9000;
    }
}


