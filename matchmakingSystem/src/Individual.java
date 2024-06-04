import java.util.List;

public class Individual {
    private int id;
    private Gender gender;
    private int age;
    private String intro;
    private List<Habit> habits;
    private Coord coord;
    private MatchType matchType;

    public Individual(int id, Gender gender, int age, String intro, List<Habit> habits, Coord coord, MatchType matchType) {
        setId(id);
        setGender(gender);
        setAge(age);
        setIntro(intro);
        setHabits(habits);
        setCoord(coord);
        setMatchType(matchType);
    }

    private void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        this.id = id;
    }

    private void setAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be at least 18.");
        }
        this.age = age;
    }

    private void setIntro(String intro) {
        if (intro.length() > 200) {
            throw new IllegalArgumentException("Intro must be 200 characters or less.");
        }
        this.intro = intro;
    }

    private void setHabits(List<Habit> habits) {
        if (habits == null || habits.isEmpty()) {
            throw new IllegalArgumentException("Habits cannot be null or empty.");
        }
        this.habits = habits;
    }

    private void setCoord(Coord coord) {
        if (coord == null) {
            throw new IllegalArgumentException("Coord cannot be null.");
        }
        this.coord = coord;
    }

    private void setGender(Gender gender) {
        this.gender = gender;
    }

    private void setMatchType(MatchType matchType) {
        this.matchType = matchType;
    }

    public int getId() {
        return id;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getIntro() {
        return intro;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public Coord getCoord() {
        return coord;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    @Override
    public String toString() {
        return "用戶{" +
                "id=" + id +
                ", gender=" + gender +
                ", age=" + age +
                ", intro='" + intro + '\'' +
                ", habits=" + habits +
                ", coord=" + coord +
                ", matchType=" + matchType +
                '}';
    }
}
