package br.edu.ifba.ads.inf008.events;

public class ObserverTudo implements EsporteObserverIF, PoliticaObserverIF{

	private int id;
	
	public ObserverTudo(int id) {
		this.id = id;
	}	
	
	@Override
	public void rolouPolitica(EventoPolitica ep) {
		System.out.println("[Observer Tudo] " + this.id + ": " + ep.getDescricao());
		
	}	
	
	@Override
	public void rolouEsporte(EventoEsporte ee) {
		System.out.println("[Observer Tudo] " + this.id + ": " + ee.getDescricao());
		
	}	

}
