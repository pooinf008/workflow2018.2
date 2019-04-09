package br.edu.ifba.ads.inf008.wks.entidades;

import java.io.Serializable;

import br.edu.ifba.ads.inf008.wks.sessao.Duravel;

public abstract class Atividade implements Duravel, Serializable{
    private String id;
    private String descricao;
    private Atividade[] pre;
    private Atividade[] pos;
    
    public Atividade(String id, String descricao){
        this.setId(id);
        this.setDescricao(descricao);
        this.pre = new Atividade[0];
        this.pos = new Atividade[0];
    }   
    
    public Duravel[] getPreReqs(){
        return this.pre;
    };
    
    public Duravel[] getPosReqs(){
        return this.pos;
    };
    
    public void addPre(Atividade atividade){
        this.pre = this.addAtividade(atividade, this.pre);
    };    

    public void addPos(Atividade atividade){
        this.pos = this.addAtividade(atividade, this.pos);
    };  
    
    protected Atividade[] addAtividade(Atividade atividade, Atividade[] atividades){
        Atividade[] novo = new Atividade[atividades.length + 1];
        for(int i = 0; i < atividades.length; i++)
          novo[i] = atividades[i];
        novo[novo.length - 1] = atividade;
        return novo;
    };    
 
    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    private void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public abstract int getDuracao();
    
    public abstract boolean isConcluida();
    
    public boolean isInicio(){
        return (this.pre.length == 0); 
    };    

    public boolean isFinal(){
        return (this.pos.length == 0); 
    };   
    
    
    public String toString(){
        return this.getId() + "-" + this.getDescricao() + "[" + this.getDuracao() + " u.t.]";
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	} 
    
    
    
    
}
