package player;

import card.Card;

import java.util.List;

public abstract class Player {
    protected int id;
    protected String name;
    protected Hand hand;

    public Player(int id) {
        setId(id);
        setName();
        this.hand = new Hand();
    }

    /**
     * 玩家輸入名稱
     *
     * @return 玩家輸入的名稱
     */
    public abstract String enterPlayersName();

    /**
     * 玩家出牌
     *
     * @param topPlay 檯面上的牌
     * @return 玩家出的牌
     */
    public abstract List<Integer> play(List<Card> topPlay);


    /**
     * 玩家是否獲勝
     *
     * @return true:獲勝, false:未獲勝
     */
    public boolean isWinner() {
        return hand.isEmpty();
    }

    /**
     * 玩家是否有指定的牌
     *
     * @param card 指定的牌
     * @return true:有, false:沒有
     */
    public boolean hasCard(Card card) {
        return getHand().getCards().contains(card);
    }

    //setter

    public void setId(int id) {
        if (id > 4 || id < 0) {
            throw new IllegalArgumentException("id 範圍不對喔");
        }
        this.id = id;
    }

    public void setName() {
        this.name = enterPlayersName();
    }

    /**
     * 展示玩家手牌
     */
    protected void displayHand() {
        List<Card> sortedHand = hand.getCards().stream()
                .sorted().toList();

        StringBuilder indexBuilder = new StringBuilder();
        StringBuilder cardBuilder = new StringBuilder();

        // 組裝索引和手牌的字串
        // 调整索引和手牌的宽度
        for (int i = 0; i < sortedHand.size(); i++) {
            // 统一宽度为 5，确保两位数的索引和牌显示对齐
            indexBuilder.append(String.format("%-7d", i));
            String cardRepresentation = sortedHand.get(i).toString();
            cardBuilder.append(String.format("%-7s", cardRepresentation));
        }

        // 打印拼接的字符串
        System.out.println(indexBuilder.toString());
        System.out.println(cardBuilder.toString());
    }

    // getter

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }
}
