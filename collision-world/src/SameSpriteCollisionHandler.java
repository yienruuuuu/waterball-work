public class SameSpriteCollisionHandler extends CollisionHandler {
    public SameSpriteCollisionHandler(CollisionHandler next) {
        super(next);
    }

    public void collision(Sprite c1, Sprite c2, World world) {
        if (c1.getClass() == c2.getClass()) {
            System.out.println("相同生命的碰撞!! c1 =" + c1.getSymbol() + " c2 =" + c2.getSymbol() + " 發現是自己人 都放棄移動了");
        } else if (next != null) {
            next.collision(c1, c2, world);
        }
    }

}
