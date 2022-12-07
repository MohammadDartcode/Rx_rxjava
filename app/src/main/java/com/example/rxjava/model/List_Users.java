package com.example.rxjava.model;

import java.util.ArrayList;
import java.util.List;

public class List_Users {

    public  static List<Users> getListUsers(){

        List<Users> users =new ArrayList<>();

        users.add(new Users("Tom Hardy" ,"Tom@yahoo.com",1,true));
        users.add(new Users("Tom Hardy" ,"Tom@yahoo.com",1,true));
        users.add(new Users("TopLearn" , "TopLearn@yahoo.com",2,true));
        users.add(new Users("Heath Ledger" , "HeathLedger@yahoo.com",3,false));
        users.add(new Users("Brand Li" , "Brand@yahoo.com",4,false));
        users.add(new Users("Brand Li" , "Brand@yahoo.com",4,false));

        return users;
    }
}
