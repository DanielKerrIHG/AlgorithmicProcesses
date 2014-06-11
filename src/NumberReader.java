import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 1 - Sum number from file
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: NumberReader.java
 */
public class NumberReader {
	
	private int sum = 0;
	private ArrayList<Integer> numberAdded = new ArrayList<Integer>();
	private ArrayList<Integer> allNumbers = new ArrayList<Integer>();

	/**
	 * addNumbers receives a number and adds it to the sum and
	 * if the new sum is greater than the old sum, then we set 
	 * the new sum.  When the new sum is set, then we add the
	 * number into the list of numbers added
	 *
	 * @param numberToAdd number sent from processFile to
	 * added in from the processFile
	 */
	public void addNumbers (int numberToAdd) {
		// test the number with tempSum
		int tempSum = getSum() + numberToAdd;

		// Add the number into the list of all numbers
		getAllNumbers().add(new Integer(numberToAdd));

		System.out.print("Adding number " + numberToAdd);
		
		// If the test sum is larger than the current sum
		if (tempSum > getSum()) {
			// Add the number to the list of numbers that were added
			getNumberAdded().add(new Integer(numberToAdd));
			// Set the new sum
			setSum(tempSum);
			//  If added, print that the number was added in.
			System.out.println(" -- number added - new sum = " + getSum());
		} else {
			//  If not added, print that the number was not added in.
			System.out.println(" -- Number NOT added");
		}
			
	}
	
	/**
	 * Reads from the file and calls the addNumbers function for 
	 * processing the number
	 * @param fileName Name of the file to read from
	 */
	public void processFile (String fileName) {
		
		BufferedReader br = null;
	    try {
		    br = new BufferedReader(new FileReader(fileName));

	        String line;
	        while ((line = br.readLine()) != null) {
	        	addNumbers (new Integer(line).intValue());
	        	Thread.sleep(100);
	        }
	    } catch (IOException ex) {
	    	System.out.println("IO Exception Occurred - " + ex.getLocalizedMessage());
	    } catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
	        try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
	    
	    System.out.println("All Numbers Processed");
	    System.out.println();
	    System.out.println("The largest suset sum is " + getSum());
	    System.out.println("The sum was made with the following numbers: ");
	    
	    StringBuffer subSet = new StringBuffer();
	    ArrayList<Integer> displayNumberAdded = getNumberAdded();
	    
	    Collections.sort(displayNumberAdded);
	    
	    for (Integer number : displayNumberAdded) {
	    	subSet.append(number).append(", ");
	    }
	    
	    // Remove the comma;
	    subSet.deleteCharAt(subSet.length() - 1);
	    System.out.println(subSet.toString());
	}
	
	public static void main(String[] args) {
		NumberReader myNumberReader = new NumberReader();
		
		if (args.length > 0)
			myNumberReader.processFile(args[0]);
		else
			myNumberReader.processFile("./numbers.txt");
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public ArrayList<Integer> getNumberAdded() {
		return numberAdded;
	}

	public void setNumberAdded(ArrayList<Integer> numberAdded) {
		this.numberAdded = numberAdded;
	}

	public ArrayList<Integer> getAllNumbers() {
		return allNumbers;
	}

	public void setAllNumbers(ArrayList<Integer> allNumbers) {
		this.allNumbers = allNumbers;
	}

}
