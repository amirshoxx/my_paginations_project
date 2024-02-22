package com.example.hoke.db;

import com.example.hoke.entity.Todo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Db {

    public static List<Todo> todos=new ArrayList<>();


    public static void init(){
        Db.todos.addAll(List.of(
                new Todo(UUID.randomUUID(),"Amir","Juda zur bola",true),
                new Todo(UUID.randomUUID(),"Ozzod","Juda zur bola",false)

        ));
    }


}
