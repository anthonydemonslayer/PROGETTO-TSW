package model.include;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
import model.corso.CorsoBean;
import model.corso.CorsoDAO;
import model.lezione.LezioneBean;

import java.sql.*;
import java.util.*;

public class IncludeDAO implements DAOInterface<IncludeBean, Integer> {
	private static final String TABLE_NAME = "Include";
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
	public IncludeBean doRetreiveByKey(Integer idAb) throws SQLException {
		return null;
	}

	@Override
	public Collection<IncludeBean> doRetriveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Collection<CorsoBean> doRetrieveAllByAbbonamentoId(Integer id) throws SQLException {
		Collection<CorsoBean> listaCorsi = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE idAbbonamento = ?";
		CorsoDAO corsoDAO = new CorsoDAO();
		
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				CorsoBean corso = corsoDAO.doRetreiveByKey(resultSet.getString("nomeCorso"));
				
				listaCorsi.add(corso);
			}
			return listaCorsi;
		}

	}

	@Override
	public void doSave(IncludeBean corsoAbbonamento) throws SQLException {
		String query = "INSERT INTO " + TABLE_NAME + "(idAbbonamento, nomeCorso)" 
				+ "VALUES (?, ?)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, corsoAbbonamento.getIdAbbonamento());
			preparedStatement.setString(2, corsoAbbonamento.getNomeCorso());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public void doUpdate(IncludeBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void setInclude(ResultSet resultSet, IncludeBean includeBean) throws SQLException {
		includeBean.setIdAbbonamento(resultSet.getInt("id"));
		includeBean.setNomeCorso(resultSet.getString("nomeCorso"));
	}
	
	private void setIncludeStatement(IncludeBean includeBean, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, includeBean.getIdAbbonamento());
		preparedStatement.setString(2, includeBean.getNomeCorso());
	}
}
