package dad.javafx.calendario.app;

import dad.javafx.calendario.CalendarioController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CalendarioApp extends Application {
	private CalendarioController root;
	@Override
	public void start(Stage primaryStage) throws Exception {
		root = new CalendarioController();

		Scene scene = new Scene(root.getView());
		primaryStage.setTitle("Calendario");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}

}
