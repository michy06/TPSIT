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

public class Cercanumeri extends Application {

	Button bCerca= new Button("cerca"); 

	Label lNumeroriga= new Label("numero");

	TextField tNumeroriga = new TextField("");

	Label lRisultato= new Label("");


	public void start(Stage finestra) {


		bCerca.setOnAction(e -> cerca());


		GridPane principale = new GridPane();
		principale.add(lNumeroriga, 0, 0);
		principale.add(tNumeroriga, 1, 0);
		principale.add(bCerca, 0, 1);
		principale.add(lRisultato, 1, 1);


		Scene scena = new Scene(principale);

		finestra.setTitle("leggi file");
		finestra.setScene(scena);
		finestra.show();


	}
	private void cerca() {
		int numero = Integer.parseInt(tNumeroriga.getText());
		boolean trovato=false;
		int contatore = 0;
		int contaRighe = 0;

		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/numeri.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String rigaLetta;

			do {
				rigaLetta = lettoreDiRighe.readLine();
				if(rigaLetta!=null) {
					contaRighe++;
					if(numero==Integer.parseInt(rigaLetta)) {
						trovato = true;
						contatore++;
					}
				} 


			}while(rigaLetta!=null);        
			lettoreDiRighe.close();
			flussoCaratteri.close();
			if (trovato) {
				lRisultato.setText("c'è " + contatore + " volte su " + contaRighe + " righe " );
			}else {
				lRisultato.setText("il numero non c'è");
			}
		}catch (IOException e ) {
			lRisultato.setText(" nessun accesso al file ");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}