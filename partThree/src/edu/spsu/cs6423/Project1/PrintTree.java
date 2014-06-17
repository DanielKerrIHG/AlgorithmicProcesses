package edu.spsu.cs6423.Project1;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Tree Printer
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: PrintTree.java
 */
public class PrintTree {
    
    /**
     * printTheTree prints the tree to the console 'sideways'. I remember vaguely
     * back in the dawn-days doing this, but I couldn't quite nail the details, 
     * so I did look here to jog my memory: 
     * http://www.java2s.com/Code/C/Data-Structure-Algorithm/Displaysabinarytree.htm
     * @param rootNode the root node of the subtree to print
     * @param currLevel the current height of the subtree's root
     */
    public static void printTheTree(BinaryNode rootNode, int currLevel){
        if(rootNode == null){
            return;
        }
        String nodeString = "";
        printTheTree(rootNode.getRightNode(), currLevel + 1);
        for(int i = 0; i < currLevel; i++){
            nodeString += "   ";
        }
        nodeString += rootNode.getValue();
        System.out.println(nodeString);
        printTheTree(rootNode.getLeftNode(), currLevel + 1);
    }
}
