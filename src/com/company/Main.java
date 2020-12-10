package com.company;

public class Main {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        binarySearchTree.add(54);
        binarySearchTree.add(18);
        binarySearchTree.add(78);
        binarySearchTree.add(64);
        binarySearchTree.add(80);
        binarySearchTree.add(13);
        System.out.println(binarySearchTree.contains(78));
        System.out.println(binarySearchTree.contains(55));
        binarySearchTree.deleteKey(78);
        binarySearchTree.deleteKey(18);
        System.out.println(binarySearchTree.contains(18));
        System.out.println(binarySearchTree.contains(78));
        binarySearchTree.printMaxValue();
        binarySearchTree.printMinValue();
        System.out.println("Traverse in reverse order");
        binarySearchTree.traverseInReverseOrder(binarySearchTree.head);
        System.out.println("\nTraverse in order");
        binarySearchTree.traverseInOrder(binarySearchTree.head);
        System.out.println("\nTraverse in level order");
        binarySearchTree.traverseLevelOrder();
    }
}
