
package algorithmsparttwob;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 2B - Divide and Conquer Find the Missing Number
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: PartTwoB.java
 */
public class PartTwoB {
    private Integer[] myArray;
    
    /**
     * divideAndConquerSearch works similarly to binary search, exploiting the 
     * relationship between the element and its index (if you look at a particular
     * element it will be equal to the index + 1 if it is before the missing
     * element and equal to index + 2 if it is after the missing element).
     * @return the integer that is missing from the array
     */
    public int divideAndConquerSearch(){
        // This is more or less the standard binary search algorithm, but it never
        // terminates early (as it isn't looking for a key)
        int left = 0;
        int right = myArray.length;
        int middle = 0;
        while(left < right){
            middle = (right + left) / 2;
            // in the case that the element at index middle == the value of middle + 1
            // then we have not reached the missing element in the array
            if(myArray[middle] == middle + 1){
                left = middle + 1;                
            }
            // The alternative is that the element at index middle == the value
            // of middle + 2, which means that we have already passed the missing
            // element.
            else{
                right = middle;
            }
        }
        //note that we could return right + 1 here as well, it terminates when they are ==
        return left + 1;
        
    }
    
    
    /**
     * displayResults prints the results of the search to the console. It will print
     * the contents of the array to compare to the results.
     * @param missingNumber the number missing from the array to report to the user
     */
    public void displayResults(int missingNumber){
        if(missingNumber == -1){
            System.out.println("I can't seem to find the missing Integer. ");
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
        System.out.println("The time complexity of this item should be similar to "
                + "that of binary search (which it is based on).\n Like Binary search"
                + " it eliminates half of the remaing search space on each iteration"
                + ". Unlike binary search, it never terminates early-- so it always"
                + " is log n time complexity.");
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
     * generateArray generates an array of size numberOfFullArray - 1, from 1 to
     * numberOfFullArray, but with one number randomly missing.
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
        PartTwoB myPartTwoB = new PartTwoB();
        if(args.length != 2){
            int missingNumber;
            System.out.println("Generating an array with elements 1 through 10 with "
                    + "one randomly missing.");
            myPartTwoB.generateArray(10);
            missingNumber = myPartTwoB.divideAndConquerSearch();
            myPartTwoB.displayResults(missingNumber);
        }
        else if((args[0].toLowerCase()).equals("file")){
            int missingNumber;
            myPartTwoB.readFile(args[1]);
            missingNumber = myPartTwoB.divideAndConquerSearch();
            myPartTwoB.displayResults(missingNumber);
        }
        else if((args[0].toLowerCase()).equals("random")){
            int missingNumber;
            myPartTwoB.generateArray(new Integer(args[1]).intValue());
            missingNumber = myPartTwoB.divideAndConquerSearch();
            myPartTwoB.displayResults(missingNumber);
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
