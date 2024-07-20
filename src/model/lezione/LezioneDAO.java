package model.lezione;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.time.*;

public class LezioneDAO implements DAOInterface<LezioneBean, Integer> {
	
	private static final String TABLE_NAME = "Lezione";
	private static final DataSource ds;
	private static final List<String> LEZIONI = new ArrayList<>(Arrays.asList("corso", "dataCorso"));
	
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
	public LezioneBean doRetreiveByKey(Integer code) throws SQLException {
		LezioneBean lezione = new LezioneBean();
		String query = "INSERT INTO " + TABLE_NAME + " (dataOra, costo, durata, idUtente, nomeCorso) " +
				"VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			setLezione(resultSet, lezione);
		}
		return lezione;
	}

	@Override
	public Collection<LezioneBean> doRetriveAll(String order) throws SQLException {
		Collection<LezioneBean> listaLezioni = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME + " NATURAL JOIN Utente WHERE Utente.nome = ? AND Utente.cognome = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "nomeUtente");
			preparedStatement.setString(2, "cognomeUtente");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				LezioneBean lezione = new LezioneBean();
				setLezione(resultSet, lezione);
				listaLezioni.add(lezione);
			}
			return listaLezioni;
		}
	}
	
	public Collection<LezioneBean> doRetrieveByDataECorso(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		Collection<LezioneBean> listaLezioniperDataECorso = new ArrayList<>();
		
		StringBuilder query = new StringBuilder("SELECT * FROM " + TABLE_NAME + " WHERE nomeCorso = ?");
		
		try {
			connection = ds.getConnection();
			for(String s: LEZIONI)
				if(s.equals(order))
					query.append(" ORDER BY data").append(s);
			
			preparedStatement = connection.prepareStatement(query.toString());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				LezioneBean lezione = new LezioneBean();
				setLezione(resultSet, lezione);
				listaLezioniperDataECorso.add(lezione);
			}
				
		} finally {
				if(preparedStatement != null)
					preparedStatement.close();
				if(connection != null)
					connection.close();
			}
		return listaLezioniperDataECorso;
		}
		

	@Override
	public void doSave(LezioneBean product) throws SQLException {
		
	}

	@Override
	public void doUpdate(LezioneBean lezione) throws SQLException {
		String query = "UPDATE " + TABLE_NAME + " SET dataOra = cast (? as datetime) WHERE idLezione = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, lezione.getIdLezione());
			preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
			preparedStatement.executeUpdate();
		}
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void setLezione(ResultSet resultSet, LezioneBean lezione) throws SQLException {
		lezione.setCosto(resultSet.getFloat("costo"));
		lezione.setDataOra(resultSet.getDate("dataOra").toLocalDate());
		lezione.setDurata(resultSet.getInt("durata"));
		lezione.setIdLezione(resultSet.getInt("idLezione"));
		lezione.setIdUtente(resultSet.getInt("idUtente"));
		lezione.setNomeCorso(resultSet.getString("nomeCorso"));
		lezione.setNumIscritti(resultSet.getInt("numIscritti"));
	}
	
	private void setLezioneStatement(LezioneBean lezione, PreparedStatement preparedStatement) 
			throws SQLException {
		preparedStatement.setFloat(1, lezione.getCosto());
		preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
		preparedStatement.setInt(3, lezione.getDurata());
		preparedStatement.setInt(4, lezione.getIdLezione());
		preparedStatement.setInt(5, lezione.getIdUtente());
		preparedStatement.setString(5, lezione.getNomeCorso());
		preparedStatement.setInt(6, lezione.getNumIscritti());
	}

}
