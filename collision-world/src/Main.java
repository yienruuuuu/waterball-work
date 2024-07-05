import java.util.Scanner;

/**
 * @author Eric.Lee
 * Date:2024/7/5
 */
public class Main {
    public static void main(String[] args) {
        World world = new World(new SameSpriteCollisionHandler(new WaterFireCollisionHandler(new HeroFireCollisionHandler(new HeroWaterCollisionHandler(null)))));
        Scanner scanner = new Scanner(System.in);
        while (world.getSpriteCount() > 0) {
            world.printWorld();
            String[] parts = getNumberInputFromUser(scanner);
            world.collisionHandle(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
        }
    }

    /**
     * 取得使用者輸入的兩個數字
     *
     * @param scanner scanner
     * @return 兩個數字
     */
    private static String[] getNumberInputFromUser(Scanner scanner) {
        System.out.println("請輸入兩個位置（以空格分隔）來移動生命（0-29）：");
        String input = scanner.nextLine();
        return input.split(" ");
    }
}