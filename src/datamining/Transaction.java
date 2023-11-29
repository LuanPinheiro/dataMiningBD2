package datamining;

import java.util.Map;

public class Transaction {

	private Map<NomeAlimento, Boolean> alimentosComprados;

	public Transaction(Map<NomeAlimento, Boolean> alimentosComprados) {
		this.alimentosComprados = alimentosComprados;
	}
	
	public Map<NomeAlimento, Boolean> getAlimentosComprados() {
		return alimentosComprados;
	}
	
}
