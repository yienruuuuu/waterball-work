package test1;

/**
 * @author Eric.Lee
 * Date:2024/6/21
 */
public abstract class AbstractStrategy {
    public void p1(int[] u) {
        int n = u.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compare(u[j], u[j + 1])) {
                    int ppp = u[j];
                    u[j] = u[j + 1];
                    u[j + 1] = ppp;
                }
            }
        }
    }

    public abstract boolean compare(int a, int b);
}
