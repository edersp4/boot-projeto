package application.utils;

import javafx.scene.control.Alert;

public class AlertUtils {
    public static void criarAlerta(Alert.AlertType type, String title, String header, String context) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.show();
    }
}
