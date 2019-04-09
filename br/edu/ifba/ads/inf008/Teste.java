package br.edu.ifba.ads.inf008;

import br.edu.ifba.ads.inf008.wks.entidades.Atividade;
import br.edu.ifba.ads.inf008.wks.entidades.Elementar;
import br.edu.ifba.ads.inf008.wks.sessao.AppProjeto;

public class Teste{
    
    private AppProjeto projeto;
    
    private String[] ids = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"}; 
    
    public Teste() throws Exception{
        this.make();
    }    
    
    private void make() throws Exception{
        this.projeto = new AppProjeto();
        this.projeto.addAtividade("A", "Atividade A", 3);
        this.projeto.addAtividade("B", "Atividade B", 5);
        this.projeto.addAtividade("C", "Atividade C", 2);
        this.projeto.addAtividade("D", "Atividade D", 1);
        this.projeto.addAtividade("E", "Atividade E", 6);
        this.projeto.addAtividade("F", "Atividade F", 1);
        this.projeto.addAtividade("H", "Atividade H", 4);
        this.projeto.addAtividade("I", "Atividade I", 2);
        this.projeto.addAtividade("J", "Atividade J", 20);
    }
    
    public void listarAtividade() throws Exception {
    	for(String s : this.projeto.listarAtividades())
    		System.out.println(s);
    }
    
    
/*    public void fazNada() {
        A.addPos(B);
        A.addPos(C);        
        B.addPos(D);        
        C.addPos(D);        
        D.addPos(E);                
        D.addPos(F);
        E.addPos(G);
        E.addPos(H);
        F.addPos(H);        
        F.addPos(J);
        G.addPos(I);                
        H.addPos(I);        
        
        B.addPre(A);
        C.addPre(A);
        D.addPre(B);
        D.addPre(C);
        E.addPre(D);
        F.addPre(D);
        G.addPre(E);
        H.addPre(E);
        H.addPre(F);
        I.addPre(G);
        I.addPre(H);
        J.addPre(F);
        
        projeto.addAtividade(A);
        projeto.addAtividade(B);
        projeto.addAtividade(C);
        projeto.addAtividade(D);
        projeto.addAtividade(E);
        projeto.addAtividade(F);
        projeto.addAtividade(G);
        projeto.addAtividade(H);
        projeto.addAtividade(I);
        projeto.addAtividade(J);        
    	
    }
*/    
    
    
    public void run(){
//          System.out.println("Tempo do Projeto: " + this.projeto.getDuracao());          
           
    }    
    
    
    public static void main(String[] args) throws Exception{
        (new Teste()).listarAtividade();
    }    
    
    
    

}



