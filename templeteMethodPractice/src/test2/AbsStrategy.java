package test2;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public abstract class AbsStrategy<T> {
    public T search(String[] messages) {
        T result = defaultSearchResult();
        for (int index = 0; index < messages.length; index++) {
            result = updateSearchResult(index, messages[index]);
            System.out.println(messages[index]);
            if (searchEnd(index, messages)) {
                break;
            }
        }
        return result;
    }

    protected T defaultSearchResult() {
        return null; // Hook，如果傳入空陣列的話會回傳預設結果
    }

    protected boolean searchEnd(int messageIndex, String[] messages) {
        return false; // Hook，預設是直到走訪玩迴圈才結束
    }

    protected abstract T updateSearchResult(int messageIndex, String message);
}
