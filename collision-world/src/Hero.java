public class Hero extends Sprite {
    private int hp;

    public Hero(int coordinate, int hp) {
        super(coordinate);
        setHp(hp);
    }

    public void decreaseHp(int amount) {
        hp -= amount;
    }

    public void increaseHp(int amount) {
        hp += amount;
    }

    public boolean isDead() {
        return hp <= 0;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    @Override
    public String getSymbol() {
        return "H HP=" + getHp();
    }
}
