package com.apurv.card;

public class CardModel {
	
	private CardType type;
	private CardNumber number;

	
	
	
	public CardModel(CardType type, CardNumber number) {
		super();
		this.type = type;
		this.number = number;
	}
	public CardType getType() {
		return type;
	}
	public void setType(CardType type) {
		this.type = type;
	}
	public CardNumber getNumber() {
		return number;
	}
	public void setNumber(CardNumber number) {
		this.number = number;
	}
	@Override
	public String toString() {
		return "[ "+ number + " of "+ type+" ]";
	}

	
	
	
}
