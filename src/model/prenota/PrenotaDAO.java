package model.prenota;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
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
	public PrenotaBean doRetreiveByKey(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<PrenotaBean> doRetriveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(PrenotaBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(PrenotaBean product) throws SQLException {
		// TODO Auto-generated method stub
		
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
