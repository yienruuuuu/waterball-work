import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String name;

    private List<ChannelSubscriber> subscriberList;

    private List<Video> videoList;

    public Channel(String name) {
        setName(name);
        subscriberList = new ArrayList<>();
        videoList = new ArrayList<>();
    }

    /**
     * 上傳影片
     */
    public void upload(Video video) {
        System.out.println("頻道 " + name + " 上架了一則新影片 " + video.getTitle());
        videoList.add(video);
        notify(video);
    }

    /**
     * 通知訂閱者
     */
    public void notify(Video video) {
        List<ChannelSubscriber> subscribersSnapshot = new ArrayList<>(subscriberList);
        for (ChannelSubscriber subscriber : subscribersSnapshot) {
            subscriber.doAfterNotify(this, video);
        }
    }

    public String getName() {
        return name;
    }

    public List<ChannelSubscriber> getSubscriberList() {
        return subscriberList;
    }

    public void setName(String name) {
        this.name = name;
    }
}
