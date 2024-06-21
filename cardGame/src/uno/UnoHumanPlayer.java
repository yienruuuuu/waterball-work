package uno;

import java.util.Scanner;

public class UnoHumanPlayer extends UnoPlayer {

    public UnoHumanPlayer(String number) {
        super(number);
    }

    @Override
    public UnoCard choice(UnoCard tableCard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請選擇要出的牌(輸入編號)或輸入-1表示不出牌:");

        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice >= 0 && choice < hands.getHandCards().size()) {
                UnoCard chosenCard = hands.getHandCards().get(choice);
                if (chosenCard.getColor() == tableCard.getColor() || chosenCard.getNumber() == tableCard.getNumber()) {
                    return chosenCard;
                } else {
                    System.out.println("選擇的牌無法出牌，請重新選擇:");
                }
            } else if (choice == -1) {
                return null;
            } else {
                System.out.println("無效的選擇，請重新輸入:");
            }
        }
    }

    @Override
    public String nameHimself(String number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入你的名字: ");
        String inputName = scanner.nextLine();
        return inputName + "_" + number;
    }
}
