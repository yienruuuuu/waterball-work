import player.HumanPlayer;

import java.util.List;
import java.util.Scanner;

/**
 * @author Eric.Lee
 * Date:2024/7/9
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cardList = scanner.nextLine();

        Big2 game = new Big2(List.of(new HumanPlayer(1), new HumanPlayer(2), new HumanPlayer(3), new HumanPlayer(4)), cardList);
        game.start();
    }
}