package tpsit;


public class GrafodiHolt{
	
	//dichiarazione varibile e l'ammatrice 
	int grafodiHolt [][];
	int dimensioniGrafo;

	//Il costruttore inizializza una matrice bidimensionale ("grafodiHolt [][]")
	//specificando le sue dimensioni tramite il paramtro ("dimensioniGrafo")
	public GrafodiHolt(int dimensioniGrafo) {
	
		this.grafodiHolt =  new int[dimensioniGrafo][dimensioniGrafo];
		this.dimensioniGrafo=dimensioniGrafo;
		for (int k= 0; k< this.dimensioniGrafo; k++) {
			for (int j = 0; j < this.dimensioniGrafo; j++) {
				this.grafodiHolt[K][j]=0;
			}
			
		}

	}
	//il metodo "checkcolum" verifica se la somma degli elementi nella colonna resources è uguale a 0.
	//restituisce true se la somma è 0 altrimenti restituisce false.
	public Boolean checkcolum(int resources) { 
		
		int somma = 0;
		for (int k = 0; k < this.dimensioniGrafo; k++) {
			somma = somma  + this.grafodiHolt[k][resources];
		}
		if (somma == 0) {
			return (true);
		}
		else {
			return(false);
		}
	}
	//Il metodo "setRequest" imposta un'assegnazione di risorsa per i parametri processo e risorsa.
	
	//Altrimenti, viene assegnato il valore 2. Se l'assegnamento non è possibile, viene stampato un messaggio di errore.
	public void setRequest(int processo, int risorsa) {
	

		if (this.grafodiHolt[processo][risorsa]==0) {
			if (this.checkcolum(risorsa)){
				this.grafodiHolt[processo][risorsa]=1;
				//Se l'elemento della matrice corrispondente a 0 e la colonna (risorsa) ha una somma di 0 
				//(verificato tramite checkcolum) viene assegnato il valore 1.
			}
			else {
				this.grafodiHolt[processo][risorsa]=2;
				//Altrimenti, viene assegnato il valore 2 
			}
		}
		else {
			System.out.print("Errore assegnamento non possibile");
			//Se l'assegnamento non è possibile, viene stampato un messaggio di errore.
		}

	}
	// il metodo "print2D" verifica se stampa la matrice bidimensionale  sulla console.
	public  void print2D() {
		
		for (int k = 0; k < this.dimensioniGrafo; k++) {
			for (int j = 0; j < this.dimensioniGrafo; j++) {
				System.out.print(this.grafodiHolt[k][j] + " ");
			}
			System.out.print("\n");
		}
	}



}



