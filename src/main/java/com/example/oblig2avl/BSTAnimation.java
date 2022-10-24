package com.example.oblig2avl;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class BSTAnimation extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BST<Integer> tree = new BST<>();
        BorderPane pane = new BorderPane();
        BSTView view = new BSTView(tree);
        pane.setCenter(view);
        TextField tfKey = new TextField();
        tfKey.setPrefColumnCount(3);
        tfKey.setAlignment(Pos.BASELINE_RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        HBox hBox = new HBox();
        hBox.getChildren().addAll(new Label("Tall: "), tfKey, btInsert, btDelete);
        hBox.setAlignment(Pos.CENTER);
        pane.setBottom(hBox);

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if(tree.search(key)) {
                view.displayTree();
                view.setStatus(key + " finnes alt");
            } else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " er satt inn");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfKey.getText());
            if (!tree.search(key)) {
                view.displayTree(); // Trengs denne?
                view.setStatus(key + " finnes ikke");
            } else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " er slettet");
            }
        });



        Scene scene = new Scene(pane,450, 250);
        primaryStage.setTitle("BSTAnimation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}



