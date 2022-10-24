package com.example.oblig2avl;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Random;

public class AVLAnimation extends Application {
    AVLView view;
    final static int STØRRELSE = 1000;
    TextField tfInteger, tfString;
    int valgVerdi;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //AVLTree<Integer> tree = new AVLTree<>();
        BorderPane pane = new BorderPane();
        VBox valgPane = new VBox(10);
        valgPane.setAlignment(Pos.CENTER);
        Button btInteger = new Button("Integer");
        Button btString = new Button("String");
        valgPane.getChildren().addAll(btInteger,btString);
        pane.setCenter(valgPane);

        HBox hBox = new HBox();
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btRandom = new Button("Random");
        Button btSøk = new Button("Søk");
        tfString = new TextField();
        tfString.setPrefColumnCount(3);
        tfString.setAlignment(Pos.BASELINE_RIGHT);
        tfInteger = new TextField();
        tfInteger.setPrefColumnCount(3);
        tfInteger.setAlignment(Pos.BASELINE_RIGHT);
        hBox.getChildren().addAll(new Label("verdi: "), tfInteger, tfString, btInsert, btDelete, btRandom, btSøk);
        hBox.setAlignment(Pos.CENTER);

        btInteger.setOnAction(e -> {
            AVLTree<Integer> tree = new AVLTree<>();
            view = new AVLView(tree);
            pane.getChildren().remove(valgPane);
            hBox.getChildren().remove(tfString);
            pane.setCenter(view);
            pane.setBottom(hBox);
            valgVerdi = 1;
        });

        btString.setOnAction(e -> {
            AVLTree<String> tree = new AVLTree<>();
            view = new AVLView(tree);
            pane.getChildren().remove(valgPane);
            hBox.getChildren().remove(tfInteger);
            pane.setCenter(view);
            pane.setBottom(hBox);
            valgVerdi = 2;
        });

        btRandom.setOnAction(e -> {
            if (valgVerdi == 1) {
                for(int i=0; i<10; i++) {
                    int min = 1;
                    int max = 30;
                    int randomTall = (int) (Math.random()*(max-min+1)+min);
                    view.getTree().insert(randomTall);
                    view.displayTree();
                }
            } else { // String random
                for (int i = 0; i < 10; i++) {
                    Random r = new Random();
                    char c = (char)(r.nextInt(26) + 'A');
                    view.getTree().insert(c);
                    view.displayTree();
                }
            }
        });

        btSøk.setOnAction(e -> {
            if (valgVerdi == 1) {
                int key = Integer.parseInt(tfInteger.getText());
                if(view.getTree().search(key)) {
                    view.setStatus(key + " finnes alt");
                } else {
                    view.setStatus(key + " finnes ikke i treet");
                }

            } else {
                if(view.getTree().search(tfString.getText())) {
                    view.setStatus(tfString.getText() + " finnes alt");
                } else {
                    view.getTree().insert(tfString.getText());
                    view.setStatus(tfString.getText() + " finnes ikke i treet");
                }
            }
            view.displayTree();
        });

        btInsert.setOnAction(e -> {
            if(valgVerdi == 1) {
                int key = Integer.parseInt(tfInteger.getText());
                if(view.getTree().search(key)){
                    view.displayTree();
                    view.setStatus(key + " finnes alt");
                } else {
                    view.getTree().insert(key);
                    view.displayTree();
                    view.setStatus(key + " er satt inn");
                }
            } else {
                if(view.getTree().search(tfString.getText())){
                    view.displayTree();
                    view.setStatus(tfString.getText() + " finnes alt");
                } else {
                    view.getTree().insert(tfString.getText());
                    view.displayTree();
                    view.setStatus(tfString.getText() + " er satt inn");
                }
            }
            view.displayTree();
        });

        btDelete.setOnAction(e -> {
            if(valgVerdi == 1) {
                int key = Integer.parseInt(tfInteger.getText());
                if (!view.getTree().search(key)) {
                    view.displayTree(); // Trengs denne?
                    view.setStatus(key + " finnes ikke");
                } else {
                    view.getTree().delete(key);
                    view.displayTree();
                    view.setStatus(key + " er slettet");
                }
            }
            else {
                if (!view.getTree().search(tfString.getText())) {
                    view.displayTree(); // Trengs denne?
                    view.setStatus(tfString.getText() + " finnes ikke");
                } else {
                    view.getTree().delete(tfString.getText());
                    view.displayTree();
                    view.setStatus(tfString.getText() + " er slettet");
                }
            }

        });

        Scene scene = new Scene(pane, STØRRELSE, STØRRELSE/2);
        primaryStage.setTitle("AVL-Tre");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

