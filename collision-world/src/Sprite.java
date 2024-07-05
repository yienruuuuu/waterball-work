public abstract class Sprite {
    int coordinate;

    protected Sprite(int coordinate) {
        setCoordinate(coordinate);
    }

    public int getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int coordinate) {
        this.coordinate = coordinate;
    }

    public String getSymbol() {
        return "空";
    }
}
