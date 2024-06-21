package uno;

public enum Color {
	BLUE("\u001B[44m \u001B[0m"),
	RED("\u001B[41m \u001B[0m"),
	YELLOW("\u001B[43m \u001B[0m"),
	GREEN("\u001B[42m \u001B[0m");

	private final String colorBlock;

	Color(String colorBlock) {
		this.colorBlock = colorBlock;
	}

	@Override
	public String toString() {
		return colorBlock;
	}
}
