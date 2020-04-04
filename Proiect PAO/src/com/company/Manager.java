package com.company;

public class Manager extends Angajati{
    public Manager(String first_name, String last_name, String domeniul, int status){
        super(first_name,last_name,domeniul,status);

    }
    public Manager(Angajati a){
        super(a.getFirst_name(),a.getFirst_name(),a.domeniul_str,a.status);
    }
    public Manager(){}
    public int limit;
    @Override
    public boolean check_limit(){
        if(limit == 4)
            return false;
        return true;
    }




}
