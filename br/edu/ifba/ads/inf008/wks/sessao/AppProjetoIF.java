package br.edu.ifba.ads.inf008.wks.sessao;

import java.util.Collection;

import br.edu.ifba.ads.inf008.wks.persistencia.AtividadeDAOIF;

public interface AppProjetoIF {
    public void addAtividade(String id, String descricao, int duracao) throws Exception;
    public Collection<String> listarAtividades() throws Exception;
	public int buscarDuracaoAtividade(String id) throws Exception;    
	
	
	public void setAtividadeDAOIF(AtividadeDAOIF atividadeDAO);
}
