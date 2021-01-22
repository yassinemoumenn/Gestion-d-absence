module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.java;
    requires rt;
    requires jfxrt;

    opens org.example to javafx.fxml;
    exports org.example;
    opens org.example.Model to javafx.fxml;
    exports  org.example.Model;
}