package br.edu.ifba.ads.inf008.wks.persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.edu.ifba.ads.inf008.wks.entidades.Atividade;

public class AtividadeMemoryDAO implements AtividadeDAOIF {

	private static final String CAMINHO_ARQUIVO = "C:\\Users\\Aluno\\ATIVIDADES.data";
	private Map<String, Atividade> atividades;
	
	
	public AtividadeMemoryDAO() throws ClassNotFoundException, IOException {
		this.readFile();
//		
	}
	
	
	private void readFile() throws IOException, ClassNotFoundException {
		FileInputStream file = null;
		ObjectInputStream ois = null;
		try {
			file = new FileInputStream(new File(CAMINHO_ARQUIVO));
			ois = new ObjectInputStream(file);
			this.atividades = (Map<String, Atividade>) ois.readObject();
			ois.close();
			file.close();
		}catch(FileNotFoundException ex){
			this.atividades = new HashMap<String, Atividade>();
		}	
	}
	

	private void writeFile() throws IOException, ClassNotFoundException {
		FileOutputStream file = new FileOutputStream(new File(CAMINHO_ARQUIVO));
		ObjectOutputStream oos = new ObjectOutputStream(file);
		oos.writeObject(this.atividades);
		oos.close();
		file.close();
	}	
	
	@Override
	public void salvar(Atividade atividade) throws Exception {
		this.atividades.put(atividade.getId(), atividade);
		this.writeFile();
	}

	@Override
	public Collection<Atividade> buscarTodos() throws Exception {
		return this.atividades.values();
	}

}
