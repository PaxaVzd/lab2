import java.util.ArrayList;

/**
 * Клас, який представляє студента.
 */
public class Student {
    private final String name;
    private final String surname;
    private final ArrayList<Mark> marks;

    /**
     * Конструктор класу Student.
     *
     * @param name    ім'я студента
     * @param surname прізвище студента
     */
    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        marks = new ArrayList<>();
    }

    /**
     * Повертає ім'я студента.
     *
     * @return ім'я студента
     */
    public String getName() {
        return name;
    }

    /**
     * Повертає прізвище студента.
     *
     * @return прізвище студента
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Повертає список оцінок студента.
     *
     * @return список оцінок студента
     */
    public ArrayList<Mark> getMarks() {
        return marks;
    }

    /**
     * Встановлює оцінку студенту за певним предметом.
     *
     * @param subject предмет оцінки
     * @param mark    оцінка студента
     */
    public void setMark(String subject, int mark) {
        for (Mark m : marks) {
            if (m.getSubject().equals(subject)) {
                m.setMark(mark);
                return;
            }
        }
        marks.add(new Mark(subject, mark));
    }

    /**
     * Перевизначений метод toString для класу Student.
     *
     * @return рядок, який представляє студента
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Mark mark : marks) {
            sb.append(mark.toString());
            sb.append(", ");
        }
        sb.setLength(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }
}
