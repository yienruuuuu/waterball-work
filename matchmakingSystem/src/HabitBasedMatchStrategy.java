import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/11
 */
public class HabitBasedMatchStrategy implements MatchmakingStrategy {

    @Override
    public Individual match(Individual someBodyNeedFriend, List<Individual> individuals) {
        Individual bestMatch = null;
        int bestScore = getInitialBestScore(someBodyNeedFriend.getMatchType());

        for (Individual targetIndividual : individuals) {
            if (targetIndividual.equals(someBodyNeedFriend)) {
                continue;
            }
            int score = commonHabits(someBodyNeedFriend, targetIndividual);

            // 根據配對分數，依反轉與否，更新最佳配對人
            if (someBodyNeedFriend.getMatchType() == MatchType.HABIT_BASED_REVERSE) {
                if (score < bestScore) {
                    bestScore = score;
                    bestMatch = targetIndividual;
                }
            } else {
                if (score > bestScore) {
                    bestScore = score;
                    bestMatch = targetIndividual;
                }
            }
        }
        return bestMatch;
    }


    /**
     * 計算兩個人的興趣重合分數
     *
     * @param a 對象A
     * @param b 對象B
     * @return 兩個人的興趣重合分數
     */
    private int commonHabits(Individual a, Individual b) {
        int count = 0;
        for (Habit habit : a.getHabits()) {
            if (b.getHabits().contains(habit)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 根據配對策略，取得初始最佳分數
     *
     * @param matchType 配對策略
     * @return 初始最佳分數
     */
    private int getInitialBestScore(MatchType matchType) {
        return switch (matchType) {
            case HABIT_BASED_REVERSE -> Integer.MAX_VALUE;
            case HABIT_BASED -> Integer.MIN_VALUE;
            default -> throw new IllegalArgumentException("Unexpected value: " + matchType);
        };
    }
}
