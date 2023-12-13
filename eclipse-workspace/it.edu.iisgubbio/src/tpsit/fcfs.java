package tpsit;
public class fcfs {

	public static void main(String[] args ) {
		
	     // Declaration and initialization of arrays and average variable for:
	    //processes, arrival, execution, service and waiting times
		String[] processo= new String[4];
		int []tArrivo=new int [4];
		int []tEsecuzione=new int [4];
		int []tServizio=new int [4];
		double []tAttesa=new double [4];
		double media=0;
		
		
		// Initialization of process names
		processo[0]="P0";  
		processo[1]="P1";
		processo[2]="P2";
		processo[3]="P3";

		
		//1) Ciclo For: 
		//to represent the arrival times of the processes in the system through the allocation of increasing values
		// to "tArrivo" which is assigned the value "X". Each time the For finishes its turn it will count the following 
		// values "[0, 1, 2, 3,]"
		
		for (int x=0; x<4;x++) { 
			tArrivo[x]=x;
		}
		
	
		// Initialization of execution times
		tEsecuzione[0]=5; 
		tEsecuzione[1]=3;
		tEsecuzione[2]=8;
		tEsecuzione[3]=6;


		//2) Ciclo For: 
		//calculate service time , waiting time and average
		for(int k=0; k<4;k++) {
			
			//"K" represents the processes that flow thanks to the Ciclo For
			if(k==0) { 
				tServizio[k]=0;
				tAttesa[k]=0;
				//"K==0" the first porcess has the service and waiting times equal to 0 
		
			}else {
				tServizio[k]=tServizio[k-1]+tEsecuzione[k-1];
				//The working time is calculated:
				//from the sum of the service time of the previous process and the execution time of the running process
				tAttesa[k]=tServizio[k]-tArrivo[k];
				//The working time is calculated:
				//the difference between the service time and the arrival time of the running process
				
				media=media+tAttesa[k]/tAttesa.length;
				//the average every round of Ciclo For is updated 
				//summing the ratio between the waiting time of the running process and the length of "tAttesa"
			}

		}
		// Print the process names
		for (int i=0; i<=3;i++) {             
			System.out.println(processo[i]);

		}
		// Print the service times
		for (int p=0; p<=3;p++) {
			System.out.println(tServizio[p]);

		}
		// Print the waiting times
		for (int l=0; l<=3;l++) {
			System.out.println(tAttesa[l]); 

		}
		// Print the media 
		System.out.println("la media è : "+media);

	}
}
