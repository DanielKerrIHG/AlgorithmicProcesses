/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package algorithmsparttwo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 2A - Brute Force Find the Missing Number
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: NumberReader.java
 */
public class PartTwoA {
    
    private Integer[] myArray;
    
    /**
     * exhaustiveSearch iterates through myArray, looking for a missing number
     * in the sequence 1..(n-1). It does this by comparing the current element 
     * to the next element. 
     * @return the integer that is missing from the array
     */
    public int exhaustiveSearch(){
        
        // start by checking is 1 is missing
        if(myArray[0] != 1){
            return 1;
        }
        else{
            for(int i = 0; i < myArray.length; i++){
                // if the current number plus one does not equal the next number
                // in the sequence, then the number after the current is missing
                if((myArray[i] + 1) != myArray[i + 1]){
                    return  myArray[i] + 1;
                    
                }
            }
            // If we don't find a missing number (could possibly be the case that
            // the last number is missing?:
            return -1;
        }
    }
    
    /**
     * displayResults prints the results of the search to the console. It will print
     * the contents of the array to compare to the results.
     * @param missingNumber the number missing from the array to report to the user
     */
    public void displayResults(int missingNumber){
        if(missingNumber == -1){
            System.out.println("I can't seem to find the missing Integer. It is"
                    + "possible it is at the end of the Array?");
        }
        else{
            System.out.println("The missing Integer is " + missingNumber + ".");
        }
        System.out.println("Here is the contents of the input Array, so you can "
                + "check my work:");
        for(int i = 0; i < myArray.length; i++){
            System.out.print(myArray[i] + " ");
        }
        System.out.println("");
    }
    
    /**
     * readFile reads in a file to create the array to check. Expects one integer
     * per line, from 1 to n-1, with one integer missing.
     * @param fileName the file location to read in
     */
    public void readFile(String fileName){
        BufferedReader br = null;
        ArrayList<Integer> temp = new ArrayList<Integer>();
        try{
            br = new BufferedReader(new FileReader(fileName));
            String line;
	        while ((line = br.readLine()) != null) {
                    temp.add(new Integer(line).intValue());
                }
                myArray = temp.toArray(new Integer[temp.size()]);
        }catch (FileNotFoundException ex) {
	    	System.out.println("IO Exception Occurred - " + ex.getLocalizedMessage());
        } catch (IOException ex) {
            System.out.println("IO Exception Occurred - " + ex.getLocalizedMessage());
        }finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
    }
    
    /**
     * generateArray generates an array of size numberOfFullArray - 2, from 1 to
     * numberOfFullArray -1, but with one number randomly missing.
     * @param numberOfFullArray the size of the array to create (not including 
     * the missing element: so an input of 5 will create an array with 4 elements)
     */
    public void generateArray(int numberOfFullArray){
        Random random = new Random();
        // This gets the array index of the missing element, not the element itself!
        int missingElement = random.nextInt(numberOfFullArray);
        myArray = new Integer[numberOfFullArray - 1];
        for(int i = 0; i < missingElement; i++){
            myArray[i] = i + 1;
        }
        for(int i = missingElement; i < myArray.length; i++){
            myArray[i] = i + 2;
        }
    }
    
   
    
    public static void main(String[] args){
        PartTwoA myPartTwoA = new PartTwoA();
        if(args.length != 2){
            System.out.println("This application expects two commandline arguments:");
            System.out.println("The first argument tells the application whether or not");
            System.out.println("you want to use a file as input, or if you want to");
            System.out.println("randomly generate the array. The second argument is");
            System.out.println("either the file name to input or the number of elements");
            System.out.println("(Not including the missing element) you want the");
            System.out.println("randomly generated array to contain. The first argument");
            System.out.println("should either be 'file' or 'random'.");
        }
        else if((args[0].toLowerCase()).equals("file")){
            int missingNumber;
            myPartTwoA.readFile(args[1]);
            missingNumber = myPartTwoA.exhaustiveSearch();
            myPartTwoA.displayResults(missingNumber);
        }
        else if((args[0].toLowerCase()).equals("random")){
            int missingNumber;
            myPartTwoA.generateArray(new Integer(args[1]).intValue());
            missingNumber = myPartTwoA.exhaustiveSearch();
            myPartTwoA.displayResults(missingNumber);
        }
        else{
            System.out.println("I did not recieve the expected input for the first");
            System.out.println("argument. Use either 'file' followed by the file name");
            System.out.println("to generate the array to search via file input OR");
            System.out.println("use 'random' followed by the number of elements in");
            System.out.println("the array (not including the missing element)");
        }
    }
}