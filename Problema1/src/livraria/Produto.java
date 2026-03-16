package livraria;

public class Produto {
	
	private String nome;
	private double valor;
	private double peso;
	
	public Produto(String nome, double valor, double peso) {
	this.nome = nome;
	this.peso = peso;
	this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public double getPeso() {
		return peso;
	}
}
