import card.Card;
import card.Rank;
import card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards = new ArrayList<>();

    public Deck(String cardList) {
//        //初始化牌組
//        for (Suit suit : Suit.values()) {
//            for (Rank rank : Rank.values()) {
//                cards.add(new Card(rank, suit));
//            }
//        }
//        shuffle();
        setDeckFromInput(cardList);
    }

    /**
     * 從輸入的字符串設置牌組
     */
    private void setDeckFromInput(String shuffledCards) {
        String[] cardStrings = shuffledCards.split(" ");
        for (String cardStr : cardStrings) {
            String suitSymbol = cardStr.substring(0, 1); // 取得花色符號
            String rankSymbol = cardStr.substring(2, cardStr.length() - 1); // 取得 rank 符號

            Suit suit = Suit.fromSymbol(suitSymbol);
            Rank rank = Rank.fromSymbol(rankSymbol);

            cards.add(new Card(rank, suit));
        }
    }

    /**
     * 洗牌
     */
    public void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * 從牌堆中的頂端取走一張牌
     *
     * @return Card 牌
     */
    public Card deal() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("沒牌啦");
        }
        return cards.remove(cards.size() - 1);
    }

    /**
     * 牌堆是否已空
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return cards.isEmpty();
    }

}
