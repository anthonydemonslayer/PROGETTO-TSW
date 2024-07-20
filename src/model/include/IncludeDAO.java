package model.include;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
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
	public IncludeBean doRetreiveByKey(Integer code) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<IncludeBean> doRetriveAll(String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void doSave(IncludeBean product) throws SQLException {
		// TODO Auto-generated method stub
		
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
