public abstract class ChannelSubscriber {

    private final String name;

    public ChannelSubscriber(String name) {
        this.name = name;
    }

    public void subscribe(Channel channel) {
        channel.getSubscriberList().add(this);
        System.out.println(name + " 訂閱了 " + channel.getName());
    }

    public void unsubscribe(Channel channel) {
        channel.getSubscriberList().remove(this);
        System.out.println(name + " 解除訂閱了 " + channel.getName());
    }


    /**
     * 收到新片發布後的動作
     */
    public abstract void doAfterNotify(Channel channel, Video video);


    public String getName() {
        return name;
    }

}
