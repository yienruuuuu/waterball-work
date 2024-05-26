package showdown;

public class HumanPlayer extends Player {
	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public int choice() {
		return random.nextInt(2);
	}
}
