package it.edu.iisgubbio;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ControllaErrore extends Application {

	Button bCalcola = new Button("Test"); 

	Label lRisultato = new Label("");

	TextField tInfo = new TextField("");

	Label lInfo = new Label("info:");
	String vInfo[];


	public void start(Stage finestra) {


		bCalcola.setOnAction(e -> calcola());

		GridPane principale = new GridPane();
		principale.add(lInfo, 0, 0);
		principale.add(tInfo, 1, 0);
		principale.add(bCalcola, 0, 1);
		principale.add(lRisultato, 0, 2);


		Scene scena = new Scene(principale);

		finestra.setTitle("Calcola Area");
		finestra.setScene(scena);
		finestra.show();


	}
	private void calcola() {
		vInfo = tInfo.getText().split(",");
		try {
		int area=Integer.parseInt(vInfo[2]);
		int lato=Integer.parseInt(vInfo[1]);
		String quadrato = "quadrato";
		if (vInfo[0].equals(quadrato) && lato * lato == area) {
			lRisultato.setText("ok");
		} else {
			lRisultato.setText("errore");
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			lRisultato.setText("pochi dati");
		}catch (NumberFormatException k) {
			lRisultato.setText("Non puoi scrivere lettere dopo la figura");
		}
	}


public static void main(String[] args) {
	launch(args);
}
}