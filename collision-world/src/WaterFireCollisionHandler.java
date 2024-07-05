public class WaterFireCollisionHandler extends CollisionHandler {
    public WaterFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    public void collision(Sprite c1, Sprite c2, World world) {
        if ((c1 instanceof Water && c2 instanceof Fire) ||
                (c1 instanceof Fire && c2 instanceof Water)) {
            System.out.println("是火與水的碰撞!! 喔天啊! 場地上產生了大量的水蒸氣，火跟水兩敗俱傷，一起消失了");
            world.remove(c2);
            world.remove(c1);
        } else if (next != null) {
            next.collision(c1, c2, world);
        }
    }
}
