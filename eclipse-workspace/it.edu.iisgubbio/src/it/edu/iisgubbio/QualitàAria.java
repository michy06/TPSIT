package it.edu.iisgubbio;

import javafx.application.Application;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class QualitàAria  extends Application  {

	Label lProvince= new Label("Province");

	Button bCerca= new Button("cerca"); 

	TextField tProvincia  = new TextField("");

	Label lRisultato= new Label("");

	public void start(Stage finestra) {


		bCerca.setOnAction(e -> cerca());


		GridPane principale = new GridPane();
		principale.add(lProvince, 0, 0);
		principale.add(tProvincia, 1, 0);
		principale.add(bCerca, 0, 1);
		principale.add(lRisultato, 1, 1);


		Scene scena = new Scene(principale);

		finestra.setTitle("leggi file");
		finestra.setScene(scena);
		finestra.show();


	}
	private void cerca() {
		try (
				FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/qualitaDellAria.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
				){
			String [] rigaLetta;

			do { 
				rigaLetta = lettoreDiRighe.readLine().toLowerCase().split(", ");
				if(rigaLetta!=null) {
					String [] valore =  rigaLetta;
					if(valore[0].toUpperCase()+" "+valore[2]);
				}


			}while(rigaLetta!=null);        

		}catch (IOException e ) {
			lRisultato.setText("errore");
		}


	}

	public static void main(String[] args) {
		launch(args);
	}
}

