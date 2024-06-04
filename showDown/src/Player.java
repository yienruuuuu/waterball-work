import java.util.*;

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

    /**
     * 交換手牌
     */
    public void exchangeHands(Player otherPlayer) {
        if (minusExchangeHandsTimes()) {
            List<Card> temp = new ArrayList<>(this.hands);
            this.hands = new ArrayList<>(otherPlayer.hands);
            otherPlayer.hands = temp;
        }
    }

    /**
     * (Show) 一張牌
     */
    public Card show() {
        if (!hands.isEmpty()) {
            Card card = hands.remove(0);
            System.out.println(name + " plays " + card);
            return card;
        }
        return null;
    }

    public boolean wantsToExchangeHands() {
        return exchangeHandsTimes > 0 && choice() == 1;
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

    public boolean minusExchangeHandsTimes() {
        if (exchangeHandsTimes > 0) {
            exchangeHandsTimes--;
            return true;
        }
        return false;
    }
}
