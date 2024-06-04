public class AiPlayer extends Player {
    public AiPlayer(String name) {
        super(name);
    }

    @Override
    public int choice() {
        return random.nextInt(2);
    }
}
