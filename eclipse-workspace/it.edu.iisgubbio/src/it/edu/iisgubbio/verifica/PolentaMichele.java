package it.edu.iisgubbio.verifica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PolentaMichele extends Application  {

	Label lMateria = new Label("Materia:");

	TextField tMateria  = new TextField("");

	Button bMateria= new Button("cerca materia"); 


	Label lInsegnanti = new Label("Inseganti:");

	TextField tInsegnanti = new TextField("");

	Button bInsegnanti = new Button("elenco"); 

	Label lRisultatoMateria = new Label("");

	Label lRisultatoelenco = new Label("");

	public void start(Stage finestra) {

		bMateria.setOnAction(e -> materia());
		bInsegnanti.setOnAction(e -> insegnanti());

		GridPane principale = new GridPane();
		principale.add(lMateria, 0, 0);
		principale.add(tMateria, 1, 0);
		principale.add(bMateria, 2, 0);
		principale.add(lRisultatoMateria, 1, 1);

		principale.add(lInsegnanti, 0, 2);
		principale.add(tInsegnanti, 1, 2);
		principale.add(bInsegnanti, 2, 2);
		principale.add(lRisultatoelenco, 1, 4);
		principale.getStylesheets().add("it/edu/iisgubbio/verifica/PolentaMichele.css");

		Scene scena = new Scene(principale);

		finestra.setTitle("elenco e materie insegnanti");
		finestra.setScene(scena);
		finestra.show();


	}
	private void materia() {
		String materia = tMateria.getText();
		int contatore = 0;

		try (
				FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/elencoAttivita.csv");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
				){
			String rigaLetta;

			do { 
				rigaLetta = lettoreDiRighe.readLine();
				if(rigaLetta!=null) {
					String [] valore =  rigaLetta.split(",");
					if (materia.equals(valore[1])) {
						contatore++;
					}
				}

			}while(rigaLetta!=null);


		}catch(IOException e) {
			lRisultatoMateria.setText("errore");
		}
		lRisultatoMateria.setText(""+contatore);
	}


	private void insegnanti() {

	}


	public static void main(String[] args) {
		launch(args);
	}

}







