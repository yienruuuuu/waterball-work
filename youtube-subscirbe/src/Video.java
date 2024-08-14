import java.time.Duration;

/**
 * @author Eric.Lee
 * Date:2024/8/14
 */
public class Video {

    private String title;

    private String description;

    private Duration length;

    public Video(String title, String description, Duration length) {
        this.title = title;
        this.description = description;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public Duration getLength() {
        return length;
    }
}
