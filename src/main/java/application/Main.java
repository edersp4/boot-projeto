package application;

import application.service.Configuracao;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Arrays;


public class Main extends Application {

    TableView<String> tableView;
    @Override
    public void start(Stage primaryStage) {
        try {
            AnchorPane rootLayout = new AnchorPane();
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("copy.fxml"));
            rootLayout = (AnchorPane) loader.load();
            ArquivoController controller = loader.getController();
            controller.setDialogStage(primaryStage);
            Scene scene = new Scene(rootLayout);
            scene.getStylesheets()
                    .add(Main.class.getResource("style.css")
                            .toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.setTitle("Copiar");
            primaryStage.setResizable(false);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }


}
