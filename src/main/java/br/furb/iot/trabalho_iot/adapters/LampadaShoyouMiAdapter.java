package br.furb.iot.trabalho_iot.adapters;

import br.furb.iot.trabalho_iot.adapters.interfaces.Lampada;

public class LampadaShoyouMiAdapter implements Lampada {
    private ShoyouMi lampada;

    public LampadaShoyouMiAdapter(ShoyouMi lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        // Assumindo que ShoyouMi tem um método setIntensidade
        lampada.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampada.setIntensidade(0);
    }
}