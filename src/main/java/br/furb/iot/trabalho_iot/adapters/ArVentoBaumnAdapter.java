package br.furb.iot.trabalho_iot.adapters;

import br.furb.iot.trabalho_iot.adapters.interfaces.ArCondicionado;

public class ArVentoBaumnAdapter implements ArCondicionado {
    private VentoBaumn ar;
    private int temperatura = 25; // valor padrão

    public ArVentoBaumnAdapter(VentoBaumn ar) {
        this.ar = ar;
    }

    @Override
    public void ligar() {
        ar.ligar();
        // assume temperatura inicial (definir para 25)
        ar.definirTemperatura(25);
        temperatura = 25;
    }

    @Override
    public void desligar() {
        ar.desligar();
    }

    @Override
    public void aumentarTemperatura() {
        if (temperatura < 30) { // limite máximo arbitrário
            temperatura++;
            ar.definirTemperatura(temperatura);
        }
    }

    @Override
    public void diminuirTemperatura() {
        if (temperatura > 16) { // limite mínimo arbitrário
            temperatura--;
            ar.definirTemperatura(temperatura);
        }
    }

    @Override
    public void definirTemperatura(int temp) {
        temperatura = temp;
        ar.definirTemperatura(temp);
    }
}