package br.edu.ifba.ads.inf008.events;

public class ObserverEsporte implements EsporteObserverIF{
	
	private int id;
	
	public ObserverEsporte(int id) {
		this.id = id;
	}

	@Override
	public void rolouEsporte(EventoEsporte ee) {
		System.out.println("[Observer Esporte] " + this.id + ": " + ee.getDescricao());
		
	}

}
