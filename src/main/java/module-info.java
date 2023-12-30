module com.mycompany.proyecto2_ed {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.proyecto2_ed to javafx.fxml;
    exports com.mycompany.proyecto2_ed;
}
