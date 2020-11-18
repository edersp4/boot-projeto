module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires commons.io;
    requires org.eclipse.jgit;
    requires zip4j;
    requires commons.configuration2;
    requires javafx.base;

    opens application to javafx.fxml;
    exports application;
}