package test2;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class CountNumberOfWaterballs extends AbsStrategy<Integer>{
    private int count = 0;

    @Override
    protected Integer defaultSearchResult() {
        return 0;
    }

    @Override
    protected Integer updateSearchResult(int messageIndex, String message) {
        if ("Waterball".equals(message)) {
            count ++;
        }
        return count;
    }
}
