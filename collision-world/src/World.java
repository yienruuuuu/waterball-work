import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class World {
    Random rand = new Random();

    private Sprite[] worldLine;
    private final CollisionHandler collisionHandler;

    public World(CollisionHandler collisionHandler) {
        this.collisionHandler = collisionHandler;
        setWorldLine(30);
    }

    /**
     * 移動與碰撞處理
     *
     * @param c1 座標1
     * @param c2 座標2
     */
    public void collisionHandle(int c1, int c2) {
        Sprite sprite1 = getSpriteAt(c1);
        Sprite sprite2 = getSpriteAt(c2);
        if (sprite1 == null) {
            System.out.println("欲移動的生命不存在 請重新輸入");
        } else if (sprite2 == null) {
            remove(sprite1);
            move(c2, sprite1);
        } else {
            collisionHandler.collision(sprite1, sprite2, this);
        }
    }

    /**
     * 移除生命
     *
     * @param sprite 生命
     */
    public void remove(Sprite sprite) {
        worldLine[sprite.getCoordinate()] = null;
    }

    /**
     * 移動生命
     *
     * @param coordinate 座標
     * @param sprite     生命
     */
    public void move(int coordinate, Sprite sprite) {
        worldLine[coordinate] = sprite;
        sprite.setCoordinate(coordinate);
    }

    /**
     * 初始化世界與生命
     *
     * @param length 世界長度
     */
    private void setWorldLine(int length) {
        this.worldLine = new Sprite[length];
        Set<Integer> usedPositions = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            int position;
            // 產生不重複座標
            do {
                position = rand.nextInt(length);
            } while (usedPositions.contains(position));
            usedPositions.add(position);

            // 偽隨機產生三種類型角色
            if (i % 3 == 0) {
                worldLine[position] = new Hero(position, 30);
            } else if (i % 3 == 1) {
                worldLine[position] = new Water(position);
            } else {
                worldLine[position] = new Fire(position);
            }
        }
    }

    /**
     * 取得指定座標的生命
     *
     * @param coordinate 座標
     * @return 指定座標的生命
     */
    private Sprite getSpriteAt(int coordinate) {
        return worldLine[coordinate];
    }

    /**
     * 取得剩餘生命數量
     *
     * @return 剩餘生命數量
     */
    public int getSpriteCount() {
        int count = 0;
        for (Sprite sprite : worldLine) {
            if (sprite != null) {
                count++;
            }
        }
        return count;
    }

    /**
     * 印出世界狀態
     */
    public void printWorld() {
        System.out.println("生命座標：");
        for (int i = 0; i < worldLine.length; i++) {
            if (worldLine[i] != null) {
                System.out.println("座標 " + i + ": " + worldLine[i].getSymbol());
            }
        }
    }
}
