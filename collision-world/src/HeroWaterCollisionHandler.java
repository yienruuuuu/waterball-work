public class HeroWaterCollisionHandler extends CollisionHandler {
    public HeroWaterCollisionHandler(CollisionHandler next) {
        super(next);
    }

    public void collision(Sprite c1, Sprite c2, World world) {
        if (c1 instanceof Hero hero && c2 instanceof Water) {
            hero.increaseHp(10);
            world.remove(c2);
            world.remove(c1);
            world.move(c2.getCoordinate(), hero);
            System.out.println("好愉悅 好開心 怎麼這麼濕 英雄被濕到了 增加了 10 點 hp, 同時水也消失了, 英雄進行移動");
        } else if (c2 instanceof Hero hero && c1 instanceof Water) {
            hero.increaseHp(10);
            world.remove(c1);
            System.out.println("好愉悅 好開心 怎麼這麼濕 英雄被濕到了 增加了 10 點 hp, 同時水也消失了");
        } else if (next != null) {
            next.collision(c1, c2, world);
        }
    }
}
