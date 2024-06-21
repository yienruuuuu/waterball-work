import uno.*;

import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class Main {
    public static void main(String[] args) {
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