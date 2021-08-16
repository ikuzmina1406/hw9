package ua.GoIT.modul9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Scanner;

public class UserH {
    public static void main(String[] args) throws IOException {
        //  ArrayList<String> user = new ArrayList<String>();
        //  Scanner scan = new Scanner("file1.txt");
        // while(scan.hasNextLine()){
        //    user.add(scan.nextLine());

        // }
        // System.out.println(user);
        //scan.close();
        // }
        ArrayList<String> user = new ArrayList<String>();
        BufferedReader reader = new BufferedReader(new FileReader("file1.txt"));
        String line;
        while ((line = reader.readLine()) != null) {
            user.add(line);
            System.out.println(user);
        }
        reader.close();
    }
}

class UserHs {
    private String user;
    private String name;
    private int age;


    public UserHs(String user,String name, int age) {
        this.user=user;
        this.name = name;
        this.age = age;
    }



    public String getUser() {
        return user;
    }
    public void setUser(String employee) {
        this.user = employee;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
/*
public class WriteToJson {

    public static void main(String[] args) {
        ArrayList<User> array = new ArrayList<User>();
        for(int i = 0 ; i < 100; i++){
            array.add(new User(i+"", i+"", i+""));
        }

        JSONArray jsonArray = new JSONArray();
        for (int i = 0;i < array.size() ; i++) {
            JSONObject obj = new JSONObject();
            JSONObject objItem =  new JSONObject();
                 objItem.put("name",  array.get(i).getName());
            objItem.put("age",  array.get(i).getAge());
            obj.put("user", objItem);
            jsonArray.put(obj);
        }

        try (FileWriter file = new FileWriter()) {
            file.write(jsonArray.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + jsonArray);
        } catch(Exception e){
            System.out.println(e);

        }
    }

}

*/
