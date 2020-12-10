package com.company;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public Node head;

    //region Public Methods
    public void add(int value) {
        head = addRecursive(head, value);
    }

    public boolean contains(int values) {
        System.out.print("head value contains " + values + " = ");
        return find(head, values) != null;
    }

    public void deleteKey(int key) {
        head = deleteRec(head, key);
    }

    public void printMinValue(){
        System.out.println("Min value = " + min());
    }

    public void printMaxValue(){
        System.out.println("Max value = " + max());
    }


    public void traverseInReverseOrder(Node node){
        if (node != null){
            traverseInReverseOrder(node.right);
            System.out.print(node.value + " ");
            traverseInReverseOrder(node.left);
        }
    }

    public void traverseInOrder(Node node){
        if (node != null){
            traverseInOrder(node.left);
            System.out.print(node.value + " ");
            traverseInOrder(node.right);
        }
    }

    public void traverseLevelOrder() {
        if (head == null) {
            return;
        }

        Queue<Node> nodes = new LinkedList<>();
        nodes.add(head);

        while (!nodes.isEmpty()) {

            Node node = nodes.remove();

            System.out.print(node.value + " ");

            if (node.left != null) {
                nodes.add(node.left);
            }

            if (node.right != null) {
                nodes.add(node.right);
            }
        }
    }
    //endregion

    //region Private Methods
    //Binary search tree insert method
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            return current;
        }
        return current;
    }

    //binary search tree contains Method
    private Node find(Node head, int values) {
        if (head == null) {
            return null;
        }
        if (head.value == values) {
            return head;
        } else if (values < head.value) {
            return find(head.left, values);
        } else {
            return find(head.right, values);
        }

    }

    //Find binary search tree min value
    private Integer min() {
        Node current = head;
        while (current.left != null) {
            current = current.left
            ;
        }
        return current.value;
    }

    //Find binary search tree max value
    private Integer max() {
        Node current = head;
        while (current.right != null) {
            current = current.right;
        }
        return current.value;
    }

    //binary search tree delete value method
    private Node deleteRec(Node current, int value) {
        if (current == null)
            return null;

        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }
            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = deleteRec(current.right, smallestValue);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRec(current.left, value);
            return current;
        }
        current.right = deleteRec(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    //endregion
}
