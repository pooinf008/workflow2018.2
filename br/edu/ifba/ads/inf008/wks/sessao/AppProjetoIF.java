package br.edu.ifba.ads.inf008.wks.sessao;

import java.util.Collection;

public interface AppProjetoIF {
    public void addAtividade(String id, String descricao, int duracao) throws Exception;
    public Collection<String> listarAtividades() throws Exception;    
}
