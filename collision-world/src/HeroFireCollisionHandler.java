public class HeroFireCollisionHandler extends CollisionHandler {
    public HeroFireCollisionHandler(CollisionHandler next) {
        super(next);
    }

    public void collision(Sprite c1, Sprite c2, World world) {
        if (c1 instanceof Hero hero && c2 instanceof Fire) {
            hero.decreaseHp(10);
            world.remove(c2);
            world.remove(c1);
            if (!hero.isDead()) {
                world.move(c2.getCoordinate(), hero);
                System.out.println("好燙 好燙 英雄被燙到了 減少了 10 點 hp, 同時火焰也消失了, 英雄進行移動");
            } else {
                System.out.println("好燙 好燙 英雄被燙到了 減少了 10 點 hp, 同時火焰也消失了, 同時英雄HP為0, 英雄死亡");
            }
        } else if (c2 instanceof Hero hero && c1 instanceof Fire) {
            hero.decreaseHp(10);
            world.remove(c1);
            System.out.println("好燙 好燙 英雄被燙到了 減少了 10 點 hp, 火焰也消失了");
            if (hero.isDead()) {
                world.remove(c2);
                System.out.println("英雄HP為0, 英雄死亡");
            }
        } else if (next != null) {
            next.collision(c1, c2, world);
        }
    }
}
