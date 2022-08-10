package br.uninga.arboviroses.app;

import br.uninga.arboviroses.bd.Conexao;

public class App {
	public static void main(String[] args) {
		Conexao.getConnection();
		System.out.println(Conexao.status);
	}
}
