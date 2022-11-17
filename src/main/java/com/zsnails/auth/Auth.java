package com.zsnails.auth;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

public class Auth {
    private static Map<String, String> data = new HashMap<>();

    private Auth() {
    }

    public static void loadData() {
        try {
            Scanner pFile = new Scanner(new File("players.dat"));
            System.out.println("Loading user data");
            while (pFile.hasNextLine()) {
                System.out.println("Loading line");
                Scanner line = new Scanner(pFile.nextLine());

                line.useDelimiter(",");
                while (line.hasNext()) {
                    String name = line.next();
                    String password = line.next();
                    System.out.printf("Loading: %s,%s\n", name, password);
                    data.put(password, name);
                }

                line.close();
            }

            pFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds a new user to the players' file
     * 
     * @param name     The user's name
     * @param password The user's password
     */
    public static void registerUser(String name, String password) {
        data.put(password, name);

        try {

            PrintWriter pw = new PrintWriter(new File("players.dat"));

            for (Entry<String, String> val : data.entrySet()) {
                System.out.printf("Storing: %s,%s", val.getValue(), val.getKey());
                pw.printf("%s,%s\n", val.getValue(), val.getKey());
            }

            // pw.printf("%s,%s\n", name, password);
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Authenticates an user and password
     * 
     * @param name     The user's name
     * @param password The user's password
     * @return Whether or not the user has been authenticated
     */
    public static boolean authenticate(String name, String password) {
        // if (data.isEmpty()) {
        //     loadData();
        // }

        return data.get(password).compareTo(name) == 0;
    }
}