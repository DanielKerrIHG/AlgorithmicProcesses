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
	public void addNumbers (ArrayList<Integer> numberToAdd) {
		// test the number with tempSum
		int beginIndex = 0;
		int endIndex = 0;

		for (int outerCounter = 0; outerCounter < numberToAdd.size(); outerCounter++) {
			for (int innerCounter = outerCounter; innerCounter < numberToAdd.size(); innerCounter++){
				int tempSum = 0;
				
				for (int summationCounter = outerCounter; summationCounter < innerCounter; summationCounter++){
					tempSum += numberToAdd.get(summationCounter);
				}
				
				if (tempSum > getSum()) {
					setSum(tempSum);
					beginIndex = outerCounter;
					endIndex = innerCounter;
				}
			}
		}
		
		for (int i = beginIndex; i <= endIndex; i ++) {
			getNumberAdded().add(getAllNumbers().get(i));
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
	        	getAllNumbers().add(new Integer(line));
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
	    
    	addNumbers (getAllNumbers());
	    
	    System.out.println("All Numbers Processed");
	    System.out.println();
	    System.out.println("The largest subsequence sum is " + getSum());
	    System.out.println("The sum was made with the following numbers: ");
	    
	    StringBuffer subSet = new StringBuffer();
	    ArrayList<Integer> displayNumberAdded = getNumberAdded();
	    
//	    Collections.sort(displayNumberAdded);
	    
	    for (Integer number : displayNumberAdded) {
	    	subSet.append(number).append(", ");
	    }
	    
	    // Remove the comma;
	    subSet.deleteCharAt(subSet.length() - 2);
	    System.out.println(subSet.toString());
	}
	
	public static void main(String[] args) {
		NumberReader myNumberReader = new NumberReader();
		
		if (args.length > 0)
			myNumberReader.processFile(args[0]);
		else
			myNumberReader.processFile("numbers.txt");
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
