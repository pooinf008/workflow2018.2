package br.edu.ifba.ads.inf008;

import br.edu.ifba.ads.inf008.wks.entidades.Elementar;
import br.edu.ifba.ads.inf008.wks.entidades.Macro;
import br.edu.ifba.ads.inf008.wks.sessao.AppProjeto;

public class Teste2{
    
    private AppProjeto projeto;
    
    private String[] ids = {"1", "2", "3", "4"}; 
    
    public Teste2(){
        this.make();
    }    
    
   private void make(){
	   /*        
        this.projeto = new AppProjeto("Avaliacao");
        
        Elementar A1 = new Elementar("1", "Atividade 1", 5);
        Elementar A21 = new Elementar("2.1", "Atividade 2.1", 3);
        Elementar A221 = new Elementar("2.2.1", "Atividade 2.2.1", 1);
        Elementar A222 = new Elementar("2.2.2", "Atividade 2.2.2", 1);        
        Elementar A23 = new Elementar("2.3", "Atividade 2.3", 3);        
        Elementar A3 = new Elementar("3", "Atividade 3", 2);        
        Elementar A41 = new Elementar("4.1", "Atividade 4.1", 1);        
        Elementar A42 = new Elementar("4.2", "Atividade 4.2", 2);        

        Macro A22 = new Macro("2.2", "Atividade 2.2");
        A221.addPos(A222);
        A222.addPre(A221);
        A22.addAtividade(A221);
        A22.addAtividade(A222);
        
        A21.addPos(A23);
        A22.addPos(A23);        
        A23.addPre(A21);        
        A23.addPre(A22);        
        
        Macro A2 = new Macro("2", "Atividade 2");
        A2.addAtividade(A21);
        A2.addAtividade(A22);
        A2.addAtividade(A23);
        
        A41.addPos(A42);
        A42.addPre(A41);        
        Macro A4 = new Macro("4", "Atividade 4");
        A4.addAtividade(A41);
        A4.addAtividade(A42);
        
        A1.addPos(A3);
        A2.addPos(A3);
        A2.addPos(A4);
        A3.addPre(A1);
        A3.addPre(A2);
        A4.addPre(A2);
        
        this.projeto.addAtividade(A1);
        this.projeto.addAtividade(A2);        
        this.projeto.addAtividade(A3);
        this.projeto.addAtividade(A4);        
        
   */     
    } 
    

    
    public void run(){
        
//          System.out.println("Tempo do Projeto: " + this.projeto.getDuracao());
           
    }    
    
    
    public static void main(String[] args){
        (new Teste2()).run();
    }    
    
    
    

}



