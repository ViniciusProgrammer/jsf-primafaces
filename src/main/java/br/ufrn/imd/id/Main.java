package br.ufrn.imd.id;

public class Main {
	public static void main(String[] args) {
		Pedidos pedidos = new Pedidos();
		
		RelatorioService relatorioService = new RelatorioService(pedidos);
		
		relatorioService.setPedidos(pedidos);
	}
}
