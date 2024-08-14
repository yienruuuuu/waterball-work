import java.time.Duration;

/**
 * @author Eric.Lee
 * Date:2024/8/14
 */
public class Main {
    public static void main(String[] args) {
        //創建
        ChannelSubscriber waterBall = new WaterBall("水球");
        ChannelSubscriber fireBall = new FireBall("火球");
        Channel waterBallSchool = new Channel("水球軟體學院");
        Channel pewDiePie = new Channel("PewDiePie");

        //訂閱
        waterBall.subscribe(waterBallSchool);
        waterBall.subscribe(pewDiePie);
        fireBall.subscribe(waterBallSchool);
        fireBall.subscribe(pewDiePie);

        //發片
        waterBallSchool.upload(new Video("C1M1S2", "這個世界正是物件導向的呢！", Duration.ofMinutes(4)));
        pewDiePie.upload(new Video("Hello guys", "Clickbait", Duration.ofSeconds(30)));
        waterBallSchool.upload(new Video("C1M1S3", "物件 vs. 類別", Duration.ofMinutes(1)));
        pewDiePie.upload(new Video("Minecraft", "Let’s play Minecraft", Duration.ofMinutes(30)));
    }
}