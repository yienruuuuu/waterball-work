import java.time.Duration;

public class FireBall extends ChannelSubscriber {

    public FireBall(String name) {
        super(name);
    }

    @Override
    public void doAfterNotify(Channel channel, Video video) {
        Duration videoLength = video.getLength();
        if (isShorterThanOneMinute(videoLength)) {
            unsubscribe(channel);
        }
    }


    public boolean isShorterThanOneMinute(Duration length) {
        Duration oneMinute = Duration.ofMinutes(1);
        return length.compareTo(oneMinute) <= 0;
    }
}
