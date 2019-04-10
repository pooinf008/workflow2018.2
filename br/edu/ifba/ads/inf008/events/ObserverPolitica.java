package br.edu.ifba.ads.inf008.events;

public class ObserverPolitica implements PoliticaObserverIF{
	
	private int id;
	
	public ObserverPolitica(int id) {
		this.id = id;
	}

	@Override
	public void rolouPolitica(EventoPolitica ep) {
		System.out.println("[Observer Politica] " + this.id + ": " + ep.getDescricao());
		
	}

}
