package edu.spsu.cs6423.Project1;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Find Maximum value from a tree implementation
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: Part3Max.java
 */

public class Part3FindValue {
    private BinaryNode ourTree = null;

    /**
     * 
     * @param hayStack
     * @param needle
     * @param level
     */
    public void findTheValue (BinaryNode hayStack, Integer needle, int level) {
        System.out.println("Seaching for needle # " + needle);

        if (hayStack != null) {
            if(hayStack.getValue().equals(needle)) {
                System.out.println("Value Found in the list at level " + level);
            } else if (hayStack.getValue() < needle) {
                findTheValue(hayStack.getRightNode(), needle, ++level);
            } else {
                findTheValue(hayStack.getLeftNode(), needle, ++level);
            }
        } else {
            System.out.println("Boohoo not found, we are at level " + level);
        }

    }

    public static void main (String[] arguments) {
        Part3FindValue valueFinder = new Part3FindValue();

        if (arguments.length > 0)
            valueFinder.setOurTree(TreeFiller.buildTheTree(arguments[0]));
        else
            valueFinder.setOurTree(TreeFiller.buildTheTree("/numbers20.txt"));

        System.out.println("The tree we are searching: ");
        PrintTree.printTheTree(valueFinder.getOurTree(), 0);
        
        if (arguments.length > 1)
            valueFinder.findTheValue(valueFinder.getOurTree(), new Integer(arguments[1]), 0);
        else
            valueFinder.findTheValue(valueFinder.getOurTree(), new Integer(-616), 0);
        System.out.println("Since our binary tree is sorted, we need only traverse the \n"
                + "height of the tree. In the best case we find the value at the first\n"
                + "node, giving us big Omega of 1. In the worst case, we traverse the\n"
                + "entire set of nodes (since our tree is not balanced) giving us\n"
                + "a big O of n. In the average case (when the tree is roughly balanced)\n"
                + "our big Theta is log n.");
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
