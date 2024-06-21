/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public abstract class Player {
    protected String name;
    protected Hand hands;

    protected Player(String number) {
        this.name = nameHimself(number);
        hands = new Hand();
    }

    public abstract String nameHimself(String number);

    /**
     * 玩家出牌
     */
    public void takeATurn(Card chosenCard) {
        System.out.println(getName() + " 出了一張牌: " + chosenCard);
        getHands().getHandCards().remove(chosenCard);
    }

    public abstract Card choice(Card tableCard);

    public String getName() {
        return name;
    }

    public Hand getHands() {
        return hands;
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
}
