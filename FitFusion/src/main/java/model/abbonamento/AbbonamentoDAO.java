package model.abbonamento;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import exception.GenericError;
import model.DAOInterface;
import model.lezione.LezioneBean;
import model.lezione.LezioneDAO;

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
	public AbbonamentoBean doRetreiveByKey(Integer idUtente) throws SQLException {
		AbbonamentoBean abbonamentoBean = new AbbonamentoBean();
		String query = "SELECT Abbonamento.* FROM " + TABLE_NAME + " NATURAL JOIN Utente WHERE idUtente = ?";
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, 
			    ResultSet.CONCUR_READ_ONLY)) {
			preparedStatement.setInt(1, idUtente);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.last()) {
				setAbbonamento(resultSet, abbonamentoBean);
				return abbonamentoBean;
			} else {
				return null;
			}
		}
	}

	@Override
	public Collection<AbbonamentoBean> doRetriveAll(String order) throws SQLException {
		Collection<AbbonamentoBean> abbonamenti = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME + "";
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				AbbonamentoBean abbonamentoBean = new AbbonamentoBean();
				setAbbonamento(resultSet, abbonamentoBean);
				abbonamenti.add(abbonamentoBean);
			}
			
			return abbonamenti;
		}
	}

	public Collection<AbbonamentoBean> doRetrieveAllByPeriodo(LocalDate da, LocalDate a) throws SQLException {
		Collection<AbbonamentoBean> listaAbbonamenti = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE dataAcquisto BETWEEN ? AND ?;";
		AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();

		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, da.format(DateTimeFormatter.ISO_DATE));
			preparedStatement.setString(2, a.format(DateTimeFormatter.ISO_DATE));

			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				AbbonamentoBean abbonamento = new AbbonamentoBean();
				setAbbonamento(resultSet, abbonamento);
				listaAbbonamenti.add(abbonamento);
			}
			return listaAbbonamenti;
		}
	}
	
	@Override
	public void doSave(AbbonamentoBean abbonamentoBean) throws SQLException {
		doSaveAndReturnId(abbonamentoBean);
	}
	
	public int doSaveAndReturnId(AbbonamentoBean abbonamentoBean) throws SQLException {
		String query = "INSERT INTO " + TABLE_NAME + " (costo, dataAcquisto, durata, maxAccessiSettimanali, idUtente) "
				+ "VALUES (?, ?, ?, ?, ?)";
		int generatedId = -1;

		try (Connection connection = ds.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query,
						Statement.RETURN_GENERATED_KEYS)) {

			setAbbonamentoStatement(abbonamentoBean, preparedStatement);
			int affectedRows = preparedStatement.executeUpdate();

			if (affectedRows > 0) {
				try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						generatedId = generatedKeys.getInt(1);
					}
				}
			}
			
			return generatedId;
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
		preparedStatement.setInt(4, abbonamento.getMaxAccessiSettimanali());
		preparedStatement.setInt(5, abbonamento.getIdUtente());
	}
}
