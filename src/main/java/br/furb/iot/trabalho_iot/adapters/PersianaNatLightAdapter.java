package br.furb.iot.trabalho_iot.adapters;

import br.furb.iot.trabalho_iot.adapters.interfaces.Persiana;

public class PersianaNatLightAdapter implements Persiana {
    private NatLight persiana;

    public PersianaNatLightAdapter(NatLight persiana) {
        this.persiana = persiana;
    }

    @Override
    public void abrir() {
        persiana.abrirPalhetas();
        persiana.subirPalhetas();
    }

    @Override
    public void fechar() {
        persiana.descerPalhetas();
        persiana.fecharPalhetas();
    }
}