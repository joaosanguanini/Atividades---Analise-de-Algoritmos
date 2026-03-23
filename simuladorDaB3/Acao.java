package simuladorDaB3;

import java.util.ArrayList;
import java.util.List;

public class Acao {
	private String nome;
	private double valor;
	private List<Ordem> ordens;
	private List<ObservadorAcao> observador;
	
	public Acao(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
		this.observador = new ArrayList<>();
		this.ordens = new ArrayList<>();
	}
	public double getValor() {
		return valor;
	}
	public String getNome() {
		return nome;
	}
	public void adicionarOrdem(Ordem ordem) {
		ordens.add(ordem);
		verificarMatch();
	}
	private void verificarMatch() {
		for(int i = 0; i < ordens.size(); i++) {
			for(int j = i + 1;j < ordens.size();j++) {
				Ordem o1 = ordens.get(i);
				Ordem o2 = ordens.get(j);
				
				if(o1.getTipo() != o2.getTipo() &&
						   o1.getValor() == o2.getValor() &&
						   o1.getAcao().equals(o2.getAcao())) {
					valor= o1.getValor();
					ordens.remove(j);
					ordens.remove(i);
					
					notificar();
					return;
				}
			}
		}
	}
	public void adicionarObservador(ObservadorAcao o) {
		observador.add(o);
	}
	public void removerObservador(ObservadorAcao o) {
		observador.remove(o);
	}
	private void notificar() {
		for(ObservadorAcao o : observador)
			o.atualizarValor(this);
	}
}
