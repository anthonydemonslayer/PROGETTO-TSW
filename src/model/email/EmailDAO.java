package model.email;

import javax.naming.*;
import javax.sql.*;
import exception.GenericError;
import model.DAOInterface;
import java.sql.*;
import java.util.*;

public class EmailDAO implements DAOInterface<EmailBean, Integer> {
	private static final String TABLE_NAME = "Email";
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
	public EmailBean doRetreiveByKey(Integer code) throws SQLException {
		EmailBean email = new EmailBean();
		String query = "INSERT INTO " + TABLE_NAME + " (indirizzo, idUtente) VALUES (?, ?)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, "indirizzo");
			preparedStatement.setInt(2, email.getIdUtente());
			preparedStatement.executeQuery();
		}
		return email;
	}

	@Override
	public Collection<EmailBean> doRetriveAll(String order) throws SQLException {
		Collection<EmailBean> listaEmail = new ArrayList<>();
		String query = "SELECT * FROM " + TABLE_NAME;
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				EmailBean email = new EmailBean();
				setEmail(resultSet, email);
				listaEmail.add(email);
			}
		}
		return listaEmail;
	}

	@Override
	public void doSave(EmailBean product) throws SQLException {
		
	}

	@Override
	public void doUpdate(EmailBean product) throws SQLException {
		
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		return false;
	}

	private void setEmail(ResultSet resultSet, EmailBean email) throws SQLException {
		email.setIdUtente(resultSet.getInt("idUtente"));
		email.setIndirizzo(resultSet.getString("indirizzo"));
	}
	
	private void setEmailStatement(EmailBean email, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, email.getIdUtente());
		preparedStatement.setString(2, email.getIndirizzo());
	}
}
