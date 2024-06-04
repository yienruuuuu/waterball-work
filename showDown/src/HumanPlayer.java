import java.util.Scanner;

public class HumanPlayer extends Player {
	private final Scanner scanner;

	public HumanPlayer(String name) {
		super(name);
		scanner = new Scanner(System.in);
	}

	@Override
	public int choice() {
		System.out.println(getName() + ", do you want to exchange hands? (0: No, 1: Yes)");
		int choice = scanner.nextInt();
		while (choice != 0 && choice != 1) {
			System.out.println("Invalid choice. Please enter 0 or 1.");
			choice = scanner.nextInt();
		}
		return choice;
	}
}
