module org.example {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires mysql.connector.java;
   /* requires rt;*/
   /* requires jfxrt;*/

    exports org.example;
    exports org.example.Model;

    opens org.example to javafx.fxml;
    opens org.example.Model to javafx.fxml;
}