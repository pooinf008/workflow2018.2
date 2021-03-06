package br.edu.ifba.ads.inf008.wks.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

import br.edu.ifba.ads.inf008.wks.sessao.AppProjeto;
import br.edu.ifba.ads.inf008.wks.sessao.AppProjetoIF;

public class ConsoleProjeto implements WorkFlowUIIF{
	
	private AppProjetoIF app;
	private BufferedReader br;
	
	public ConsoleProjeto() throws ClassNotFoundException, IOException, SQLException {
		this.br = new  BufferedReader(new
				InputStreamReader(System.in));
	}
	
	public void setLogica(AppProjetoIF appProjeto){
		this.app = appProjeto;
	};	
	
	public void exibir() throws Exception {
		int option;
		do {
			this.menu();
			option = Integer.parseInt(this.br.readLine());
			switch(option) {
				case 1 : this.addAtividade(); break;
				case 2 : this.printAtividades(); break;
				case 3 : this.buscarDuracaoAtividade(); break;
			}
		}while (option > 0);
	}
	
	private void buscarDuracaoAtividade() throws Exception {
		String id;
		int duracao;
		System.out.println("*******************");
		System.out.println("Informe Id da Atividade");
		id = this.br.readLine();
		duracao = this.app.buscarDuracaoAtividade(id);
		System.out.println("Dura��o da Atividade: " + duracao);
		
	}

	private void printAtividades() throws Exception {
		System.out.println("*******************");
		for(String s : this.app.listarAtividades())
			System.out.println(s);
	}

	private void addAtividade() throws Exception {
		String id;
		String descricao;
		int duracao;
		System.out.println("*******************");
		System.out.println("Informe Id da Atividade");
		id = this.br.readLine();
		System.out.println("Informe descricao da Atividade");
		descricao = this.br.readLine();
		System.out.println("Informe duracao da Atividade");
		duracao = Integer.parseInt(this.br.readLine());
		this.app.addAtividade(id, descricao, duracao);
	}

	private void menu() {
		System.out.println("*******************");
		System.out.println("1 - ADICIONAR ATIVIDADE");
		System.out.println("2 - LISTAR ATIVIDADES");
		System.out.println("3 - BUSCAR DURACAO DE ATIVIDADE");
		System.out.println("0 - SAIR");
	}
	
	public static void main(String[] args) throws Exception {
		(new ConsoleProjeto()).exibir();
	}

}
