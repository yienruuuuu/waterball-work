package test2;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class SearchEmptyMessageIndex extends AbsStrategy<Integer> {
    @Override
    protected boolean searchEnd(int messageIndex, String[] messages) {
        return messages[messageIndex].isEmpty();
    }

    @Override
    protected Integer updateSearchResult(int messageIndex, String message) {
        return message.isEmpty() ? messageIndex : -1;
    }
}
