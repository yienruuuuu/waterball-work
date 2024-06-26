package show_down;

import templete.AbstractPlayer;

public abstract class ShowDownPlayer extends AbstractPlayer<ShowDownCard> {
    //玩家分數
    private int point;

    protected ShowDownPlayer(String number) {
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
     * 出排
     */
    public void takeATurn(ShowDownCard chosenCard) {
        System.out.println(getName() + " 出了一張牌: " + chosenCard);
        getHands().getHandCards().remove(chosenCard);
    }

    public int getPoint() {
        return point;
    }

    public void addPoint() {
        point++;
    }

    @Override
    public String toString() {
        return name;
    }
}
