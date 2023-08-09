package br.fiap.util;

import static javax.swing.JOptionPane.*;

import br.fiap.carga.Carga;
import br.fiap.cliente.Cliente;
import br.fiap.viagem.Viagem;

import static java.lang.Integer.*;

public class Util {

	private Viagem viagem = new Viagem();

	public void menu() {
		int opcao;

		do {
			opcao = parseInt(showInputDialog(gerarMenu()));
			if (opcao < 1 || opcao > 6) {
				showMessageDialog(null, "Opção inválida");
			} else {
				switch (opcao) {
				case 1:
					reservar();
					break;
				case 2:
					pesquisar();
					break;
				case 3:
					visualizar();
					break;
				case 4:
					capacidade();
					break;
				case 5:
					cancelar();
					break;
				}
			}
		} while (opcao != 6);

	}

	private void capacidade() {
		showMessageDialog(null, viagem.capacidadeReservada());
		
	}

	private void cancelar() {
		int cnpj, indice;

		cnpj = parseInt(showInputDialog("CNPJ"));
		indice = viagem.pesquisar(cnpj);
		if (indice == -1) {
			showMessageDialog(null, "Cliente não encontrado");
		} else {
			viagem.cancelar(indice);
		}

	}

	private void pesquisar() {
		int cnpj, indice;

		cnpj = parseInt(showInputDialog("CNPJ"));
		indice = viagem.pesquisar(cnpj);
		if (indice == -1) {
			showMessageDialog(null, "Cliente não encontrado");
		} else {
			showMessageDialog(null, viagem.getDados(indice));
		}
	}

	private void visualizar() {
		showMessageDialog(null, viagem.getDados());

	}

	private void reservar() {
		String destino, nomeCliente;
		int cnpj;

		cnpj = parseInt(showInputDialog("CNPJ"));
		nomeCliente = showInputDialog("Cliente");
		destino = showInputDialog("Destino");

		Cliente cliente = new Cliente(cnpj, nomeCliente);
		Carga carga = new Carga(destino, cliente);

		if (viagem.reservar(carga)) {
			showMessageDialog(null, "Carga reservada com sucesso");
		} else {
			showMessageDialog(null, "Chame o administrador");
		}

	}

	private String gerarMenu() {
		String aux = "Sistema de Reserva\n";
		aux += "1. Realizar reserva\n";
		aux += "2. Pesquisar reserva\n";
		aux += "3. Visualizar reservas\n";
		aux += "4. Capacidade reservada\n";
		aux += "5. Cancelar reserva\n";
		aux += "6. Encerrar programa\n";
		return aux;
	}

}
