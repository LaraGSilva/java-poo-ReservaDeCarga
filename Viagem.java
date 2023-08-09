package br.fiap.viagem;

import br.fiap.carga.Carga;

public class Viagem {
	private int capacidade;
	private int index;
	private Carga[] carga;
	
	public Viagem() {
		this.capacidade = 10000;
		this.index = 0;
		this.carga = new Carga[20];
	}
	
	// método para reservar uma carga no navio
	public boolean reservar(Carga carga) {
		if(permitidoReservar(carga.getPeso())) {
			this.carga[index] = carga;
			index++;
			return true;
		}
		return false;
	}
	
	// método para retornar a capacidade reservada
	public double capacidadeReservada() {
		double total = 0;
		for(int i = 0; i < index; i++) {
			total += carga[i].getPeso();
		}
		return total;
	}
	
	// método para verificar se é permitido fazer a reserva
	public boolean permitidoReservar(double peso) {
		if(index < carga.length && capacidadeReservada() + peso <= capacidade) {
			return true;
		}
		return false;
	}
	
	// método para retornar os dados de todas as cargas reservadas
	public String getDados() {
		String aux = "";
		for(int i = 0; i < index; i++) {
			aux += carga[i].getDados() + "\n";
		}
		return aux;
	}
	
	// método para retornar os dados de uma carga específica
	public String getDados(int indice) {
		return carga[indice].getDados();
	}
	
	// método para pesquisar uma carga pelo CNPJ
	public int pesquisar(int cnpj) {
		int aux = -1;
		for(int i = 0; i < index; i++) {
			if(carga[i].getCliente().getCnpj() == cnpj) {
				aux = i;
				break;
			}
		}
		return aux;
	}
	
	// método para cancelar (remover) uma carga reservada
	public void cancelar(int indice) {
		carga[indice] = carga[index - 1];
		index--;
	}
}
