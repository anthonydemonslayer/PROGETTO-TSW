package model.lezione;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
import java.sql.*;
import java.util.*;
import java.time.*;

public class LezioneDAO implements DAOInterface<LezioneBean, Integer> {
	
	private static final String TABLE_NAME = "Lezione";
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
	public LezioneBean doRetreiveByKey(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<LezioneBean> doRetriveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(LezioneBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doUpdate(LezioneBean product) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
