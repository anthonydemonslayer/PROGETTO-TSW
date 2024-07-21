package model.corso;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exception.GenericError;
import model.DAOInterface;

public class CorsoDAO implements DAOInterface<CorsoBean, String> {
	private static final String TABLE_NAME = "Corso";
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
	public CorsoBean doRetreiveByKey(String code) throws SQLException {
		CorsoBean corso = new CorsoBean();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE nomeCorso = ?";
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, code);
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.next()) {
				corso.setNomeCorso(result.getString("nomeCorso"));
				corso.setDescrizione(result.getString("descrizione"));
				return corso;
			}
		}
		return null;
	}

	@Override
	public Collection<CorsoBean> doRetriveAll(String order) throws SQLException {
		Collection<CorsoBean> corsi = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME;
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				CorsoBean corso = new CorsoBean();
				corso.setNomeCorso(resultSet.getString("nomeCorso"));
				corso.setDescrizione(resultSet.getString("descrizione"));
				corsi.add(corso);
			}
		}
		
		return corsi;
	}

	@Override
	public void doSave(CorsoBean corso) throws SQLException {
		String query = "INSERT INTO " + TABLE_NAME + "(descrizione, nomeCorso)" 
				+ "VALUES (?, ?)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setCorsoStatement(corso, preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void doUpdateAndRename(CorsoBean corso, String certoNomeCorso) throws SQLException {
	    String query = "UPDATE " + TABLE_NAME + " SET nomeCorso = ?, descrizione = ? WHERE nomeCorso = ?";
	    
	    try (Connection connection = ds.getConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        
	        preparedStatement.setString(1, corso.getNomeCorso());
	        preparedStatement.setString(2, corso.getDescrizione());
	        preparedStatement.setString(3, certoNomeCorso);
	        
	        int rowsAffected = preparedStatement.executeUpdate();
	        
	        if (rowsAffected == 0) {
	            throw new SQLException("Update failed, no rows affected.");
	        }
	    }
	}


	@Override
	public boolean doDelete(String code) throws SQLException {
		return false;
	}
	
	private void setCorso(ResultSet resultSet, CorsoBean corso) throws SQLException {
		corso.setDescrizione(resultSet.getString("descrizione"));
		corso.setNomeCorso(resultSet.getString("nomeCorso"));
	}

	private void setCorsoStatement(CorsoBean corso, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setString(1, corso.getDescrizione());
		preparedStatement.setString(2, corso.getNomeCorso());
	}

	@Override
	public void doUpdate(CorsoBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}
}
