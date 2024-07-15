package model.corso;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
import java.sql.*;
import java.util.*;
import java.time.*;

public class CorsoDAO implements DAOInterface<CorsoBean, Integer> {
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
	public CorsoBean doRetreiveByKey(Integer code) throws SQLException {
		CorsoBean corso = new CorsoBean();
		String query = "INSERT INTO " + TABLE_NAME + "(nomeCorso, descrizione), VALUES (Corso1, Descrizione corso 1, Corso2, Descrizione corso 2"
				+ "Corso 3, Descrizione Corso 3)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "nomeCorso");
			preparedStatement.setString(2, "descrizione");
			preparedStatement.executeQuery();
		}
		return corso;
	}

	@Override
	public Collection<CorsoBean> doRetriveAll(String order) throws SQLException {
		Collection<CorsoBean> corsi = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME;
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.executeQuery();
		}
		
		return corsi;
	}

	@Override
	public void doSave(CorsoBean product) throws SQLException {
		
	}

	@Override
	public void doUpdate(CorsoBean product) throws SQLException {
		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
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
}
