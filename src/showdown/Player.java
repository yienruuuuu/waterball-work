package showdown;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Player {
	protected final Random random = new Random();

	protected String name;
	protected List<Card> hands;
	protected int point;
	protected int exchangeHandsTimes;

	protected Player(String name) {
		nameHimself(name);
		hands = new ArrayList<>();
		point = 0;
		exchangeHandsTimes = 1;
	}

	protected void nameHimself(String name) {
		this.name = name;
	}

	public abstract int choice();

	public void takesATurn() {
		//TODO  Implement logic for taking a turn
	}

	public void exchangeHands(Player otherPlayer) {
		if (exchangeHandsTimes > 0) {
			List<Card> temp = new ArrayList<>(this.hands);
			this.hands = new ArrayList<>(otherPlayer.hands);
			otherPlayer.hands = temp;
			exchangeHandsTimes--;
		}
	}

	public Card show() {
		if (!hands.isEmpty()) {
			Card card = hands.remove(0);
			System.out.println(name + " plays " + card);
			return card;
		}
		return null;
	}

	public void addCard(Card card) {
		hands.add(card);
	}

	public int getPoint() {
		return point;
	}

	public void addPoint() {
		point++;
	}

	public String getName() {
		return name;
	}

	public List<Card> getHands() {
		return hands;
	}
}
