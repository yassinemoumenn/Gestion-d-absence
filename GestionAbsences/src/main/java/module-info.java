module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.java;
    requires rt;

    opens org.example to javafx.fxml;
    exports org.example;
}