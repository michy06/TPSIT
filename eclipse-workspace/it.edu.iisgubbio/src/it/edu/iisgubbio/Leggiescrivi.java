package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Leggiescrivi extends Application{
	Button bLeggi= new Button("leggi"); 

	Button bScrivi= new Button("scrivi"); 

	TextField tLeggiescrivi = new TextField("");

	public void start(Stage finestra) {


		bLeggi.setOnAction(e -> leggi());
		bScrivi.setOnAction(e -> scrivi());

		GridPane principale = new GridPane();
		principale.add(tLeggiescrivi, 0, 1);
		principale.add(bScrivi, 0, 2);
		principale.add(bLeggi, 0, 0);
		
		Scene scena = new Scene(principale);

		finestra.setTitle("leggi e scrivi file");
		finestra.setScene(scena);
		finestra.show();

	}
	private void leggi() {
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/informazioni.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String testo = lettoreDiRighe.readLine();
			tLeggiescrivi.setText(testo);
			lettoreDiRighe.close();
			flussoCaratteri.close();
		}catch(IOException e) {
			tLeggiescrivi.setText("hai sbagliato posizione");

		}

	}

	
	private void scrivi() {
		try {
		String testo = tLeggiescrivi.getText();
		FileWriter flussoCaratteri = new FileWriter("/Users/classe4I/Desktop/informazioni.txt");
		flussoCaratteri.write(testo+"\n");
		flussoCaratteri.close();
		}catch (IOException r) {
			tLeggiescrivi.setText("");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
