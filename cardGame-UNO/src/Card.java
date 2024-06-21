/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class Card {
    private Color color;
    private Number number;

    public Card(Color color, Number number) {
        this.color = color;
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
