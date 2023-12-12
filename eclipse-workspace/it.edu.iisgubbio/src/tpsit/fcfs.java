package tpsit;
public class fcfs {

	public static void main(String[] args ) {
		
		// Dichiarazione e inizializzazione degli array e variabile media per:
	    //i processi, i tempi di arrivo, esecuzione, servizio e attesa
		String[] processo= new String[4];
		int []tArrivo=new int [4];
		int []tEsecuzione=new int [4];
		int []tServizio=new int [4];
		double []tAttesa=new double [4];
		double media=0;
		
		
		// Inizializzazione dei nomi dei processi
		processo[0]="P0";  
		processo[1]="P1";
		processo[2]="P2";
		processo[3]="P3";

		
		//1) Ciclo For: 
		//rappresentare i tempi di arrivo dei processi nel sistema tramite l'assegniazione di valori crescenti
		// a "tArrivo" che gli viene assegnato il valore "X". Ogni volta che il For terminerà il suo giro conterà i seguenti 
		// valori "[0, 1, 2, 3,]"
		
		for (int x=0; x<4;x++) { 
			tArrivo[x]=x;
		}
		
	
		// Inizializzazione dei tempi di esecuzione
		tEsecuzione[0]=5; 
		tEsecuzione[1]=3;
		tEsecuzione[2]=8;
		tEsecuzione[3]=6;


		//2) Ciclo For: 
		//calcola il tempo di servizio , di attesa e la media
		for(int k=0; k<4;k++) {
			
			//"K" rappresenta i processi che scorrono grazie al ciclo For 
			if(k==0) { 
				tServizio[k]=0;
				tAttesa[k]=0;
				//"K==0" essendo il primo porcesso ha i tempi di servizio e d'attesa uguali a 0 
		
			}else {
				tServizio[k]=tServizio[k-1]+tEsecuzione[k-1];
				//Il tempo di servizio è calcolato:
				//dalla somma del tempo di servizio del processo precedente e il tempo di esecuzione del processo in esecuzione
				tAttesa[k]=tServizio[k]-tArrivo[k];
				//Il tempo di servizio è calcolato:
				//dalla differenza tra il tempo di servizio e il tempo d'arrivo del processo in esecuzione
				
				media=media+tAttesa[k]/tAttesa.length;
				//la media ogni giro di Ciclo For viene aggiornata 
				//sommando il rapporto tra il tempo d'attese del processo in esecuzione e la lunghezza di "tAttesa"
			}

		}
		// Stampa i nomi dei processi
		for (int i=0; i<=3;i++) {             
			System.out.println(processo[i]);

		}
		// Stampa i tempi di servizio
		for (int p=0; p<=3;p++) {
			System.out.println(tServizio[p]);

		}
		// Stampa i tempi di attesa
		for (int l=0; l<=3;l++) {
			System.out.println(tAttesa[l]); 

		}
		// Stampa la media 
		System.out.println("la media è : "+media);

	}
}
