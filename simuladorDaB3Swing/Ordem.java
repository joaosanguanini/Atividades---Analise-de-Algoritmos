package simuladorDaB3Swing;

public class Ordem {
	private Investidor investidor;
	private double valor;
	private TipoOrdem tipo;
	private Acao acao;
	
	public Ordem(Investidor investidor, double valor, TipoOrdem tipo, Acao acao) {
		this.investidor = investidor;
		this.valor = valor;
		this.tipo = tipo;
		this.acao = acao;
	}
	public Investidor getInvestidor() {
		return investidor;
	}
	public double getValor() {
		return valor;
	}
	public TipoOrdem getTipo() {
		return tipo;
	}
	public Acao getAcao(){
		return acao;
	}
}
