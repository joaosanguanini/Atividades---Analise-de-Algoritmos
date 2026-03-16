package livraria;

public class FretePAC implements CalculoFrete{
@Override
public double calcularFrete(double pesoTotal) {
	if (pesoTotal <= 1000)
	    return 10;
	if (pesoTotal <= 2000)
	    return 15;
	return 0;
	}
}
