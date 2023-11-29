package datamining;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MineracaoAssociacao {
	
	private List<Transaction> transacoes;
	private Map<String, Associacao> associacoes;
	private Double suporteMinimo;
	
	public MineracaoAssociacao(Double suporteMinimo) {
		this.transacoes = new ArrayList<Transaction>();
		this.associacoes = new LinkedHashMap<String, Associacao>();
		this.suporteMinimo = suporteMinimo;
		this.populate();
		this.calcularAssociacao();
	}
	
	public MineracaoAssociacao(List<Transaction> transacoes, Double suporteMinimo) {
		this.transacoes = transacoes;
		this.associacoes = new HashMap<String, Associacao>();
		this.suporteMinimo = suporteMinimo;
		this.calcularAssociacao();
	}
	
	public Map<String, Associacao> getAssociacoes(){
		return associacoes;
	}
	
	public void mostrarSuportes() {
		System.out.println("**********************\nSUPORTES: ");
		for (var registro : associacoes.entrySet()) {
		    System.out.println(registro.getKey() + " : " + registro.getValue().getSuporte() + "%");
		}
	}
	
	private void calcularAssociacao() {
		calcularSuporte();
		calcularConfianca();
	}
	
	private void calcularSuporte() {
		
		int totalRegistros = transacoes.size();
		
		for(NomeAlimento alimento1 : NomeAlimento.values()) {
			for(NomeAlimento alimento2 : NomeAlimento.values()) {
				int qtdOcorrenciasCombinada = 0;
				int qtdOcorrenciasAlimento1 = 0;
				
				if(alimento1 == alimento2) {
					continue;
				}
				for(Transaction t : transacoes) {
					Map<NomeAlimento, Boolean> alimentosComprados = t.getAlimentosComprados();
					if(alimentosComprados.get(alimento1)) {
						qtdOcorrenciasAlimento1++;
						if(alimentosComprados.get(alimento2)) {
							qtdOcorrenciasCombinada++;
						}
					}
				}
				double valorSuporte = (double) qtdOcorrenciasCombinada / (double) totalRegistros;
				associacoes.put(alimento1.toString() + " e " + alimento2.toString(), new Associacao(qtdOcorrenciasAlimento1, qtdOcorrenciasCombinada, valorSuporte * 100));
			}	
		}
		corteSuporte();
	}
	
	private void calcularConfianca() {
		
		for (var registro : associacoes.entrySet()) {
			double qtdX = (double) registro.getValue().getQtdX();
			double qtdXeY = (double) registro.getValue().getQtdXeY();
			double confiancaFinal = (qtdXeY / qtdX) * 100;
			
			registro.getValue().setConfianca(confiancaFinal);
		}
	}
	
	public void mostrarConfianca() {
		System.out.println("\n\n**********************\nCONFIANCA: ");
		for (var registro : associacoes.entrySet()) {
		    System.out.println(registro.getKey() + " : " + registro.getValue().getConfianca() + "%");
		}
	}
	
	private void corteSuporte() {
		List<String> registrosRemover = new ArrayList<String>();
		
		for (String key : associacoes.keySet()) {
			if(associacoes.get(key).getSuporte() < suporteMinimo) {
				registrosRemover.add(key);
			}
		}
		
		if(registrosRemover.size() != 0) {
			for(String key : registrosRemover) {
				associacoes.remove(key);
			}
		}
	}

	private void populate() {
		Map<NomeAlimento, Boolean> alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, true);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, true);
		alimentos.put(NomeAlimento.MANTEIGA, true);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		Transaction t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, true);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, true);
		alimentos.put(NomeAlimento.PAO, true);
		alimentos.put(NomeAlimento.MANTEIGA, true);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, true);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, true);
		alimentos.put(NomeAlimento.MANTEIGA, true);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, true);
		alimentos.put(NomeAlimento.CAFE, true);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, true);
		alimentos.put(NomeAlimento.MANTEIGA, true);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, true);
		alimentos.put(NomeAlimento.PAO, false);
		alimentos.put(NomeAlimento.MANTEIGA, false);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, false);
		alimentos.put(NomeAlimento.MANTEIGA, true);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, true);
		alimentos.put(NomeAlimento.MANTEIGA, false);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, false);
		alimentos.put(NomeAlimento.MANTEIGA, false);
		alimentos.put(NomeAlimento.ARROZ, false);
		alimentos.put(NomeAlimento.FEIJAO, true);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, false);
		alimentos.put(NomeAlimento.MANTEIGA, false);
		alimentos.put(NomeAlimento.ARROZ, true);
		alimentos.put(NomeAlimento.FEIJAO, true);
		t = new Transaction(alimentos);
		transacoes.add(t);
		
		alimentos = new HashMap<NomeAlimento, Boolean>();
		alimentos.put(NomeAlimento.LEITE, false);
		alimentos.put(NomeAlimento.CAFE, false);
		alimentos.put(NomeAlimento.CERVEJA, false);
		alimentos.put(NomeAlimento.PAO, false);
		alimentos.put(NomeAlimento.MANTEIGA, false);
		alimentos.put(NomeAlimento.ARROZ, true);
		alimentos.put(NomeAlimento.FEIJAO, false);
		t = new Transaction(alimentos);
		transacoes.add(t);
	}
}
