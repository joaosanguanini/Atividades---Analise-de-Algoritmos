
package livraria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteEntregaPAC {

    @Test
    public void testFreteAte1000g() {
        FretePAC frete = new FretePAC();
        assertEquals(10, frete.calcularFrete(800));
    }

    @Test
    public void testFreteAte2000g() {
        FretePAC frete = new FretePAC();
        assertEquals(15, frete.calcularFrete(1500));
    }
}