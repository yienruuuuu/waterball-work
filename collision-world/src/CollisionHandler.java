public abstract class CollisionHandler {
    protected CollisionHandler next;

    public CollisionHandler(CollisionHandler next) {
        this.next = next;
    }

    public abstract void collision(Sprite c1, Sprite c2, World world);
}
