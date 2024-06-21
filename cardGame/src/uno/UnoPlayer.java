package uno;

import templete.AbstractPlayer;

public abstract class UnoPlayer extends AbstractPlayer<UnoCard> {

    protected UnoPlayer(String number) {
        super(number);
    }

    /**
     * 展示玩家手排
     */
    public void displayHandsForChoice() {
        System.out.println(name + "的手牌: ");
        for (int i = 0; i < hands.getHandCards().size(); i++) {
            System.out.println(i + ": " + hands.getHandCards().get(i));
        }
    }

    /**
     * 展示玩家手排
     */
    public void takeATurn(UnoCard chosenCard) {
        System.out.println(getName() + " 出了一張牌: " + chosenCard);
        getHands().getHandCards().remove(chosenCard);
    }

    @Override
    public String toString() {
        return name;
    }
}
