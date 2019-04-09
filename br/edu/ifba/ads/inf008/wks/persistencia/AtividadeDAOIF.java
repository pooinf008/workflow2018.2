package br.edu.ifba.ads.inf008.wks.persistencia;

import java.util.Collection;

import br.edu.ifba.ads.inf008.wks.entidades.Atividade;

public interface AtividadeDAOIF {
	public void salvar(Atividade atividade) throws Exception;
	public Collection<Atividade> buscarTodos() throws Exception;
	  
}
