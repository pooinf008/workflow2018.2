package br.edu.ifba.ads.inf008.wks.sessao;

import java.util.Collection;

public class CalculadoraDuracao{
    
    private Collection<Duravel> duraveis;
    
    public CalculadoraDuracao(Collection<Duravel> duraveis){
        this.duraveis = duraveis; 
    }  
    
    public int getDuracao(){
        return this.getDuracaoPrevia(this.getDuraveisTerminais());
    };     
    
    private int getDuracaoPrevia(Duravel[] pre){
        int duracao = 0;
        for(Duravel d : pre){ 
          int duracaoPrevia = this.getDuracaoPrevia(d.getPreReqs());  
          if(duracaoPrevia + d.getDuracao() > duracao)
            duracao = duracaoPrevia + d.getDuracao();
        }    
        return duracao;     
    }    
    
    
    private boolean isFinal(Duravel d){
        return (d.getPosReqs().length == 0); 
    };     
    
    
    private Duravel[] getDuraveisTerminais(){
        Duravel[] terminais = new Duravel[0];
        for(Duravel d : this.duraveis)
          if(this.isFinal(d))
            terminais = this.addDuravel(d, terminais);
        return terminais;
    }     
    
    private Duravel[] addDuravel(Duravel duravel, Duravel[] duraveis){
        Duravel[] novo = new Duravel[duraveis.length + 1];
        for(int i = 0; i < duraveis.length; i++)
          novo[i] = duraveis[i];
        novo[novo.length - 1] = duravel;
        return novo;
    };      
    
}
