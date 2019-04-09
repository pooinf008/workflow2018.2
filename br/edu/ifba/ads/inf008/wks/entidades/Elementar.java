package br.edu.ifba.ads.inf008.wks.entidades;

public class Elementar extends Atividade{
    private int tempo;
    private boolean concluida;
    private Pessoa responsavel;
    
    public Elementar(String id, String descricao, int duracao){
        super(id, descricao);
        this.concluida = false;
        this.tempo = duracao; 
    };
    
    public void concluir(){
         this.concluida = true;
    }    
    
    public void setResponsavel(Pessoa responsavel){
        this.responsavel = responsavel;
    }    
    
    public boolean isConcluida(){
        return this.concluida;
    };
    
    public int getDuracao(){
        return this.tempo;
    };    
    
    
}
