package model;

import exception.GenericError;
import model.lezione.*;
import model.abbonamento.*;
import java.sql.SQLException;
import java.util.*;

public class CarrelloModel {
	private ArrayList<LezioneBean> carrello;
	
	public CarrelloModel() {
		carrello = new ArrayList<>();
		
	}

	public ArrayList<LezioneBean> getCarrello() {
		return carrello;
	}

	public void setCarrello(ArrayList<LezioneBean> carrello) {
		this.carrello = carrello;
	}

	public synchronized void aggiungiAbbonamento(int id, float costo) {
		for(LezioneBean l : carrello) {
			if(l.getIdLezione() == id &&
				l.getCosto() == costo) {
					l.aumentaNumeroIscritti();
				}
			return;
		}
		
		LezioneDAO lezioneDAO = new LezioneDAO();
		
		try {
			LezioneBean lezione = lezioneDAO.doRetreiveByKey(id);
			carrello.add(lezione);
		} catch (SQLException e) {
			throw new GenericError();
		}
	}
		
		public synchronized void setIscritti(int id, int numeroIscritti, float costo) {
			for(LezioneBean l: carrello) {
				if(l.getIdLezione() == id && l.getCosto() == costo) {
					if(l.getNumIscritti() <=0 || numeroIscritti == 0)
						carrello.remove(l);
					else
						l.setNumIscritti(numeroIscritti);
					return;
				}
			}
		}
		
		public synchronized void rimuovi(int id, float costo) {
			carrello.removeIf(l -> l.getIdLezione() == id && 
					l.getCosto() == costo);
			
		}
		
}
