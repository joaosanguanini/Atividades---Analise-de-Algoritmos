package br.furb.iot.trabalho_iot.adapters;

import br.furb.iot.trabalho_iot.adapters.interfaces.Lampada;

public class LampadaPhelippesAdapter implements Lampada {
    private Phelippes lampada;

    public LampadaPhelippesAdapter(Phelippes lampada) {
        this.lampada = lampada;
    }

    @Override
    public void ligar() {
        lampada.setIntensidade(100);
    }

    @Override
    public void desligar() {
        lampada.setIntensidade(0);
    }
}