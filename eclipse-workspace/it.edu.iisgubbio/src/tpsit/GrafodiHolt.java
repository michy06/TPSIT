package tpsit;


public class GrafodiHolt{
	
	//variable and matrix declaration 
	int grafodiHolt [][];
	int dimensioniGrafo;

	//Constructor initializes a two-dimensional matrix ("grafodiHolt [][]")
	//specifying his dimensions via the parameter ("dimensioninGrafo")
	public GrafodiHolt(int dimensioniGrafo) {
	
		this.grafodiHolt =  new int[dimensioniGrafo][dimensioniGrafo];
		this.dimensioniGrafo=dimensioniGrafo;
		for (int k= 0; k< this.dimensioniGrafo; k++) {
			for (int j = 0; j < this.dimensioniGrafo; j++) {
				this.grafodiHolt[K][j]=0;
			}
			
		}

	}
	//"checkcolum" method checks if the sum of the items in the resources column is equal to 0.
	//returns true if the sum is 0 otherwise returns false.
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
	
	//The "setRequest" method sets a resource assignment for process and resource parameters.
	public void setRequest(int processo, int risorsa) {
	

		if (this.grafodiHolt[processo][risorsa]==0) {
			if (this.checkcolum(risorsa)){
				this.grafodiHolt[processo][risorsa]=1;
				//If the matrix element corresponding to 0 and the column (risorsa) has a sum of 0 
				//(verified by checkcolum) is assigned the value 1.
			}
			else {
				this.grafodiHolt[processo][risorsa]=2;
				//Otherwise, the value 2 is assigned 
			}
		}
		else {
			System.out.print("Errore assegnamento non possibile");
			//If assignment is not possible, an error message is printed.
		}

	}
	// the "print2D" method checks whether the two-dimensional matrix is printed on the console.
	public  void print2D() {
		
		for (int k = 0; k < this.dimensioniGrafo; k++) {
			for (int j = 0; j < this.dimensioniGrafo; j++) {
				System.out.print(this.grafodiHolt[k][j] + " ");
			}
			System.out.print("\n");
		}
	}



}



