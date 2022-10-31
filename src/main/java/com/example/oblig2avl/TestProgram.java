package com.example.oblig2avl;

import java.util.Scanner;

public class TestProgram {
    public static void main(String[] args) {
        AVLTree<Double> tree = new AVLTree<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 5 numbers: ");
        for (int i = 0; i < 5; i++) {
            tree.insert(input.nextDouble());
        }

        System.out.print("Enter k: ");
        int k = input.nextInt();
        System.out.println("The " + k + "th smallest number is "
                + tree.find(k));
    }
}

/**
class AVLTree<E extends Comparable<E>> extends BST<E> {
    // Copy and complete your code here

}

 */