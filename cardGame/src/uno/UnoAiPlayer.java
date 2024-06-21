package uno;

public class UnoAiPlayer extends UnoPlayer {

	public UnoAiPlayer(String number) {
		super(number);
	}

	@Override
	public String nameHimself(String number) {
		return "AI_Player_" + number;
	}

	@Override
	public UnoCard choice(UnoCard tableCard) {
		for (UnoCard card : hands.getHandCards()) {
			if (card.getColor().equals(tableCard.getColor()) || card.getNumber().equals(tableCard.getNumber())) {
				return card;
			}
		}
		return null;
	}

}
