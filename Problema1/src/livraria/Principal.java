package livraria;

public class Principal {

	public static void main(String[] args) {
		
		Produto produto = new Produto("rapido e devagar", 50, 2200);
		Transportadora Sedex = new Transportadora("PAC");
		Pedido pedido =  new Pedido(Sedex);
		pedido.addProduto(produto);

		System.out.println(pedido.calcularFrete());
	}
}
