package br.edu.ifba.ads.inf008.wks.sessao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.edu.ifba.ads.inf008.wks.entidades.Atividade;
import br.edu.ifba.ads.inf008.wks.entidades.Elementar;
import br.edu.ifba.ads.inf008.wks.persistencia.AtividadeDAOIF;
import br.edu.ifba.ads.inf008.wks.persistencia.AtividadeMemoryDAO;
import br.edu.ifba.ads.inf008.wks.persistencia.AtividadeSQLDAO;

public class AppProjeto implements AppProjetoIF{
	
	private AtividadeDAOIF atividadeDAO;
	
	public AppProjeto() throws ClassNotFoundException, IOException, SQLException {
//		this.atividadeDAO = new AtividadeMemoryDAO();
		this.atividadeDAO = new AtividadeSQLDAO();
	}
    
   
    public void addAtividade(String id, String descricao, int duracao) throws Exception{
    	Atividade atividade = new Elementar(id, descricao, duracao);
    	this.atividadeDAO.salvar(atividade);
    };  
    
    
    public Collection<String> listarAtividades() throws Exception{
    	Collection<String> nomeAtividades = new ArrayList<String>();
    	Collection<Atividade> atividades = this.atividadeDAO.buscarTodos();
    	for(Atividade atividade : atividades)
    		nomeAtividades.add(atividade.getDescricao());
    	return nomeAtividades;
    }
    
/*    public int getDuracao(String id){
        return this.findById(id).getDuracao();
    };
    
    public int getDuracao(){
    	Collection<Atividade> atividades = this.atividadeDAO.buscarTodos();
        CalculadoraDuracao cd = new CalculadoraDuracao(atividades);
        return cd.getDuracao();
    }    
*/    

}
