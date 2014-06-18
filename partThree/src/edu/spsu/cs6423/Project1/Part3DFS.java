package edu.spsu.cs6423.Project1;

import java.util.Stack;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Depth First Search Algorithm
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: Part3DFS.java
 */
public class Part3DFS {

    private BinaryNode ourTree = null;

    public enum traversalOrder {

        preorder, inorder, postorder;
    }
    public Stack<BinaryNode> treeStack = new Stack<BinaryNode>();

    public void traverseUsingStack(BinaryNode treeToTraverse) {

        if (treeToTraverse == null) {
            return;
        }
        treeStack.push(treeToTraverse);
        System.out.print(treeToTraverse.getValue() + " ");
        if (treeToTraverse.getLeftNode() != null)
            traverseUsingStack(treeToTraverse.getLeftNode());
        if (treeToTraverse.getRightNode() != null)
            traverseUsingStack(treeToTraverse.getRightNode());

        treeStack.pop();
    }

    public void traverseOurTree(BinaryNode treeToTraverse, traversalOrder orderToTraverse) {
        switch (orderToTraverse) {
            // The only valid dfs traversal
            case preorder:
                System.out.print(treeToTraverse.getValue() + " ");
                if (treeToTraverse.getLeftNode() != null) {
                    traverseOurTree(treeToTraverse.getLeftNode(), orderToTraverse);
                }
                if (treeToTraverse.getRightNode() != null) {
                    traverseOurTree(treeToTraverse.getRightNode(), orderToTraverse);
                }
                break;
                //not a dfs traversal
            case inorder:
                if (treeToTraverse.getLeftNode() != null) {
                    traverseOurTree(treeToTraverse.getLeftNode(), orderToTraverse);
                }
                System.out.print(treeToTraverse.getValue() + " ");
                if (treeToTraverse.getRightNode() != null) {
                    traverseOurTree(treeToTraverse.getRightNode(), orderToTraverse);
                }
                break;
                // not a dfs traveral
            case postorder:
                if (treeToTraverse.getLeftNode() != null) {
                    traverseOurTree(treeToTraverse.getLeftNode(), orderToTraverse);
                }
                if (treeToTraverse.getRightNode() != null) {
                    traverseOurTree(treeToTraverse.getRightNode(), orderToTraverse);
                }
                System.out.print(treeToTraverse.getValue() + " ");
                break;
        }
    }

    public static void main(String[] arguments) {
        Part3DFS dfs = new Part3DFS();

        if (arguments.length > 0) {
            dfs.setOurTree(TreeFiller.buildTheTree(arguments[0]));
        } else {
            dfs.setOurTree(TreeFiller.buildTheTree("/numbers20.txt"));
        }

        System.out.println("The tree we are traversing: ");
        PrintTree.printTheTree(dfs.getOurTree(), 0);
        if (dfs.getOurTree() != null) {
            System.out.print("Pre-order Traversal dfs = ");
            dfs.traverseOurTree(dfs.getOurTree(), traversalOrder.preorder);
            System.out.println();
            // Not a dfs traversal
            //System.out.print("In-order Traversal = ");
            //dfs.traverseOurTree(dfs.getOurTree(), traversalOrder.inorder);
            //System.out.println();
            //System.out.print("Post-order Traversal = ");
            //dfs.traverseOurTree(dfs.getOurTree(), traversalOrder.postorder);
            //System.out.println();
            System.out.print("Stack implementation dfs = ");
            dfs.traverseUsingStack(dfs.getOurTree());
            System.out.println();
            System.out.println("We implemented our DFS traversal both with an actual"
                    + " stack, and with the pre-order traversal (they wind up the same).\n"
                    + "In both cases the main operation is checking for null, which we\n"
                    + "do once for each node processed plus twice at each leaf. This gives\n"
                    + "a time complexity of n for best, worst, and average case");
        }
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
