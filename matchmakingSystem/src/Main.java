import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/4
 */
public class Main {
    public static void main(String[] args) {
        // 初始化配對者信息
        List<Individual> individuals = initIndividuals();
        // 初始化配對系統
        MatchmakingSystem system = new MatchmakingSystem(individuals);
        //幫每位用戶配對最適合他的用戶
        system.matchAll();
    }


    /**
     * 初始化系統配對池信息
     *
     * @return Set<Individual>
     */
    private static List<Individual> initIndividuals() {
        Individual individual1 = new Individual(
                1,
                Gender.MALE,
                25,
                "I love sports.",
                List.of(new Habit("Basketball"), new Habit("Cooking")),
                new Coord(10, 20),
                MatchType.HABIT_BASED_REVERSE);

        Individual individual2 = new Individual(
                2,
                Gender.FEMALE,
                22,
                "Cooking is my passion.",
                List.of(new Habit("Reading"), new Habit("Cooking")),
                new Coord(30, 40),
                MatchType.HABIT_BASED);

        Individual individual3 = new Individual(
                3,
                Gender.MALE,
                28,
                "Reading and gaming are my hobbies.",
                List.of(new Habit("Cooking"), new Habit("Reading")),
                new Coord(0, 0),
                MatchType.DISTANCE_BASED);

        Individual individual4 = new Individual(
                4,
                Gender.FEMALE,
                26,
                "I enjoy cooking and sports.",
                List.of(new Habit("Gaming"), new Habit("Reading")),
                new Coord(100, 100),
                MatchType.DISTANCE_BASED_REVERSE);


        return List.of(individual1, individual2, individual3, individual4);
    }
}