package application;
	
import application.controller.ArquivoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			AnchorPane  rootLayout = new AnchorPane();
		    FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/copy.fxml"));
            rootLayout = (AnchorPane) loader.load();
            ArquivoController controller = loader.getController();
			controller.setDialogStage(primaryStage);
    		Scene scene = new Scene(rootLayout);
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("Copiar");
			primaryStage.setResizable(false);
		    primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
