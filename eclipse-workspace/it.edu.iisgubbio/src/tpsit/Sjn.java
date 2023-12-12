package it.edu.iisgubbio;

public class SJN {
	


	public static void main(String[] args) {
		// Dichiarazione e inizializzazione degli array e variabile mediaAttesa per:
	    //i processi, i tempi di arrivo, esecuzione, servizio e attesa
		String [] processo = new String [4];
		int [] arrivo = new int [4];
		int [] esecuzione = new int [4];
		int [] servizio = new int [4];
		int [] attesa = new int [4];

		double mediaAttesa;
		// Inizializzazione dei nomi dei processi
		processo[0] = "P0";
		processo[1] = "P1";
		processo[2] = "P2";
		processo[3] = "P3";
		
		//1) Ciclo For: 
		//I tempi di arrivo vengono inizializzati con valori crescenti da 0 a 3 nell'array ("arrivo").
		for(int x = 0; x<4; x++) {
			arrivo[x]=x;
		}
		
		
		// Inizializzazione dei tempi di esecuzione
		esecuzione[0] = 5;
		esecuzione[1] = 3;
		esecuzione[2] = 8;
		esecuzione[3] = 6;
		
		
		//Viene utilizzato l'algoritmo di ordinamento a bolle (Bubble sort) 
		//con l'obiettivo di ordinare i tre array :
		//("processo") ("arrivo")("esecuzione") in base ai tempi di esecuzione dei processi in ordine crescente
		
		int ultimo = esecuzione.length-1;  
		//Viene calcolato l'indice dell'ultimo elemento dell'array ("esecuzione") 
		
		
		//troviamo 2 Cicli for necessari per eseguire l'algoritmo 
		for(int superficie=0;superficie<=ultimo-1;superficie=superficie+1){
			//1) Ciclo For ripete attraverso l'array fino al penultimo elemento.

			for(int posizione=ultimo-1;posizione>=superficie;posizione--){
			//2) Ciclo For ripete dall'ultimo elemento fino a superficie.
				
				if(esecuzione[posizione]>esecuzione[posizione+1]){
				//questa condizione verifica se il tempo di esecuzione del processo corrente 
				//è maggiore del tempo di esecuzione del processo successivo.	
					
					int appoggioEsecuzione=esecuzione[posizione];
					String appoggioProcesso = processo[posizione];
					int appoggioArrivo = arrivo[posizione];
					
					esecuzione[posizione]=esecuzione[posizione+1];
					processo[posizione]=processo[posizione+1];
					arrivo[posizione]=arrivo[posizione+1];
					
					esecuzione[posizione+1]=appoggioEsecuzione;
					processo[posizione+1]=appoggioProcesso;
					arrivo[posizione+1]=appoggioArrivo;
					//Se la condizione è vera, viene eseguita una "Sostituzione (swap)" degli elementi corrispondenti negli array.
					//vengono scambiati i tempi di esecuzione, i nomi dei processi e i tempi di arrivo dei processi per posizionare 
					//i processi in ordine crescente in base ai tempi di esecuzione.
				}
			}
		}


		
		// Questo Ciclo For calcola i tempi di servizio, d'attesa e la media dei tempi di attesa per i processi ordinati.
		for(int y = 0; y<4; y++) {
			
			//"y" rappresenta i processi che scorrono grazie al ciclo For 
			if(y==0) {
				
				//"y==0" essendo il primo porcesso ha i tempi di servizio e d'attesa uguali a 0 
				servizio[0]= 0;
				attesa[0]=0;
				

			}else {

				servizio[y]=servizio[y-1]+esecuzione[y-1];
				// i tempi di servizio vengono calcolati dalla somma:
				//del tempo di esecuzione del processo precedente (esecuzione[y-1])
				//e il tempo di servizio del processo precedente (servizio[y-1]).			
				
				attesa[y] =  servizio[y]-arrivo[y];
				//Il tempo di attesa viene calcolato sottraendo il tempo di arrivo del processo corrente (arrivo[y]) 
				// dal tempo di servizio corrispondente.
			}
		}

		mediaAttesa =(double)(attesa[0]+attesa[1]+attesa[2]+attesa[3])/4;
		//Viene calcolata la media dei tempi di attesa per tutti i processi, dividendola per il numero totale di processi (4)
		
		for(int i = 0; i<=3; i++) {
			System.out.println(processo[i]);
			//tramite un ciclo for andiamo a staampare i nomi dei processi ordinati.
		}
		
		
        //Stampa la stringa "processi".
		System.out.println("processi");
		
		for(int i = 0; i<=3; i++) {
			System.out.println(esecuzione[i]);
			//Utilizza un for per far ripetere attraverso l'array esecuzione e stampare ciascun elemento
		}
		
		//Stampa la stringa "esecuzioni".
		System.out.println("esecuzioni");
		
		
		for(int i = 0; i<=3; i++) {
			System.out.println(servizio[i]);
			//Utilizza un for per far ripetere attraverso l'array esecuzione e stampare ciascun elemento
		}
        //Stampa la stringa "servizi".
		System.out.println("servizi");
		
		for(int i = 0; i<=3; i++) {
			System.out.println(attesa[i]);
			//Utilizza un for per far ripetere attraverso l'array esecuzione e stampare ciascun elemento
		}
		
        //Stampa la stringa "attese".
		System.out.println("attese");
		
		
		System.out.println("la media attesa è: "+mediaAttesa);
        //Stampa la media delle attese, che sembra essere memorizzata nella variabile mediaAttesa.
		
	}
	
}
