package model.abbonamento;

import exception.GenericError;
import model.DAOInterface;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class AbbonamentoDAO implements DAOInterface<AbbonamentoBean, Integer> {
	
	private static final String TABLE_NAME = "Abbonamento";
	private static final DataSource ds;
	
	//Connessione database
	static {
		try {
			Context init = new InitialContext();
			Context env = (Context) init.lookup("java:comp/env");
			ds = (DataSource) env.lookup("jdbc/palestra");
		} catch (NamingException e) {
			throw new GenericError();
		}
	}

	@Override
	public AbbonamentoBean doRetreiveByKey(Integer code) throws SQLException {
		AbbonamentoBean abbonamentoBean = new AbbonamentoBean();
		String query = "SELECT Abbonamento.* FROM " + TABLE_NAME + " NATURAL JOIN Utente WHERE Utente.nome = Utente1 AND Utnete.cognome = Cognome1";
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			setAbbonamento(resultSet, abbonamentoBean);
		}
		return abbonamentoBean;
	}

	@Override
	public Collection<AbbonamentoBean> doRetriveAll(String order) throws SQLException {
		Collection<AbbonamentoBean> abbonamenti = new ArrayList<>();
		
		
		
		
		return abbonamenti;
	}

	@Override
	public void doSave(AbbonamentoBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(AbbonamentoBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	
	private void setAbbonamento(ResultSet resultSet, AbbonamentoBean abbonamentoBean) throws SQLException {
		
	}
	
	private void setAbbonamentoStatement(AbbonamentoBean abbonamento, PreparedStatement preparedStatement) throws SQLException {
		
	}
}
