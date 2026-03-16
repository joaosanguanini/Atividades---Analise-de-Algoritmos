package livraria;

public class FreteSedex implements CalculoFrete {
	@Override
	public double calcularFrete(double pesoTotal) {
		if(pesoTotal <= 500)
			return  12.5;
		if(pesoTotal >= 500 && pesoTotal <= 1000)
			return  20;
			double excedente = pesoTotal - 1000.00;
		 return 46.5 + (excedente / 100.0) * 1.5;
	}
}