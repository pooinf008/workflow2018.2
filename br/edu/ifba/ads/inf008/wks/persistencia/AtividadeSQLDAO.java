package br.edu.ifba.ads.inf008.wks.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.edu.ifba.ads.inf008.wks.entidades.Atividade;
import br.edu.ifba.ads.inf008.wks.entidades.Elementar;

public class AtividadeSQLDAO implements AtividadeDAOIF{
	
	private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
	private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String DB_USER = "SA";
	private static final String DB_PWD = "";
	private static final String SAVE = "INSERT INTO ELEMENTAR(id, descricao, duracao) VALUES(?, ?, ?)";
	private static final String FIND_ALL = "SELECT id, descricao, duracao FROM ELEMENTAR";	
	private static final String FIND_BY_ID = "SELECT descricao, duracao FROM ELEMENTAR WHERE id = ?";	
	
	
	
	public AtividadeSQLDAO() throws SQLException, ClassNotFoundException {
		Class.forName(AtividadeSQLDAO.DRIVER_NAME);
	}
	
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(AtividadeSQLDAO.DB_URI, 
				AtividadeSQLDAO.DB_USER, AtividadeSQLDAO.DB_PWD);
	}
	
	
	@Override
	public void save(Atividade atividade) throws Exception {
		PreparedStatement stmt = this.getConnection().prepareStatement(AtividadeSQLDAO.SAVE);
		stmt.setString(1, atividade.getId());
		stmt.setString(2, atividade.getDescricao());
		stmt.setInt(3, atividade.getDuracao());
		stmt.executeUpdate();
		stmt.close();
	}

	@Override
	public Collection<Atividade> findAll() throws Exception {
		Collection<Atividade> atividades = new ArrayList<Atividade>();
		PreparedStatement stmt = this
							    .getConnection()
								.prepareStatement(AtividadeSQLDAO.FIND_ALL);
		ResultSet rSet = stmt.executeQuery();
		while(rSet.next()) {
			Atividade atividade = new Elementar(rSet.getString("id"),
					rSet.getString("descricao"), 
					rSet.getInt("duracao"));
			atividades.add(atividade);
		}	
		rSet.close();
		stmt.close();
		return atividades;
	}

	@Override
	public Atividade findById(String id) throws Exception {
		Atividade atividade = null;
		PreparedStatement stmt = this
			    .getConnection()
				.prepareStatement(AtividadeSQLDAO.FIND_BY_ID);
		stmt.setString(1, id);
		ResultSet rSet = stmt.executeQuery();
		if(rSet.next())
			atividade = new Elementar(id,
					rSet.getString("descricao"), 
					rSet.getInt("duracao"));
		if(atividade == null)
			throw new Exception("Atividade Inexistente");
		return atividade;
	}

}
