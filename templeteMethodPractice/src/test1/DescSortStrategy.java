package test1;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public class DescSortStrategy extends AbstractStrategy {
    @Override
    public boolean compare(int a, int b) {
        return a < b;
    }
}
