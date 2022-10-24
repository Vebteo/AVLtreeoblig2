package com.example.oblig2avl;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class AVLView<E extends Comparable<E>> extends Pane {
    private AVLTree<E> tree;
    private final static double RADIUS = 15;
    private double vGap = 50;
    private final static double XOFFSET = RADIUS/4;
    private final static double YOFFSET = RADIUS/4;

    AVLView(AVLTree<E> tree) {
        this.tree = tree;
        setStatus("Treet er tomt");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear();
        if(tree.getRoot() != null) {
            displayTree((AVLTree.AVLTreeNode<E>) tree.getRoot(), getWidth()/2, vGap, getWidth()/4);
        }
    }

    private void displayTree(AVLTree.AVLTreeNode<E> root, double x, double y, double hGap) {
        if(root.left != null) {
            getChildren().add(new Line(x-hGap, y+vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<E>) root.left, x-hGap, y+vGap, hGap/2);
        }
        if(root.right != null) {
            getChildren().add(new Line(x+hGap, y+vGap, x, y));
            displayTree((AVLTree.AVLTreeNode<E>) root.right, x+hGap, y+vGap, hGap/2);
        }

        Circle circle = new Circle(x, y, RADIUS);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle, new Text(x-XOFFSET, y+YOFFSET, root.element + ""));
    }

    public AVLTree<E> getTree() {
        return tree;
    }
}
