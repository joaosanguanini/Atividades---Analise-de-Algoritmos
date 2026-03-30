package br.furb.iot.trabalho_iot.adapters;

import br.furb.iot.trabalho_iot.adapters.interfaces.Persiana;

public class PersianaSolariusAdapter implements Persiana {
    private Solarius persiana;

    public PersianaSolariusAdapter(Solarius persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.subirPersiana();
    }

    @Override
    public void fechar() {
        persiana.abaixarPersiana();
    }
}