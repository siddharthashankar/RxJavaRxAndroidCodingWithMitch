package com.sid.rxjavarxandroidcodingwithmitch;

import java.util.ArrayList;
import java.util.List;

public class DataSource {

    public static List<Task> createTasksList(){
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task("Siddhartha",true,3));
        tasks.add(new Task("Mukesh",false,2));
        tasks.add(new Task("Kavita",true,1));
        tasks.add(new Task("Sonu",false,0));
        tasks.add(new Task("Khushboo",true,5));

        return tasks;

    }
}
