import java.util.List;

public class MatchmakingSystem {

    private final List<Individual> individuals;

    public MatchmakingSystem(List<Individual> individuals) {
        this.individuals = individuals;
    }

    public boolean add(Individual individual) {
        return individuals.add(individual);
    }

    /**
     * 配對所有對象，並根據個人選擇的配對方式，選擇最適合的配對對象並印出結果
     */
    public void matchAll() {
        for (Individual individual : individuals) {
            MatchmakingStrategy strategy = getStrategy(individual.getMatchType());
            Individual bestMatch = strategy.match(individual, individuals);
            System.out.println("Best match for " + individual + " is " + bestMatch);
        }
    }

    private MatchmakingStrategy getStrategy(MatchType matchType) {
        return switch (matchType) {
            case DISTANCE_BASED, DISTANCE_BASED_REVERSE -> new DistanceBasedMatchStrategy();
            case HABIT_BASED, HABIT_BASED_REVERSE -> new HabitBasedMatchStrategy();
        };
    }
}
