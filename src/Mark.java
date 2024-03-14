/**
 * Клас, який представляє оцінку студента з певного предмету.
 */
public class Mark {
    private final String subject;
    private int mark;

    /**
     * Конструктор класу Mark.
     *
     * @param subject предмет оцінки
     * @param mark    оцінка студента
     */
    public Mark(String subject, int mark) {
        this.subject = subject;
        this.mark = mark;
    }

    /**
     * Повертає предмет оцінки.
     *
     * @return предмет оцінки
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Встановлює оцінку студента.
     *
     * @param mark оцінка студента
     */
    public void setMark(int mark) {
        this.mark = mark;
    }

    /**
     * Перевизначений метод toString для класу Mark.
     *
     * @return рядок, який представляє оцінку
     */
    @Override
    public String toString() {
        return "{" +
                "предмет='" + subject + '\'' +
                ", оцінка=" + mark +
                '}';
    }
}
