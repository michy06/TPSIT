package it.edu.iisgubbio;

import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Reader extends Application {

	Button bLeggi= new Button("leggi"); 

	Label lPosizione= new Label("posizione:");

	TextField tPosizione = new TextField("");

	Label lRisultato= new Label("");

	public void start(Stage finestra) {


		bLeggi.setOnAction(e -> leggi());


		GridPane principale = new GridPane();
		principale.add(lPosizione, 0, 0);
		principale.add(tPosizione, 1, 0);
		principale.add(bLeggi, 0, 1);
		principale.add(lRisultato, 0, 2);


		Scene scena = new Scene(principale);

		finestra.setTitle("leggi file");
		finestra.setScene(scena);
		finestra.show();


	}

	private void leggi() {
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/informazioni.txt");
			char caratteri[] = new char[10];
			flussoCaratteri.read(caratteri);
			lRisultato.setText(""+ caratteri[Integer.parseInt(tPosizione.getText())]);
			flussoCaratteri.close();
		}catch(IOException e) {
			lRisultato.setText("hai sbagliato posizione");

		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}