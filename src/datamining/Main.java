package datamining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	
	public static void main(String[] args) {
		List<Transaction> transacoes = new ArrayList<Transaction>();
		populate(transacoes);
		
		MineracaoAssociacao algoritmo = new MineracaoAssociacao(transacoes, 0.2);
		algoritmo.mostrarSuportes();
		algoritmo.mostrarConfianca();
		System.out.println(algoritmo.salvarAssociacoes());
	}
	
	private static void populate(List<Transaction> transacoes) {
		Map<String, Boolean> alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", true);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", true);
		alimentos.put("MANTEIGA", true);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		Transaction t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", true);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", true);
		alimentos.put("PAO", true);
		alimentos.put("MANTEIGA", true);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", true);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", true);
		alimentos.put("MANTEIGA", true);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", true);
		alimentos.put("CAFE", true);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", true);
		alimentos.put("MANTEIGA", true);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", true);
		alimentos.put("PAO", false);
		alimentos.put("MANTEIGA", false);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", false);
		alimentos.put("MANTEIGA", true);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", true);
		alimentos.put("MANTEIGA", false);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", false);
		alimentos.put("MANTEIGA", false);
		alimentos.put("ARROZ", false);
		alimentos.put("FEIJAO", true);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", false);
		alimentos.put("MANTEIGA", false);
		alimentos.put("ARROZ", true);
		alimentos.put("FEIJAO", true);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<String, Boolean>();
		alimentos.put("LEITE", false);
		alimentos.put("CAFE", false);
		alimentos.put("CERVEJA", false);
		alimentos.put("PAO", false);
		alimentos.put("MANTEIGA", false);
		alimentos.put("ARROZ", true);
		alimentos.put("FEIJAO", false);
		t = new Transaction(alimentos);
		transacoes.add(t);
	}
}
