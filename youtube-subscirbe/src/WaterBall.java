import java.time.Duration;

public class WaterBall extends ChannelSubscriber {

    public WaterBall(String name) {
        super(name);
    }

    @Override
    public void doAfterNotify(Channel channel, Video video) {
        Duration videoLength = video.getLength();
        if (isLongerThanThreeMinutes(videoLength)) {
            System.out.println(getName() + " 對影片 " + video.getTitle() + " 按讚。");
        }
    }

    private boolean isLongerThanThreeMinutes(Duration length) {
        Duration threeMinutes = Duration.ofMinutes(3);
        return length.compareTo(threeMinutes) > 0;
    }
}
