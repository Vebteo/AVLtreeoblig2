module com.example.oblig2avl {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.oblig2avl to javafx.fxml;
    exports com.example.oblig2avl;
}