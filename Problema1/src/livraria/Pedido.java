package livraria;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private List<Produto> produtos = new ArrayList<>();
	private Transportadora transportadora;
	private double pesoTotal;
	private CalculoFrete calculoFrete;
	
	public Pedido(Transportadora transportadora) {
	    this.transportadora = transportadora;

	    if (transportadora.getNome().equalsIgnoreCase("Sedex"))
	        calculoFrete = new FreteSedex();
	    if (transportadora.getNome().equalsIgnoreCase("PAC")) 
	        calculoFrete = new FretePAC();
	    if (transportadora.getNome().equalsIgnoreCase("Retirada")) 
	        calculoFrete = new FreteRetirada();
	}
	public void addProduto(Produto produto) {
		pesoTotal += produto.getPeso();
	    produtos.add(produto);
	}
	public double calcularFrete() {
		return calculoFrete.calcularFrete(pesoTotal);
	}
}
	
