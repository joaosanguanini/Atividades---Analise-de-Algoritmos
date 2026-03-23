package simuladorDaB3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class Teste {

    @Test
    void deveRealizarMatch() {
        Acao acao = new Acao("BBAS3", 20.0);

        Investidor comprador = new Investidor("Joaquim");
        Investidor vendedor = new Investidor("Mariana");

        Ordem compra = new Ordem(comprador, 24.0, TipoOrdem.COMPRA, acao);
        Ordem venda = new Ordem(vendedor, 24.0, TipoOrdem.VENDA, acao);

        acao.adicionarOrdem(compra);
        acao.adicionarOrdem(venda);

        assertEquals(24.0, acao.getValor());
    }

    @Test
    void naoDeveRealizarMatchValoresDiferentes() {
        Acao acao = new Acao("BBAS3", 20.0);

        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        acao.adicionarOrdem(new Ordem(i1, 23.0, TipoOrdem.COMPRA, acao));
        acao.adicionarOrdem(new Ordem(i2, 24.0, TipoOrdem.VENDA, acao));

        assertEquals(20.0, acao.getValor()); // não mudou
    }

    @Test
    void deveRemoverOrdensAposMatch() {
        Acao acao = new Acao("BBAS3", 20.0);

        Investidor i1 = new Investidor("A");
        Investidor i2 = new Investidor("B");

        acao.adicionarOrdem(new Ordem(i1, 30.0, TipoOrdem.COMPRA, acao));
        acao.adicionarOrdem(new Ordem(i2, 30.0, TipoOrdem.VENDA, acao));

        // você não tem getter da lista, então teste indireto:
        acao.adicionarOrdem(new Ordem(i1, 40.0, TipoOrdem.COMPRA, acao));

        // se não removesse, teria conflito antes
        assertEquals(30.0, acao.getValor());
    }
}