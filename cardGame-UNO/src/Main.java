import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class Main {
    public static void main(String[] args) {
        //命名
        List<Player> players = List.of(
                new AiPlayer("P1"),
                new AiPlayer("P2"),
                new AiPlayer("P3"),
                new AiPlayer("P4")
        );
        System.out.println("players:" + players);
        //加入玩家
        Game game = new Game(players);
        //洗牌
        game.getDeck().shuffle();
        //遊戲開始
        game.startGame();
    }
}