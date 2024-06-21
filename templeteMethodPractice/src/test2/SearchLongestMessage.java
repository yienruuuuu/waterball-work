package test2;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class SearchLongestMessage extends AbsStrategy<String>{
    private String maxLengthMessage = "";

    @Override
    protected String updateSearchResult(int messageIndex, String message) {
        maxLengthMessage = message.length() > maxLengthMessage.length() ? message : maxLengthMessage;
        return maxLengthMessage;
    }
}
