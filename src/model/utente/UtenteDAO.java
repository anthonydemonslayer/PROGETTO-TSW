package model.utente;

import model.DAOInterface;

import javax.naming.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class UtenteDAO implements DAOInterface<UtenteBean, String> {
	
	private static final String TABLE_NAME = "Utente";
	private static final DataSource ds;
	
	//Connessione database
		static {
			try {
				Context init = new InitialContext();
				Context env = (Context) init.lookup("java:comp/env");
				ds = (DataSource) env.lookup("jdbc/palestra");
			} catch (NamingException e) {
				throw new RuntimeException();
			}
		}

		@Override
		public UtenteBean doRetreiveByKey(String code) throws SQLException {
			UtenteBean utenteBean = new UtenteBean();
			String query = "SELECT * FROM " + TABLE_NAME + " WHERE nomeUtente = ?";
			return getUtenteBean(code, utenteBean, query);
		}

		@Override
		public Collection<UtenteBean> doRetriveAll(String order) throws SQLException {
			Collection<UtenteBean> utenti = new ArrayList<>();
			String query = "SELECT * FROM " + TABLE_NAME;
			try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while(resultSet.next()) {
					UtenteBean utenteBean = new UtenteBean();
					setUtente(resultSet, utenteBean);
					utenti.add(utenteBean);
				}
			}
			return utenti;
		}

		@Override
		public synchronized void doSave(UtenteBean utenteBean) throws SQLException {
			String query = "INSERT INTO " + TABLE_NAME + "(idUtente, cognome, nomeUtente, password, telefono, tipoUtente)" 
					+ "VALUES (?, ?, ?, ?, ? ?)";
			try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				setUtenteStatement(utenteBean, preparedStatement);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		@Override
		public synchronized void doUpdate(UtenteBean utenteBean) throws SQLException {
			String query = "UPDATE " + TABLE_NAME + " SET idUtente = ?, "
					+ "nome = ?, cognome = ?, telefono = ?, password = ?, tipoUtente = ? WHERE nomeUtente = ?";
			try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setInt(1, utenteBean.getIdUtente());
				preparedStatement.setString(2, utenteBean.getCognome());
				preparedStatement.setString(3, utenteBean.getNomeUtente());
				preparedStatement.setString(4, utenteBean.getPassword());
				preparedStatement.setString(5, utenteBean.getTelefono());
				preparedStatement.executeUpdate();
			}
		}

		@Override
		public boolean doDelete(String code) throws SQLException {
			int result;
			String query = "DELETE FROM " + TABLE_NAME + "WHERE USERNAME = ?";
			try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, code);
				result = preparedStatement.executeUpdate();
			}
			
			return result != 0;
		}
		
		private UtenteBean getUtenteBean(String code, UtenteBean utenteBean, String query) throws SQLException {
			try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
				preparedStatement.setString(1, code);
				ResultSet resultSet = preparedStatement.executeQuery();
				
				
				if(!resultSet.isBeforeFirst())
					return null;
					
				resultSet.next();
				setUtente(resultSet, utenteBean);
			}
			return utenteBean;
		}
	
		private void setUtente(ResultSet resultSet, UtenteBean utenteBean) throws SQLException {
			utenteBean.setIdUtente(resultSet.getInt(1));
			utenteBean.setCognome(resultSet.getString("cognome"));
			utenteBean.setNomeUtente(resultSet.getString("momeUtente"));
			utenteBean.setPassword(resultSet.getString("password"));
			utenteBean.setTelefono(resultSet.getString("telefono"));
			utenteBean.setTipoUtente(null);
		}
		
		private void setUtenteStatement(UtenteBean utenteBean, PreparedStatement preparedStatement) throws SQLException {
			preparedStatement.setInt(1, utenteBean.getIdUtente());
			preparedStatement.setString(2, utenteBean.getCognome());
			preparedStatement.setString(3, utenteBean.getNomeUtente());
			preparedStatement.setString(4, utenteBean.getPassword());
			preparedStatement.setString(5, utenteBean.getTelefono());
		}
}
