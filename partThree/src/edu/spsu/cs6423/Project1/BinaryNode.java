package edu.spsu.cs6423.Project1;

/**
 * CS6423 Algorithmic Processes
 * Summer 2014
 * Project 1: Part 3 - Object for creating our binary tree
 * Daniel Kerr and Charles So
 * Date: 06/20/2014
 * File: BinaryNode.java
 */

public class BinaryNode {

    private Integer value;
    private BinaryNode LeftNode;
    private BinaryNode RightNode;

    public BinaryNode() {
        new BinaryNode(0);
    }

    public BinaryNode(Integer newValue) {
        setValue(newValue);
        setLeftNode(null);
        setRightNode(null);
    }

    public int addNewNode(BinaryNode root, Integer newValue) {
        int success = -1;

        if (newValue < root.getValue()) {
            if (root.getLeftNode() != null) {
                addNewNode(root.getLeftNode(), newValue);
            } else {
                BinaryNode newNode = new BinaryNode(newValue);
                root.setLeftNode(newNode);
                success = 1;
            }
        } else if (newValue > root.getValue()){
            if (root.getRightNode() != null) {
                addNewNode(root.getRightNode(), newValue);
            } else {
                BinaryNode newNode = new BinaryNode(newValue);
                root.setRightNode(newNode);
                success = 2;
            }
        } else {
            success = 3;
        }
        return success;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public BinaryNode getLeftNode() {
        return LeftNode;
    }

    public void setLeftNode(BinaryNode leftNode) {
        LeftNode = leftNode;
    }

    public BinaryNode getRightNode() {
        return RightNode;
    }

    public void setRightNode(BinaryNode rightNode) {
        RightNode = rightNode;
    }
}
