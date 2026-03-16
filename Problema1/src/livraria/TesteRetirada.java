package livraria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class TesteRetirada {

    @Test
    public void testFreteRetirada() {
        FreteRetirada frete = new FreteRetirada();
        assertEquals(0, frete.calcularFrete(500));
    }
}