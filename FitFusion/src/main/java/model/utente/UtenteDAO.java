package model.utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.DAOInterface;


public class UtenteDAO implements DAOInterface<UtenteBean, Integer> {
	
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

	public UtenteBean doRetreiveByEmail(String email) throws SQLException {
		UtenteBean utenteBean = new UtenteBean();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE indirizzo = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next())
				return null;
				
			setUtente(resultSet, utenteBean);
			return utenteBean;
		}
	}

	@Override
	public UtenteBean doRetreiveByKey(Integer id) throws SQLException {
		UtenteBean utenteBean = new UtenteBean();
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE idUtente = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next())
				return null;
				
			setUtente(resultSet, utenteBean);
			return utenteBean;
		}
	}
	
	public List<UtenteBean> doRetreiveAllByCognome(String cognome) throws SQLException {
		List<UtenteBean> utenti = new ArrayList<>();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE cognome = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, cognome);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				UtenteBean utenteBean = new UtenteBean();
				setUtente(resultSet, utenteBean);
				utenti.add(utenteBean);
			}
			return utenti;
		}
	}
	
	public List<UtenteBean> doRetreiveAllIstruttori() throws SQLException {
		List<UtenteBean> utenti = new ArrayList<>();
		
		String query = "SELECT * FROM " + TABLE_NAME + " WHERE tipoUtente = \"istruttore\"";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				UtenteBean utenteBean = new UtenteBean();
				setUtente(resultSet, utenteBean);
				utenti.add(utenteBean);
			}
			return utenti;
		}
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
		String query = "INSERT INTO " + TABLE_NAME + "(idUtente, cognome, nomeUtente, password, telefono, tipoUtente, indirizzo)" 
				+ "VALUES (?, ?, ?, ?, ?, ?, ?)";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			setUtenteStatement(utenteBean, preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public synchronized void doUpdate(UtenteBean utenteBean) throws SQLException {
		String query = "UPDATE " + TABLE_NAME + "SET nomeUtente = ?, "
				+ "cognome = ?, telefono = ?, password = ?, tipoUtente = ? WHERE indirizzo = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, utenteBean.getNomeUtente());
			preparedStatement.setString(2, utenteBean.getCognome());
			preparedStatement.setString(3, utenteBean.getTelefono());
			preparedStatement.setString(4, utenteBean.getPassword());
			preparedStatement.setString(5, utenteBean.getTipoUtente().toString());
			preparedStatement.setString(6, utenteBean.getIndirizzo());
			preparedStatement.executeUpdate();
		}
	}

	public boolean doDelete(String email) throws SQLException {
		int result;
		String query = "DELETE FROM " + TABLE_NAME + " WHERE indirizzo = ?";
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			result = preparedStatement.executeUpdate();
		}
		
		return result != 0;
	}
	
	private UtenteBean getUtenteBean(String email, UtenteBean utenteBean, String query) throws SQLException {
		try (Connection connection = ds.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
			preparedStatement.setString(1, email);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(!resultSet.next())
				return null;
				
			setUtente(resultSet, utenteBean);
			return utenteBean;
		}
	}
	
	private void setUtente(ResultSet resultSet, UtenteBean utenteBean) throws SQLException {
		utenteBean.setIdUtente(resultSet.getInt(1));
		utenteBean.setCognome(resultSet.getString("cognome"));
		utenteBean.setNomeUtente(resultSet.getString("nomeUtente"));
		utenteBean.setPassword(resultSet.getString("password"));
		utenteBean.setTelefono(resultSet.getString("telefono"));
		utenteBean.setTipoUtente(TipoUtente.getTypeFromName(resultSet.getString("tipoUtente")));
		utenteBean.setIndirizzo(resultSet.getString("indirizzo"));
	}
	
	private void setUtenteStatement(UtenteBean utenteBean, PreparedStatement preparedStatement) throws SQLException {
		preparedStatement.setInt(1, utenteBean.getIdUtente());
		preparedStatement.setString(2, utenteBean.getCognome());
		preparedStatement.setString(3, utenteBean.getNomeUtente());
		preparedStatement.setString(4, utenteBean.getPassword());
		preparedStatement.setString(5, utenteBean.getTelefono());
		preparedStatement.setString(6, utenteBean.getTipoUtente().toString());
		preparedStatement.setString(7, utenteBean.getIndirizzo());
	}

	@Override
	public boolean doDelete(Integer code) throws SQLException {
		return false;
	}
}
