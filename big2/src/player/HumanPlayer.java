package player;

import card.Card;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class HumanPlayer extends Player {
    public HumanPlayer(int id) {
        super(id);
    }

    @Override
    public String enterPlayersName() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    @Override
    public List<Integer> play(List<Card> topPlay) {
        List<Integer> inputInt = new ArrayList<>();
        while (true) {
            // 顯示玩家的手牌
            displayHand();
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            inputInt = parseInput(input);
            if (!inputInt.isEmpty()) {
                break;
            }
            System.out.println("此牌型不合法，請再嘗試一次。");
        }
        return inputInt;
    }

    private List<Integer> parseInput(String input) {
        try {
            String[] parts = input.trim().split("\\s+");
            return Stream.of(parts)
                    .map(Integer::parseInt)
                    .toList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
