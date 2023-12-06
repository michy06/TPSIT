package tpsit;

public class Operazioni {
	int n1,n2;
}
public Operazioni(int x ; int y) {
	int n1=x;
	int n2=y;
}
public int Somma () {
	return n1 + n2;

}
public int Prodotto () {
	return n1 * n2;
}
static void main (String[]args) {
	Operazioni op = new Operazioni(3,4);
	System.out.println(op.Somma());
	System.out.println(op.Prodotto());
}

}
