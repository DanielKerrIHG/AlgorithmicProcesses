package edu.spsu.cs6423.Project1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Breadth First Search Algorithm
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: Part3BFS.java
 */
public class Part3BFS {
    private BinaryNode ourTree = null;
    LinkedList<BinaryNode> needleQueue = new LinkedList<BinaryNode>();

    
    public void traverseOurTree(BinaryNode treeToTraverse) {
        if (treeToTraverse != null) {
            needleQueue.clear();
            needleQueue.add(treeToTraverse);
            while (!needleQueue.isEmpty()) {
                BinaryNode node = needleQueue.poll();
                System.out.print(node.getValue() + " ");
                if (node.getLeftNode() != null)
                    needleQueue.add(node.getLeftNode());
                if (node.getRightNode() != null)
                    needleQueue.add(node.getRightNode());
            }
        }
    }

    public static void main(String[] arguments) {
        Part3BFS bfs = new Part3BFS();

        if (arguments.length > 0)
            bfs.setOurTree(TreeFiller.buildTheTree(arguments[0]));
        else
            bfs.setOurTree(TreeFiller.buildTheTree("/numbers20.txt"));

        System.out.println("The tree we are traversing: ");
        PrintTree.printTheTree(bfs.getOurTree(), 0);
        
        if (bfs.getOurTree() != null) {
            System.out.println("Our bfs traversal: ");
            bfs.traverseOurTree(bfs.getOurTree());
            System.out.println();
        }
        System.out.println("Our BFS traversal processes each node once, (the main operation is checking for null). \nThis means"
                + " that it does n operations on an input of n plus the test for null at each leaf, \ngiving it a time"
                + " complexity of n for best worst and average case.");
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
