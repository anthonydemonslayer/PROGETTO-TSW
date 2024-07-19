package model;

import java.util.ArrayList;

import model.abbonamento.AbbonamentoBean;

public class CarrelloModel {
	private ArrayList<AbbonamentoBean> carrelloAbbonamenti;
	
	public CarrelloModel() {
		carrelloAbbonamenti = new ArrayList<>();
		
	}

	public ArrayList<AbbonamentoBean> getCarrelloAbbonamenti() {
		return carrelloAbbonamenti;
	}

	public void setCarrelloAbbonamenti(ArrayList<AbbonamentoBean> carrelloAbbonamenti) {
		this.carrelloAbbonamenti = carrelloAbbonamenti;
	}

	public synchronized void aggiungiAbbonamento(int id, float costo) {
		for(AbbonamentoBean a : carrelloAbbonamenti) {
			if(a.getIdAbbonamento() == id && 
				a.getCosto() == costo) {
				a.setIdAbbonamento(id);
			}
			return;
		}
	}
}