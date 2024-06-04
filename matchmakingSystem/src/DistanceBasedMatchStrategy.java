import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/11
 */
public class DistanceBasedMatchStrategy implements MatchmakingStrategy {
    @Override
    public Individual match(Individual individual, List<Individual> individuals) {
        Individual bestMatch = null;
        double bestDistance = getInitialBestScore(individual.getMatchType());

        for (Individual i : individuals) {
            if (!i.equals(individual)) {
                double currentDistance = distance(individual, i);

                // 根據配對分數，依反轉與否，更新最佳配對人
                if (individual.getMatchType() == MatchType.DISTANCE_BASED_REVERSE) {
                    if (currentDistance > bestDistance) {
                        bestDistance = currentDistance;
                        bestMatch = i;
                    }
                } else {
                    if (currentDistance < bestDistance) {
                        bestDistance = currentDistance;
                        bestMatch = i;
                    }
                }
            }
        }
        return bestMatch;
    }

    private double distance(Individual a, Individual b) {
        return Math.sqrt(
                Math.pow(a.getCoord().getX() - b.getCoord().getX(), 2) +
                        Math.pow(a.getCoord().getY() - b.getCoord().getY(), 2)
        );
    }

    /**
     * 根據配對策略，取得初始最佳分數
     *
     * @param matchType 配對策略
     * @return 初始最佳分數
     */
    private double getInitialBestScore(MatchType matchType) {
        return switch (matchType) {
            case DISTANCE_BASED_REVERSE -> Double.MIN_VALUE;
            case DISTANCE_BASED -> Double.MAX_VALUE;
            default -> throw new IllegalArgumentException("Unexpected value: " + matchType);
        };
    }
}


