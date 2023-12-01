package datamining;

import java.io.Serializable;

public class Associacao implements Serializable{

	private int qtdOcorrenciasX;
	private int qtdOcorrenciasXeY;
	private Double suporte;
	private Double confianca;
	
	public Associacao(int qtdOcorrenciasX, int qtdOcorrenciasXeY, Double suporte) {
		this.qtdOcorrenciasX = qtdOcorrenciasX;
		this.qtdOcorrenciasXeY = qtdOcorrenciasXeY;
		this.suporte = suporte;
		this.calcularConfianca();
	}

	public int qtdOcorrenciasX() {
		return qtdOcorrenciasX;
	}

	public int qtdOcorrenciasXeY() {
		return qtdOcorrenciasXeY;
	}

	public Double getSuporte() {
		return suporte;
	}

	public Double getConfianca() {
		return confianca;
	}

	private void calcularConfianca() {
		this.confianca = ((double) qtdOcorrenciasXeY / (double) qtdOcorrenciasX) * 100;
	}
}
