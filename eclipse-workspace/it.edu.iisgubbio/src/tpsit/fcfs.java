package tpsit;
public class fcfs {

public static void main(String[] args ) {
	/**
	 *Takes a number and returns its square 
	 *@param x the value to square
	 *@return the square root of the given 
	 */
	
	
	
	
	
	String[] processo= new String[4];
	int []tArrivo=new int [4];
	int []tEsecuzione=new int [4];
	int []tServizio=new int [4];
	double []tAttesa=new double [4];
	double media=0;
	
	processo[0]="P0";  //process description: its value and name;
	processo[1]="P1";
	processo[2]="P2";
	processo[3]="P3";
	
	for (int x=0; x<4;x++) { //time to arrive;
		tArrivo[x]=x;
	}
	
	tEsecuzione[0]=5; //time to execution;
	tEsecuzione[1]=3;
	tEsecuzione[2]=8;
	tEsecuzione[3]=6;
	
	for(int k=0; k<4;k++) {  //calculation execution time, service time and waiting time;
		if(k==0) {
			tServizio[k]=0;
			tAttesa[k]=0;
		}else {
			tServizio[k]=tServizio[k-1]+tEsecuzione[k-1];
			tAttesa[k]=tServizio[k]-tArrivo[k];
			media=media+tAttesa[k]/tAttesa.length;
		}
		
	}
	
	for (int i=0; i<=3;i++) {              //dates stamping and calculation of media;
		System.out.println(processo[i]);

	}
	for (int p=0; p<=3;p++) {
		System.out.println(tServizio[p]);

	}
	for (int l=0; l<=3;l++) {
		System.out.println(tAttesa[l]); 

	}
	
	System.out.println("la media è : "+media);
	
	}
}
