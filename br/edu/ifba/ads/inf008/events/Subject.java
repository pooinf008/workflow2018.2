package br.edu.ifba.ads.inf008.events;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject{
	
	private int politica = 0;
	private int esporte = 0;
	
	List<PoliticaObserverIF> observersPolitica = new ArrayList<PoliticaObserverIF>();
	List<EsporteObserverIF> observersEsporte = new ArrayList<EsporteObserverIF>();
	
	public void assinaEsporte(EsporteObserverIF eo) {
		this.observersEsporte.add(eo);
	}
	
	public void assinaPolitica(PoliticaObserverIF po) {
		this.observersPolitica.add(po);
	}
	
	private void gerarEvento() throws InterruptedException {
		Random random = new Random();
		if(random.nextBoolean())
			this.gerarEventoEsporte();
		else
			this.gerarEventoPolitica();
		Thread.sleep(random.nextInt(5000));
	}

	private void gerarEventoPolitica() {
		System.out.println("[SUBJECT] - Evento " + this.politica + " Politica");
		EventoPolitica ep = new EventoPolitica("Evento " + this.politica++ + " Politica");
		for(PoliticaObserverIF op : this.observersPolitica)
			op.rolouPolitica(ep);
		
	}

	private void gerarEventoEsporte() {
		System.out.println("[SUBJECT] - Evento " + this.esporte + " Esporte");
		EventoEsporte ee = new EventoEsporte("Evento " + this.esporte++  + " Esporte");
		for(EsporteObserverIF oe : this.observersEsporte)
			oe.rolouEsporte(ee);
		
	}
	
	public void run() throws InterruptedException {
		while(true) {
			this.gerarEvento();
		}
	}
	

}
