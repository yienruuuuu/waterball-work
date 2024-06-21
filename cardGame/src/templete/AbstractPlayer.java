package templete;

public abstract class AbstractPlayer<T extends Card> {
    protected String name;
    protected Hand<T> hands;

    protected AbstractPlayer(String number) {
        this.name = nameHimself(number);
        this.hands = new Hand<>();
    }

    public abstract T choice(T tableCard);

    public abstract String nameHimself(String number);


    public String getName() {
        return name;
    }

    public Hand<T> getHands() {
        return hands;
    }
}
