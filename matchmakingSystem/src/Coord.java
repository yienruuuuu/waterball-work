public class Coord {

	private double coordX;

	private double coordY;

	public String toString() {
		return "(" + coordX + ", " + coordY + ")";
	}

	public Coord(double x, double y) {
		this.coordX = x;
		this.coordY = y;
	}

	public double getX() {
		return coordX;
	}

	public double getY() {
		return coordY;
	}
}
