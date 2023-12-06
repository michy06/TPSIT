package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Leggiriga extends Application {

	Button bLeggi= new Button("leggi"); 

	Label lNumeroriga= new Label("N:");

	TextField tNumeroriga = new TextField("");

	Label lRisultato= new Label("");


	public void start(Stage finestra) {


		bLeggi.setOnAction(e -> leggi());


		GridPane principale = new GridPane();
		principale.add(lNumeroriga, 0, 0);
		principale.add(tNumeroriga, 1, 0);
		principale.add(bLeggi, 0, 1);
		principale.add(lRisultato, 0, 2);


		Scene scena = new Scene(principale);

		finestra.setTitle("leggi griglia");
		finestra.setScene(scena);
		finestra.show();


	}
	private void leggi() {
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/tanteRighe.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String rigaLetta = lettoreDiRighe.readLine();
			int contatore=
			do {
				
				if(rigaLetta!=null) {
					// uso la riga letta
					tNumeroriga.setText(rigaLetta);
				}
			} while(rigaLetta!=null);        
			lettoreDiRighe.close();
			flussoCaratteri.close();
			}catch (IOException e) {
			lRisultato.setText("hai sbagliato posizione");
			
			}

	}
	public static void main(String[] args) {
		launch(args);
	}
}
