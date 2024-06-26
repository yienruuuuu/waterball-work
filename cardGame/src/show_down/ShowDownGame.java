package show_down;

import templete.AbstractCardGame;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowDownGame extends AbstractCardGame<ShowDownPlayer, ShowDownDeck, ShowDownCard> {
    private Map<ShowDownPlayer, ShowDownCard> tableCardsInTurn;
    private int turns = 0;

    public ShowDownGame(List<ShowDownPlayer> players) {
        super(new ShowDownDeck());
        add(players);
        // 初始化回合數為0
        turns = 0;
    }

    @Override
    protected int getInitialCardCount() {
        return 13;
    }

    @Override
    protected boolean gameEndCondition() {
        return turns >= 13;
    }

    @Override
    protected void firstActionAfterGameStart() {
        tableCardsInTurn = new HashMap<>();
    }

    @Override
    protected void actionAfterTurn() {
        // 計算目前回合的勝者
        ShowDownPlayer roundWinner = calculateRoundWinner();
        if (roundWinner != null) {
            roundWinner.addPoint();
            System.out.println("本回合贏家: " + roundWinner.getName());
        }
        turns++;
        System.out.println("===============回合結束===================");
    }

    @Override
    protected void playerTurn(ShowDownPlayer player) {
        // 展示玩家的手牌以供選擇
        player.displayHandsForChoice();
        // 玩家選擇牌
        ShowDownCard chosenCard = player.choice(null);
        // 玩家出牌
        player.takeATurn(chosenCard);
        tableCardsInTurn.put(player, chosenCard);
    }

    @Override
    protected ShowDownPlayer getWinner() {
        ShowDownPlayer winner = players.get(0);
        for (ShowDownPlayer player : players) {
            System.out.println(player.getName() + " : " + player.getPoint() + " 分");
            if (player.getPoint() > winner.getPoint()) {
                winner = player;
            }
        }
        return winner;
    }

    /**
     * 比大小
     *
     * @return 回合贏家
     */
    private ShowDownPlayer calculateRoundWinner() {
        ShowDownPlayer roundWinner = null;
        ShowDownCard highestCard = null;
        for (Map.Entry<ShowDownPlayer, ShowDownCard> entry : tableCardsInTurn.entrySet()) {
            if (highestCard == null || entry.getValue().compareTo(highestCard) > 0) {
                highestCard = entry.getValue();
                roundWinner = entry.getKey();
            }
        }
        return roundWinner;
    }
}
