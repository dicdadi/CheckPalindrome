package dad.javafx.check.palindrome;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CheckPalindrome extends Application {

	private TextField nombreText;
	private Button saludarButton;
	private Label saludoLabel;
	@Override
	public void start(Stage primaryStage) throws Exception {
		nombreText= new TextField();
		nombreText.setPromptText("Introduce una sentencia");
		nombreText.setMaxWidth(150);
		
		saludoLabel = new Label ("¿Es palindromo?");
		saludarButton = new Button ("Comprobar");
		saludarButton.setDefaultButton(true);
		// poner utilizar on en el nombre del eventon que va a realizar
		saludarButton.setOnAction( e -> onCheckPalindrome(e));
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		//Aqui puedo cambiar el nombre del nombreText,saludar... etc, para que se cambie el orden
		root.getChildren().addAll(nombreText,saludarButton,saludoLabel);
		Scene scene = new Scene ( root, 320, 200);
		
		primaryStage.setTitle("Hola JavaFX Mejorado");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	private void onCheckPalindrome(ActionEvent e) {
		String sentencia = nombreText.getText();
		if(checkPalindrome(sentencia)) {
		saludoLabel.setText("Es palíndromo");
		saludoLabel.setStyle("-fx-text-fill: green; -fx-font:  bold 30 consolas;");
		}else {
			saludoLabel.setText("No es palíndromo");
			saludoLabel.setStyle("-fx-text-fill: red; -fx-font:  bold 30 consolas;");
			
		}
		// Set style es un estilo css
		
	}
	private boolean checkPalindrome(String entrada) {
		String cambiada=new StringBuilder(entrada).reverse().toString();
					
				return cambiada.equals(entrada);
		}

	public static void main(String[] args) {
		launch(args);

	}

}
