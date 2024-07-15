package model;

import exception.GenericError;
import model.lezione.*;
import model.abbonamento.*;
import java.sql.SQLException;
import java.util.*;

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

	
}
