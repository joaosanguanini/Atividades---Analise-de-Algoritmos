package br.furb.iot.trabalho_iot.adapters.interfaces;

public interface ArCondicionado {
	void ligar();

	void desligar();

	void aumentarTemperatura();

	void diminuirTemperatura();

	void definirTemperatura(int temp);
}
