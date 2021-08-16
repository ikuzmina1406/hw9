package ua.GoIT.modul9;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;


public class User {
    public static void main(String[] args) throws IOException {
        ArrayList<Users> users = new ArrayList<>();
        try {
            File file = new File("file1.txt");
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            while (line != null) {
                line = reader.readLine();
                if (line != null) {
                    String[] words = line.split(" ");
                    users.add(new Users(words[0], Integer.parseInt(words[1].trim())));
                    // System.out.println(line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonUser.createJson(users);
    }

}

class JsonUser {

    public static <json> void createJson(ArrayList<Users> users) throws IOException {

        Gson gson = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

        String s = gson.toJson(users);

        System.out.println(s);


        writeToJsonFile(s);


    }

    private static void writeToJsonFile(String s) throws IOException {
        try (FileWriter writer = new FileWriter("user.json")) {
            writer.write(s);
            writer.flush();
        }
    }


}

class Users {
    private String name;
    private int age;

    public Users(String name, int age) {
        this.name = name;
        this.age = age;
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