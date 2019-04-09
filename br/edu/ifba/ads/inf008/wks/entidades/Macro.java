package br.edu.ifba.ads.inf008.wks.entidades;

import br.edu.ifba.ads.inf008.wks.sessao.CalculadoraDuracao;

public class Macro extends Atividade{
    private Atividade[] atividades;
    
    
    public Macro(String id, String descricao){
        super(id, descricao);
        this.atividades = new Atividade[0];
    }    
    
    public boolean isConcluida(){
        for(Atividade atividade : this.atividades)
          if(!atividade.isConcluida())
            return false;
        return true;    
    };
    
    public void addAtividade(Atividade atividade){
        this.atividades = this.addAtividade(atividade, this.atividades);
    } 
    
    public int getDuracao(){
      //  CalculadoraDuracao cd = new CalculadoraDuracao(this.atividades);
      //  return cd.getDuracao();
    	return 0;
    };     
   
    
}
