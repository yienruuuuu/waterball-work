import java.util.Objects;

public class Habit {

    private String name;

    public Habit(String name) {
        setName(name);
    }

    private void setName(String name) {
        if (name.length() > 10 || name.isEmpty()) {
            throw new IllegalArgumentException("ID must be a positive integer.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Habit habit = (Habit) o;
        return Objects.equals(name, habit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
