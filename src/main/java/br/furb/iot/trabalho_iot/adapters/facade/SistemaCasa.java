package br.furb.iot.trabalho_iot.adapters.facade;

import java.util.List;

import br.furb.iot.trabalho_iot.adapters.interfaces.ArCondicionado;
import br.furb.iot.trabalho_iot.adapters.interfaces.Lampada;
import br.furb.iot.trabalho_iot.adapters.interfaces.Persiana;

public class SistemaCasa {
    private List<Lampada> lampadas;
    private List<Persiana> persianas;
    private List<ArCondicionado> ares;

    public SistemaCasa(List<Lampada> lampadas, List<Persiana> persianas, List<ArCondicionado> ares) {
        this.lampadas = lampadas;
        this.persianas = persianas;
        this.ares = ares;
    }

    public void modoSono() {
        lampadas.forEach(Lampada::desligar);
        persianas.forEach(Persiana::fechar);
        ares.forEach(ArCondicionado::desligar);
    }

    public void modoTrabalho() {
        lampadas.forEach(Lampada::ligar);
        persianas.forEach(Persiana::abrir);

        for (ArCondicionado ar : ares) {
            ar.ligar();
            ar.definirTemperatura(25);
        }
    }
}