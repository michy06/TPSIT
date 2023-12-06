package it.edu.iisgubbio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Filtranumeri extends Application {

	Button bFiltra = new Button("Filtra"); 

	Label lMin= new Label("Min:");

	Label lMax= new Label("Max:");

	TextField tMin = new TextField("");

	TextField tMax = new TextField("");

	Label lRisultato= new Label("");

	public void start(Stage finestra) {


		bFiltra.setOnAction(e -> filtra());


		GridPane principale = new GridPane();

		principale.add(lMin, 0, 0);
		principale.add(tMin, 1, 0);
		principale.add(lMax, 0, 1);
		principale.add(tMax, 1, 1);
		principale.add(bFiltra, 1, 3);
		principale.add(lRisultato, 1, 4);


		Scene scena = new Scene(principale);

		finestra.setTitle("leggi file");
		finestra.setScene(scena);
		finestra.show();


	}
	private void filtra() {
		int min = Integer.parseInt(tMin.getText());
		int max = Integer.parseInt(tMax.getText());

		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/numeri.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			FileWriter flussoCaratteriscritti = new FileWriter("/Users/classe4I/Desktop/numeri1.txt");
			String rigaLetta;

			do {
				rigaLetta = lettoreDiRighe.readLine();
				if(rigaLetta!=null) {
					if(Integer.parseInt(rigaLetta)>=min && Integer.parseInt(rigaLetta)<=max) {
						flussoCaratteriscritti.write(rigaLetta+"\n");
					}
				} 

			}while(rigaLetta!=null);        
			lettoreDiRighe.close();
			flussoCaratteriscritti.close();
			flussoCaratteri.close();
		
		
		
		}catch (IOException e ) {
			lRisultato.setText(" nessun accesso al file ");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}