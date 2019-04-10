package br.edu.ifba.ads.inf008.events;

public class AppEvent {

	
	public static void main(String[] args) throws InterruptedException{
		(new AppEvent()).run();
	}

	private void run() throws InterruptedException {
		Subject subject = new Subject();
		ObserverPolitica op1 = new ObserverPolitica(1);
		ObserverPolitica op2 = new ObserverPolitica(2);
		ObserverEsporte oe1 = new ObserverEsporte(1);
		ObserverEsporte oe2 = new ObserverEsporte(2);
		ObserverEsporte oe3 = new ObserverEsporte(3);
		ObserverTudo ot = new ObserverTudo(100);
		subject.assinaEsporte(oe1);
		subject.assinaEsporte(oe2);
		subject.assinaEsporte(oe3);
		subject.assinaEsporte(ot);
		subject.assinaPolitica(op1);
		subject.assinaPolitica(op2);
		subject.assinaPolitica(ot);
		
		subject.run();
	}
	
	
}
