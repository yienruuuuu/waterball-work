package uno;

import templete.Card;

public class UnoCard extends Card {
    private Color color;
    private Number number;

    public UnoCard(Color color, Number number) {
        setColor(color);
        setNumber(number);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public Number getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return color + " " + number.getSymbol();
    }


}
