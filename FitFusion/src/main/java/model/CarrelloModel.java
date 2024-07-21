package model;

import exception.GenericError;
import model.lezione.*;
import model.prenota.PrenotaBean;
import model.prenota.PrenotaDAO;
import model.utente.UtenteBean;
import model.abbonamento.*;
import model.corso.CorsoBean;
import model.corso.CorsoDAO;
import model.include.IncludeBean;
import model.include.IncludeDAO;

import java.sql.SQLException;
import java.util.*;

public class CarrelloModel {
	private ArrayList<PrenotaBean> prenotazioni;
	private AbbonamentoBean abbonamento;
	private ArrayList<IncludeBean> include;
	
	
	public CarrelloModel() {
		prenotazioni = new ArrayList<>();
		include = new ArrayList<>();
	}

	public ArrayList<PrenotaBean> getCarrello() {
		return prenotazioni;
	}


	public synchronized void setAbbonamento(AbbonamentoBean abbonamento) {
		this.abbonamento = abbonamento;
	}
		
	public synchronized void addPrenotazione(PrenotaBean p) {
		prenotazioni.add(p);
	}
	
	public List<PrenotaBean> getPrenotazioni() {
		return prenotazioni;
	}
	
	public synchronized void setCorsi(ArrayList<IncludeBean> corsi) {
		this.include = corsi;
	}
	
	public List<IncludeBean> getInclude() {
		return include;
	}
	
	public List<CorsoBean> getCorsi() {
		CorsoDAO corsoDAO = new CorsoDAO();
		List<CorsoBean> corsi = new ArrayList<>();
		
		for (IncludeBean i : include)
			try {
				corsi.add(corsoDAO.doRetreiveByKey(i.getNomeCorso()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return corsi;
	}
	
	public List<LezioneBean> getLezioni() {
		LezioneDAO lezioneDAO = new LezioneDAO();
		List<LezioneBean> lezioni = new ArrayList<>();
		
		for (PrenotaBean p : prenotazioni)
			try {
				lezioni.add(lezioneDAO.doRetreiveByKey(p.getIdLezione()));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		return lezioni;
	}
	
	public AbbonamentoBean getAbbonamento() {
		return abbonamento;
	}
	
	public synchronized float getPrezzo() {
		float costoAbbonamento = 0;
		double costoLezioni = 0;
		if (abbonamento != null) costoAbbonamento = abbonamento.getCosto();
		List<LezioneBean> lezioni = getLezioni();
		costoLezioni = lezioni.stream().mapToDouble((l) -> l.getCosto()).sum();
		return (float) (costoAbbonamento + costoLezioni);
	}
	
	public synchronized void svuota() {
		prenotazioni.clear();
		include.clear();
		abbonamento = null;
	}
	
	public synchronized void rimuoviLezione(int lezID) {
		for (PrenotaBean p : prenotazioni) {
			if (p.getIdLezione() == lezID) {
				prenotazioni.remove(p);
				return;
			}
		}
	}
	
	public synchronized void acquista(UtenteBean utente) {
		PrenotaDAO prenotaDAO = new PrenotaDAO();
		AbbonamentoDAO abbonamentoDAO = new AbbonamentoDAO();

		if (abbonamento != null) {
			abbonamento.setIdUtente(utente.getIdUtente());
			try {
				
				int id = abbonamentoDAO.doSaveAndReturnId(abbonamento);
				IncludeDAO includeDAO = new IncludeDAO();
				include.forEach((include) -> {
					include.setIdAbbonamento(id);
					try {
						includeDAO.doSave(include);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				});
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		prenotazioni.forEach((p) -> {
			p.setIdUtente(utente.getIdUtente());

			try {
				System.out.println("Salvo "+p.toString());
				prenotaDAO.doSave(p);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		});
		
		svuota();
	}
	
}
