package datamining;

public class Associacao {

	private int qtdX;
	private int qtdXeY;
	private Double suporte;
	private Double confianca;
	
	public Associacao(int qtdX, int qtdXeY, double suporte) {
		this.qtdX = qtdX;
		this.qtdXeY = qtdXeY;
		this.suporte = suporte;
		this.confianca = null;
	}

	public int getQtdX() {
		return qtdX;
	}

	public int getQtdXeY() {
		return qtdXeY;
	}

	public Double getSuporte() {
		return suporte;
	}

	public Double getConfianca() {
		return confianca;
	}
	
	public void setConfianca(Double confianca) {
		this.confianca = confianca;
	}
}
