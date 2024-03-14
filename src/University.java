import java.util.ArrayList;
import java.util.Scanner;

/**
 * Клас, який представляє університет.
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
}
