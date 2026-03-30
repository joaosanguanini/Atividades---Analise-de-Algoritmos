package br.furb.iot.trabalho_iot.adapters;

import br.furb.iot.trabalho_iot.adapters.interfaces.ArCondicionado;

public class ArGellaKazaAdapter implements ArCondicionado {
    private GellaKaza ar;
    private int temperatura = 28;

    public ArGellaKazaAdapter(GellaKaza ar) {
        this.ar = ar;
    }

    @Override
    public void ligar() {
        ar.ativar();
        temperatura = 28;
    }

    @Override
    public void desligar() {
        ar.desativar();
    }

    @Override
    public void aumentarTemperatura() {
        ar.aumentarTemperatura();
        temperatura++;
    }

    @Override
    public void diminuirTemperatura() {
        ar.abaixarTemperatura();
        temperatura--;
    }

    @Override
    public void definirTemperatura(int temp) {
        while (temperatura < temp) {
			aumentarTemperatura();
		}
        while (temperatura > temp) {
			diminuirTemperatura();
		}
    }
}