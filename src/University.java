import java.util.ArrayList;
import java.util.Scanner;

/**
 * Клас, який представляє університет та включає в себе класи Student та Mark.
 */
public class University {
    private final ArrayList<Student> students;

    /**
     * Конструктор класу University.
     */
    public University() {
        students = new ArrayList<>();
    }

    /**
     * Додає студента до списку університету.
     *
     * @param name    ім'я студента
     * @param surname прізвище студента
     */
    public void addStudent(String name, String surname) {
        if (name != null && !name.trim().isEmpty() && surname != null && !surname.trim().isEmpty()) {
            students.add(new Student(name, surname));
            System.out.println("Студента " + name + " " + surname + " додано до списку.");
        } else {
            System.out.println("Ім'я та прізвище студента не можуть бути порожніми.");
        }
    }

    /**
     * Видаляє студента зі списку університету за ім'ям та прізвищем.
     *
     * @param name    ім'я студента
     * @param surname прізвище студента
     */
    public void removeStudent(String name, String surname) {
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                students.remove(i);
                System.out.println("Студента " + name + " " + surname + " видалено.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Студента з ім'ям " + name + " та прізвищем " + surname + " не знайдено.");
        }
    }

    /**
     * Виводить інформацію про студента за ім'ям та прізвищем.
     *
     * @param name    ім'я студента
     * @param surname прізвище студента
     */
    public void displayStudentInfo(String name, String surname) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                System.out.println("Ім'я: " + student.getName());
                System.out.println("Прізвище: " + student.getSurname());
                System.out.println("Оцінки: " + student.getMarks());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Студента з ім'ям " + name + " та прізвищем " + surname + " не знайдено.");
        }
    }

    /**
     * Встановлює оцінку студенту за ім'ям, прізвищем та предметом.
     *
     * @param name    ім'я студента
     * @param surname прізвище студента
     * @param subject предмет оцінки
     * @param mark    оцінка студента
     */
    public void setMark(String name, String surname, String subject, int mark) {
        boolean found = false;
        for (Student student : students) {
            if (student.getName().equals(name) && student.getSurname().equals(surname)) {
                try {
                    Integer.parseInt(String.valueOf(mark));
                    if (mark >= 0 && mark <= 100) {
                        student.setMark(subject, mark);
                        System.out.println("Оцінку " + mark + " з предмету " + subject + " для студента " + name + " " + surname + " встановлено.");
                        found = true;
                    } else {
                        System.out.println("Оцінка повинна бути у діапазоні від 0 до 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Введено не ціле число для оцінки.");
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Студента з ім'ям " + name + " та прізвищем " + surname + " не знайдено.");
        }
    }

    /**
     * Точка входу в програму.
     *
     * @param args аргументи командного рядка
     */
    public static void main(String[] args) {
        University university = new University();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Додати студента");
            System.out.println("2. Видалити студента");
            System.out.println("3. Показати інформацію про студента");
            System.out.println("4. Встановити оцінку");
            System.out.println("5. Вийти");

            int choice;
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Неправильний ввід. Будь ласка, введіть номер опції.");
                scanner.next(); // Очищення буфера введення
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Введіть ім'я: ");
                    String name = scanner.next();
                    System.out.print("Введіть прізвище: ");
                    String surname = scanner.next();
                    university.addStudent(name, surname);
                    break;
                case 2:
                    System.out.print("Введіть ім'я: ");
                    name = scanner.next();
                    System.out.print("Введіть прізвище: ");
                    surname = scanner.next();
                    university.removeStudent(name, surname);
                    break;
                case 3:
                    System.out.print("Введіть ім'я: ");
                    name = scanner.next();
                    System.out.print("Введіть прізвище: ");
                    surname = scanner.next();
                    university.displayStudentInfo(name, surname);
                    break;
                case 4:
                    System.out.print("Введіть ім'я: ");
                    name = scanner.next();
                    System.out.print("Введіть прізвище: ");
                    surname = scanner.next();
                    System.out.print("Введіть предмет: ");
                    String subject = scanner.next();
                    System.out.print("Введіть оцінку: ");
                    int mark;
                    try {
                        mark = Integer.parseInt(scanner.next());
                        university.setMark(name, surname, subject, mark);
                    } catch (NumberFormatException e) {
                        System.out.println("Неправильний ввід. Оцінка повинна бути цілим числом.");
                    }
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Неправильний ввід. Будь ласка, виберіть одну з опцій.");
            }
        }
    }

    /**
     * Внутрішній клас, який представляє студента та його оцінки.
     */
    private static class Student {
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

        /**
         * Внутрішній клас, який представляє оцінку студента з певного предмету.
         */
        private static class Mark {
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
    }
}
