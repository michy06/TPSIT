package it.edu.iisgubbio;

public class SJN {
	


	public static void main(String[] args) {
	     // Declaration and initialization of arrays and variable "mediaAttesa" for:
	    //processes, arrival, execution, service and waiting times
		String [] processo = new String [4];
		int [] arrivo = new int [4];
		int [] esecuzione = new int [4];
		int [] servizio = new int [4];
		int [] attesa = new int [4];

		double mediaAttesa;
		// Initialization of process names
		processo[0] = "P0";
		processo[1] = "P1";
		processo[2] = "P2";
		processo[3] = "P3";
		
		//1) Ciclo For: 
		//Arrival times are initialized with values increasing from 0 to 3 in the array ("arrivo").
		for(int x = 0; x<4; x++) {
			arrivo[x]=x;
		}
		
		
		// Initialization of execution times
		esecuzione[0] = 5;
		esecuzione[1] = 3;
		esecuzione[2] = 8;
		esecuzione[3] = 6;
		
		
		//The bubble sorting algorithm is used (Bubble sort) 
		//with the goals to sort the three arrays :
		//("processo") ("arrivo")("esecuzione") according to the execution times of the processes in ascending order
		
		int ultimo = esecuzione.length-1;  
		//The index of the last element of the array is calculated ("esecuzione") 
		
		
		//we find 2 Cicli For for needed to run the algorithm 
		for(int superficie=0;superficie<=ultimo-1;superficie=superficie+1){
			//1) Ciclo For repeats the array to the penultimate element.

			for(int posizione=ultimo-1;posizione>=superficie;posizione--){
			//2) Ciclo For repeats from last element to "superficie".
				
				if(esecuzione[posizione]>esecuzione[posizione+1]){
				//this condition checks if the running time of the current process 
				//is greater than the execution time of the next process.	
					
					int appoggioEsecuzione=esecuzione[posizione];
					String appoggioProcesso = processo[posizione];
					int appoggioArrivo = arrivo[posizione];
					
					esecuzione[posizione]=esecuzione[posizione+1];
					processo[posizione]=processo[posizione+1];
					arrivo[posizione]=arrivo[posizione+1];
					
					esecuzione[posizione+1]=appoggioEsecuzione;
					processo[posizione+1]=appoggioProcesso;
					arrivo[posizione+1]=appoggioArrivo;
					//If the condition is true, a "swap" of the corresponding elements in the arrays is performed.
					//Execution times, process names and process arrival times are exchanged in place 
					//processes in ascending order according to execution times.

				}
			}
		}


		
		// This Ciclo For calculates the service times, waiting times and the average waiting times for the ordered processes.
		for(int y = 0; y<4; y++) {
			
			//"y" represents the processes that flow thanks to the Ciclo For 
			if(y==0) {
				
				//"y==0"  the first porcess has the service and waiting times equal to 0 
				servizio[0]= 0;
				attesa[0]=0;
				

			}else {

				servizio[y]=servizio[y-1]+esecuzione[y-1];
				// service times are calculated from the sum:
				//the execution time of the previous process (esecuzione[y-1])
				//and the service time of the previous process (servizio[y-1]).			
				
				attesa[y] =  servizio[y]-arrivo[y];
				//The waiting time is calculated by subtracting the arrival time of the current process (arrivo[y]) 
				// from the corresponding service time.
			}
		}

		mediaAttesa =(double)(attesa[0]+attesa[1]+attesa[2]+attesa[3])/4;
		//The average waiting time for all processes is calculated, dividing it by the total number of processes (4)
		
		for(int i = 0; i<=3; i++) {
			System.out.println(processo[i]);
			//with the ciclo for Let’s go to print the names of the processes ordered.
		}
		
		
        //Print the string "processi".
		System.out.println("processi");
		
		for(int i = 0; i<=3; i++) {
			System.out.println(esecuzione[i]);
			//Use a for to repeat through the execution array and print each item
		}
		
		//Print the string "esecuzioni".
		System.out.println("esecuzioni");
		
		
		for(int i = 0; i<=3; i++) {
			System.out.println(servizio[i]);
			//Use a for to repeat through the execution array and print each item
        //Print the string "servizi".
		System.out.println("servizi");
		
		for(int i = 0; i<=3; i++) {
			System.out.println(attesa[i]);
			//Use a for to repeat through the execution array and print each item
		}
		
        //Print the string "attese".
		System.out.println("attese");
		
		
		System.out.println("la media attesa è: "+mediaAttesa);
        //Print the average of the expectations, which seems to be stored in the average mediaAttesa
		
	}
	
}
