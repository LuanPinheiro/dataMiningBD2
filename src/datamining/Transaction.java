package datamining;

import java.util.Map;

public class Transaction {

	private Map<String, Boolean> alimentosComprados;

	public Transaction(Map<String, Boolean> alimentosComprados) {
		this.alimentosComprados = alimentosComprados;
	}
	
	public Map<String, Boolean> getAlimentosComprados() {
		return alimentosComprados;
	}
	
}
