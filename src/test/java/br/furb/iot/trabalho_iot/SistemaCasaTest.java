package br.furb.iot.trabalho_iot;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;

import br.furb.iot.trabalho_iot.adapters.ArGellaKazaAdapter;
import br.furb.iot.trabalho_iot.adapters.ArVentoBaumnAdapter;
import br.furb.iot.trabalho_iot.adapters.LampadaPhelippesAdapter;
import br.furb.iot.trabalho_iot.adapters.LampadaShoyouMiAdapter;
import br.furb.iot.trabalho_iot.adapters.PersianaNatLightAdapter;
import br.furb.iot.trabalho_iot.adapters.PersianaSolariusAdapter;
import br.furb.iot.trabalho_iot.adapters.facade.SistemaCasa;
import br.furb.iot.trabalho_iot.adapters.interfaces.ArCondicionado;
import br.furb.iot.trabalho_iot.adapters.interfaces.Lampada;
import br.furb.iot.trabalho_iot.adapters.interfaces.Persiana;

public class SistemaCasaTest {

    @Test
    public void deveExecutarModoSonoSemErro() {
        Lampada lampada = new LampadaShoyouMiAdapter(new ShoyouMi());
        Persiana persiana = new PersianaSolariusAdapter(new Solarius());
        ArCondicionado ar = new ArVentoBaumnAdapter(new VentoBaumn());

        SistemaCasa sistema = new SistemaCasa(
                List.of(lampada),
                List.of(persiana),
                List.of(ar)
        );

        sistema.modoSono();

        assertNotNull(sistema);
    }

    @Test
    public void deveExecutarModoTrabalhoSemErro() {
        Lampada lampada = new LampadaPhelippesAdapter(new Phelippes());
        Persiana persiana = new PersianaNatLightAdapter(new NatLight());
        ArCondicionado ar = new ArGellaKazaAdapter(new GellaKaza());

        SistemaCasa sistema = new SistemaCasa(
                List.of(lampada),
                List.of(persiana),
                List.of(ar)
        );

        sistema.modoTrabalho();

        assertNotNull(sistema);
    }
}