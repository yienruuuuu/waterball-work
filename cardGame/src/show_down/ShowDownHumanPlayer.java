package show_down;

import java.util.Random;
import java.util.Scanner;

public class ShowDownHumanPlayer extends ShowDownPlayer {
    protected final Random random = new Random();

    public ShowDownHumanPlayer(String number) {
        super(number);
    }

    @Override
    public String nameHimself(String number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請輸入你的名字 尊貴的賭徒: ");
        String inputName = scanner.nextLine();
        return inputName + "_" + number;
    }

    @Override
    public ShowDownCard choice(ShowDownCard tableCard) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("請選擇要出的牌(輸入編號):");
        int choice;
        while (true) {
            choice = scanner.nextInt();
            if (choice >= 0 && choice < hands.getHandCards().size()) {
                return hands.getHandCards().get(choice);
            } else {
                System.out.println("無效的選擇，請重新輸入:");
            }
        }
    }
}
