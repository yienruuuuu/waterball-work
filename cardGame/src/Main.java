import show_down.ShowDownAiPlayer;
import show_down.ShowDownGame;
import show_down.ShowDownPlayer;
import uno.UnoAiPlayer;
import uno.UnoGame;
import uno.UnoPlayer;

import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class Main {
    public static void main(String[] args) {
        testUno();
        testShowDown();
    }

    /**
     * 測試比大小
     */
    private static void testShowDown() {
        List<ShowDownPlayer> players = List.of(
                new ShowDownAiPlayer("P1"),
                new ShowDownAiPlayer("P2"),
                new ShowDownAiPlayer("P3"),
                new ShowDownAiPlayer("P4")
        );
        System.out.println("比大小 玩家列表:" + players);
        //加入玩家
        ShowDownGame game = new ShowDownGame(players);
        //遊戲開始
        game.startGame();
    }

    /**
     * 測試UNO
     */
    private static void testUno() {
        //玩家命名
        List<UnoPlayer> players = List.of(
                new UnoAiPlayer("P1"),
                new UnoAiPlayer("P2"),
                new UnoAiPlayer("P3"),
                new UnoAiPlayer("P4")
        );
        System.out.println("玩家列表:" + players);
        //加入玩家
        UnoGame game = new UnoGame(players);
        //遊戲開始
        game.startGame();
    }
}