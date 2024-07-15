package model.abbonamento;

import exception.GenericError;

import model.DAOInterface;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.time.*;

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
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE nomeUtente = ? AND cognome = ?";
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "nomeUtente");
			preparedStatement.setString(2, "cognome");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				AbbonamentoBean abbonamentoBean = new AbbonamentoBean();
				setAbbonamento(resultSet, abbonamentoBean);
				abbonamenti.add(abbonamentoBean);
			}
		}
		return abbonamenti;
	}

	@Override
	public void doSave(AbbonamentoBean abbonamentoBean) throws SQLException {
		String query = "INSERT INTO " + TABLE_NAME + " (costo, dataAcquisto, durata, maxAccessiSettimanali, idUtente) " 
				+ "VALUES (?, ?, ?, ?, ?)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setAbbonamentoStatement(abbonamentoBean, preparedStatement);
			preparedStatement.executeUpdate();
		}
	}
	
	

	@Override
	public void doUpdate(AbbonamentoBean product) throws SQLException {
		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		
		return false;
	}

	
	private void setAbbonamento(ResultSet resultSet, AbbonamentoBean abbonamentoBean) throws SQLException {
		abbonamentoBean.setCosto(resultSet.getFloat("costo"));
		abbonamentoBean.setDataAcquisto(resultSet.getDate("dataAcquisto").toLocalDate());
		abbonamentoBean.setDurata(resultSet.getInt("durata"));
		abbonamentoBean.setIdAbbonamento(resultSet.getInt("idAbbonamento"));
		abbonamentoBean.setIdUtente(resultSet.getInt("idUtente"));
		abbonamentoBean.setMaxAccessiSettimanali(resultSet.getInt("maxAccessiSettimanali"));
	}
	
	private void setAbbonamentoStatement(AbbonamentoBean abbonamento, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setFloat(1, abbonamento.getCosto());
		preparedStatement.setDate(2, Date.valueOf(LocalDate.now()));
		preparedStatement.setInt(3, abbonamento.getDurata());
		preparedStatement.setInt(4, abbonamento.getIdAbbonamento());
		preparedStatement.setInt(5, abbonamento.getIdUtente());
		preparedStatement.setInt(6, abbonamento.getMaxAccessiSettimanali());
	}
}
