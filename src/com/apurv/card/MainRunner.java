package com.apurv.card;

import java.util.LinkedList;
import java.util.List;

import com.apurv.util.RandomGenerationUtils;

public class MainRunner {

	private static final MainRunner instance = new MainRunner();

	private MainRunner() {
	}

	public static void main(String[] args) {
//		instance.createFullDeck();
		instance.shuffleCardDeck();
	}

	private List<CardModel>  shuffleCardDeck() {
		
		List<CardModel> cardDeck = createFullDeck();
		LinkedList<CardModel> cardDeckShuffled =   new LinkedList<>();
		boolean insertFirst=true;
		while(true){
			int cardsLeft = cardDeck.size();
			if(cardsLeft==1){
				cardDeckShuffled.addAll(cardDeck);
				break;
			}
			if(insertFirst){
				cardDeckShuffled.addFirst(cardDeck.remove((int)RandomGenerationUtils.randomLongBetweenLimits(0, cardsLeft)));
			}else{
				cardDeckShuffled.addLast(cardDeck.remove((int)RandomGenerationUtils.randomLongBetweenLimits(0, cardsLeft)));
			}
			insertFirst=!insertFirst;
		}
		printDeckSequence(cardDeckShuffled);
		return cardDeckShuffled;
	}

	private List<CardModel> createFullDeck() {
		List<CardModel> cardDeck = new LinkedList<>();
		for (CardType type : CardType.values()) {
			for (CardNumber number : CardNumber.values()) {
				cardDeck.add(new CardModel(type, number));
			}
		}
		printDeckSequence(cardDeck);
		return cardDeck;
	}
	
	
	private void printDeckSequence(List<CardModel> cardDeck){
		System.out.println("-- start deck --");
		for (CardModel card : cardDeck) {
			System.out.println(card);
		}
		System.out.println("-- end deck --");
	}

}
