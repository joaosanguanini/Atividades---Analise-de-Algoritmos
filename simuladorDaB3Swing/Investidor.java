package simuladorDaB3Swing;

import java.util.List;

public class Investidor implements ObservadorAcao {
	
	@Override
	public void atualizarValor(Acao acao) {
		System.out.println(nome + "a açao:" + acao.getNome() +"novo valor = " + acao.getValor());
	}
	private String nome;
	private List<Ordem> ordens;
	private List<Acao> acoes;
	
	public Investidor(String nome) {
		this.nome = nome;
	}
	public void registrarOrdem(Acao acao, Ordem ordem) {
		acao.adicionarOrdem(ordem);
	}
	public String getNome() {
		return nome;
	}
	public List<Ordem> getOrdens() {
		return ordens;
	}
	public void AdicionarOrdem(Ordem ordem) {
		ordens.add(ordem);
	}
	public void AdicionarAcao(Acao acao) {
		acoes.add(acao);
	}
	public List<Acao> getAcoes() {
		return acoes;
	}
	
}
