package livraria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteEntregaSEDEX {

    @Test
    public void testFreteAte500g() {
        FreteSedex frete = new FreteSedex();
        assertEquals(12.5, frete.calcularFrete(400));
    }

    @Test
    public void testFreteAte1000g() {
        FreteSedex frete = new FreteSedex();
        assertEquals(20, frete.calcularFrete(800));
    }

    @Test
    public void testFreteAcima1000g() {
        FreteSedex frete = new FreteSedex();
        double valor = frete.calcularFrete(1200);
        assertTrue(valor > 20);
    }
}