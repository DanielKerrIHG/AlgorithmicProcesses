package edu.spsu.cs6423.Project1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Reads the numbers from the file
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: ReadNumberFile.java
 */
public class ReadNumberFile {

    public static ArrayList<Integer> readThis(String fileName) {
        BufferedReader br = null;
        InputStream is = ReadNumberFile.class.getResourceAsStream(fileName);
        ArrayList<Integer> numberFromFile = new ArrayList<Integer>();

        try {
            br = new BufferedReader(new InputStreamReader(is));

            String line;
            while ((line = br.readLine()) != null) {
                try {
                    numberFromFile.add(new Integer(line));
                } catch (Exception ex) {
                    System.out.println("We didn't see a number");
                    System.out.println(ex.getLocalizedMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("IO Exception Occurred - " + ex.getLocalizedMessage());
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return numberFromFile;
    }
}
