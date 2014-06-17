package edu.spsu.cs6423.Project1;

import java.util.ArrayList;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Find Maximum value from a tree implementation
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: Part3Max.java
 */

public class Part3Max {
    private ArrayList<Integer> numbersFromFile;
    private BinaryNode ourTree = null;


    /**
     * Finds the maximum value from the tree
     * @param treeFinder Binary tree generated
     * @return maximum Integer value that is in the tree
     */
    private Integer findMaximum (BinaryNode treeFinder) {
        Integer maximum = new Integer(Integer.MIN_VALUE);

        if (treeFinder.getValue() > maximum)
            maximum = treeFinder.getValue();

        if (treeFinder.getRightNode() != null)
            maximum = this.findMaximum(treeFinder.getRightNode());

        return maximum;
    }

    /**
     * Main procedure to execute the tree filling and finding the maximum value
     *
     * @param arguments should be the file "numbers.txt"
     */
    public static void main(String[] arguments) {
        Part3Max maximumTest  = new Part3Max();
        Integer maximumValue = 0;

        if (arguments.length > 1)
            maximumTest.setOurTree(TreeFiller.buildTheTree(arguments[0]));
        else
            maximumTest.setOurTree(TreeFiller.buildTheTree("C:/Users/kerrda/Documents/NetBeansProjects/Project1/build/classes/numbers.txt"));

        if (maximumTest.getOurTree() != null)
            maximumValue = maximumTest.findMaximum(maximumTest.getOurTree());

        System.out.println("The tree we are searching: ");
        PrintTree.printTheTree(maximumTest.getOurTree(), 0);
        System.out.println("The Maximum value from the list = " + maximumValue);
    }

    /**
     *
     * @param numbersFromFile
     */
    public void setNumbersFromFile(ArrayList<Integer> numbersFromFile) {
        this.numbersFromFile = numbersFromFile;
    }

    /**
     *
     * @return
     */
    public ArrayList<Integer> getNumbersFromFile() {
        return numbersFromFile;
    }

    /**
     * @return the ourTree
     */
    public BinaryNode getOurTree() {
        return ourTree;
    }

    /**
     * @param ourTree the ourTree to set
     */
    public void setOurTree(BinaryNode ourTree) {
        this.ourTree = ourTree;
    }
}
