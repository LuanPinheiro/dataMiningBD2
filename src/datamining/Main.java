package datamining;

public class Main {
	
	public static void main(String[] args) {
		MineracaoAssociacao algoritmo = new MineracaoAssociacao(20.0);
		
		algoritmo.mostrarSuportes();
		algoritmo.mostrarConfianca();
	}
	
}
