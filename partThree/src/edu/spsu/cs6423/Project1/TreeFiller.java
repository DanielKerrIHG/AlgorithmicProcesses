package edu.spsu.cs6423.Project1;

import java.util.ArrayList;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Builds the tree
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: TreeFiller.java
 */
public class TreeFiller {

    /**
     * Builds the tree utilizing the BinaryNode created
     *
     * @param treeNodes ArrayList if Integers to build the tree from
     * @return 1 if the tree was built successfully
     *          -1 is there was an error
     */
    public static BinaryNode buildTheTree (ArrayList<Integer> treeNodes) {
        BinaryNode treeBuilder = null;

        if (treeNodes.size() > 0) {
            for (Integer curNode : treeNodes) {
                if (treeBuilder == null)
                    treeBuilder = new BinaryNode(curNode);
                else
                    treeBuilder.addNewNode(treeBuilder, curNode);
            }
        }

        return treeBuilder;
    }

    /**
     *
     * @param fileName
     * @return
     */
    public static BinaryNode buildTheTree (String fileName) {
        if (fileName == null || fileName.length() == 0)
            return buildTheTree(ReadNumberFile.readThis("C:/Users/kerrda/Documents/NetBeansProjects/Project1/build/classes/numbers.txt"));
        else
            return buildTheTree(ReadNumberFile.readThis(fileName));
    }
}
