package br.edu.ifba.ads.inf008;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import br.edu.ifba.ads.inf008.wks.persistencia.AtividadeDAOIF;
import br.edu.ifba.ads.inf008.wks.persistencia.AtividadeSQLDAO;
import br.edu.ifba.ads.inf008.wks.sessao.AppProjeto;
import br.edu.ifba.ads.inf008.wks.sessao.AppProjetoIF;
import br.edu.ifba.ads.inf008.wks.ui.ConsoleProjeto;
import br.edu.ifba.ads.inf008.wks.ui.JWorkFlowFrame;
import br.edu.ifba.ads.inf008.wks.ui.WorkFlowUIIF;

public class WorkflowApp {
	
	private static final String UI = "UI.NAME";
	private static final String LOGIC = "LOGIC.NAME";
	private static final String DAO = "DAO.NAME";
	
	private String uiClassName;
	private String logicClassName;		
	private String daoClassName;
	
	public void load() throws IOException{
		FileInputStream fis = new FileInputStream("C:\\Users\\Aluno\\eclipse-workspace\\Workflow\\src\\conf.workflow");
		Properties prop = new Properties();
		prop.load(fis);
		this.uiClassName = prop.getProperty(WorkflowApp.UI);
		this.logicClassName = prop.getProperty(WorkflowApp.LOGIC);
		this.daoClassName = prop.getProperty(WorkflowApp.DAO);
	}
	
	public void run() throws Exception{
		this.load();
		AtividadeDAOIF atividadeDAO = (AtividadeDAOIF) Class.forName(this.daoClassName).newInstance();
		AppProjetoIF app = (AppProjetoIF) Class.forName(this.logicClassName).newInstance();
		app.setAtividadeDAOIF(atividadeDAO);
		WorkFlowUIIF ui = (WorkFlowUIIF) Class.forName(this.uiClassName).newInstance();
		ui.setLogica(app);
		ui.exibir();
	}
	
	public static void main(String[] args) throws Exception {
		(new WorkflowApp()).run();
	}

}
