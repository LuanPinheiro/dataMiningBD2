package datamining;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class MineracaoAssociacao {
	
	private List<Transaction> transacoes;
	private Map<String, Associacao> associacoes;
	private Double suporteMinimo;
	
	public MineracaoAssociacao(List<Transaction> transacoes, Double suporteMinimo) {
		this.transacoes = transacoes;
		this.associacoes = new LinkedHashMap<String, Associacao>();
		this.suporteMinimo = suporteMinimo;
		this.calcularAssociacao();
	}
	
	public Map<String, Associacao> getAssociacoes(){
		return associacoes;
	}
	
	public void mostrarSuportes() {
		System.out.println("**********************\nSUPORTES: ");
		for (var associacao : associacoes.entrySet()) {
		    System.out.println(associacao.getKey() + " : " + associacao.getValue().getSuporte() + "%");
		}
	}
	
	public void mostrarConfianca() {
		System.out.println("\n\n**********************\nCONFIANCA: ");
		for (var associacao : associacoes.entrySet()) {
		    System.out.println(associacao.getKey() + " : " + associacao.getValue().getConfianca() + "%");
		}
	}
	
	private void calcularAssociacao() {
		
		int totalRegistros = transacoes.size();
		
		List<String> colunas = transacoes.stream()
				.map((t) -> t.getAlimentosComprados())
				.map((alimento) -> alimento.keySet())
				.distinct()
				.toList()
				.get(0)
				.stream()
				.toList();
		
		for(int i = 0; i < colunas.size(); i++) {
			for(int j = i+1; j < colunas.size(); j++) {
				int qtdOcorrenciasCombinada = 0;
				int qtdOcorrenciasAlimento1 = 0;
				int qtdOcorrenciasAlimento2 = 0;
				
				String alimento1 = colunas.get(i);
				String alimento2 = colunas.get(j);
				
				for(Transaction t : transacoes) {
					Map<String, Boolean> alimentosComprados = t.getAlimentosComprados();
					boolean occoreuAlimento1 = false;
					boolean ocorreuAlimento2 = false;
					
					if(alimentosComprados.get(alimento1)) {
						qtdOcorrenciasAlimento1++;
						occoreuAlimento1 = true;
					}
					if(alimentosComprados.get(alimento2)) {
						qtdOcorrenciasAlimento2++;
						ocorreuAlimento2 = true;
					}
					if(occoreuAlimento1 && ocorreuAlimento2) {
						qtdOcorrenciasCombinada++;
					}
				}
				double valorSuporte = (double) qtdOcorrenciasCombinada / (double) totalRegistros;
				if(valorSuporte >= suporteMinimo) {
					associacoes.put(alimento1.toString() + " e " + alimento2.toString(), new Associacao(qtdOcorrenciasAlimento1, qtdOcorrenciasCombinada, valorSuporte * 100));
					associacoes.put(alimento2.toString() + " e " + alimento1.toString(), new Associacao(qtdOcorrenciasAlimento2, qtdOcorrenciasCombinada, valorSuporte * 100));
				}
			}
		}
	}
	
	public String salvarAssociacoes() {
		System.out.println("\n\n**********************\n");
		FileOutputStream fos = null;
	    ObjectOutputStream out = null;
	    try {
	        fos = new FileOutputStream("associacoesJavaObject",false);
	        out = new ObjectOutputStream(fos);
	        out.writeObject(associacoes);
	        try(PrintWriter outTxt = new PrintWriter("associacoes.txt")  ){
	            outTxt.println("Teste");
	        }
	        out.close();
	        return "Associações salvas como objeto e como txt sucesso";
	    } catch (IOException ex) {
	    	return "Erro ao salvar associações";
	    }
	}
}
