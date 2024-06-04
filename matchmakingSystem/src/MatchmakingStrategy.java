import java.util.List;

/**
 * @author Eric.Lee
 * Date:2024/6/11
 */
public interface MatchmakingStrategy {
    /**
     * 配對
     *
     * @param individual  尋求配對的個體
     * @param individuals 系統配對池
     * @return 配對成功的個體
     */
    Individual match(Individual individual, List<Individual> individuals);
}
