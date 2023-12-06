package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CercaNumericonArrey extends Application {

	Button bCerca = new Button("Cerca"); 

	Label lCercanome = new Label("Nome:");

	TextField tCercanome = new TextField("");

	Label lRisultato= new Label("");


	public void start(Stage finestra) {


		bCerca.setOnAction(e -> Cerca());


		GridPane principale = new GridPane();

		principale.add(lCercanome, 0, 0);
		principale.add(tCercanome, 1, 0);
		principale.add(bCerca, 1,1);
		principale.add(lRisultato, 1, 2);


		Scene scena = new Scene(principale);

		finestra.setTitle("leggi file");
		finestra.setScene(scena);
		finestra.show();


	}
	private void Cerca() {
		int cercanumeri  = Integer.parseInt(tCercanome.getText());
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/nomi.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			String nomi;
			Stack<String> pilaDiNomi = new Stack<String>();
			pilaDiNomi.push("mario"); // la pila ha un solo elemento: "mario"
			pilaDiNomi.push("lucia"); // in testa (in cima) alla pila adesso c'è "lucia"
			pilaDiNomi.push("paola"); // in testa alla pila adesso c'è "paola"
			String nome = pilaDiNomi.pop();  // "paola" perché è l'elemento in testa alla pila
		
			nome = pilaDiNomi.peek(); // "lucia" perché è l'elemento in testa alla pila
			
			nome = pilaDiNomi.pop();  // ancora "lucia" perché peek() non lo aveva estratto
			
			nome = pilaDiNomi.pop();  // "mario", quello rimasto in cima alla pila
			
		}catch (IOException e ) {
			lRisultato.setText("");
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}