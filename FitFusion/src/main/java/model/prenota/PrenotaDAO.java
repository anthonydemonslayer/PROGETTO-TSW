package model.prenota;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
import model.corso.CorsoBean;
import model.corso.CorsoDAO;
import model.lezione.LezioneBean;
import model.lezione.LezioneDAO;

import java.sql.*;
import java.util.*;
import java.time.*;

public class PrenotaDAO implements DAOInterface<PrenotaBean, Integer> {
	
	private static final String TABLE_NAME = "Prenota";
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
	public PrenotaBean doRetreiveByKey(Integer id) throws SQLException {
		return null;
	}

	public Collection<LezioneBean> doRetrieveAllByUserId(Integer idUtente) throws SQLException {
		Collection<LezioneBean> listaLezioni = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE idUtente = ?";
		LezioneDAO lezioneDAO = new LezioneDAO();

		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, idUtente);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				LezioneBean lezione = lezioneDAO.doRetreiveByKey(resultSet.getInt("idLezione"));
				listaLezioni.add(lezione);
			}
			return listaLezioni;
		}
	}

	
	@Override
	public Collection<PrenotaBean> doRetriveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(PrenotaBean product) throws SQLException {
		String query = "INSERT INTO " + TABLE_NAME + " (idLezione, idUtente) "
				+ "VALUES (?, ?)";

		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {

			setPrenotaStatement(product, preparedStatement);
			preparedStatement.executeUpdate();
		}
	}

	@Override
	public void doUpdate(PrenotaBean prenotazione) throws SQLException {
		String query = "UPDATE " + TABLE_NAME + "SET idLezione = ?, idUtente = ? ";
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, prenotazione.getIdLezione());
			preparedStatement.setInt(2, prenotazione.getIdUtente());
			preparedStatement.executeUpdate();
		}		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void setPrenota(ResultSet resultSet, PrenotaBean prenota) throws SQLException {
		prenota.setIdLezione(resultSet.getInt("idLezione"));
		prenota.setIdUtente(resultSet.getInt("idUtente"));
	}
	
	public void setPrenotaStatement(PrenotaBean prenota, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, prenota.getIdLezione());
		preparedStatement.setInt(2, prenota.getIdUtente());
	}
}
