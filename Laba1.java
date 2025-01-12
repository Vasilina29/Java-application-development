import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student {
    private String name;
    private String group;
    private int course;
    private List<Integer> grades;

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = grades;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    public double calculateAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    public void advanceToNextCourse() {
        this.course++;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', group='" + group + "', course=" + course + ", grades=" + grades + '}';
    }
}

class StudentManagement {

    public static void processStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.calculateAverageGrade() < 3.0) {
                iterator.remove();
            } else {
                student.advanceToNextCourse();
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Иванов Иван", "Группа A", 1, List.of(4, 5, 3)));
        students.add(new Student("Петров Петр", "Группа B", 1, List.of(2, 3, 2)));
        students.add(new Student("Сидорова Мария", "Группа C", 2, List.of(5, 4, 5)));
        students.add(new Student("Кузнецова Анна", "Группа D", 2, List.of(3, 2, 4)));

        // Обработка студентов
        processStudents(students);
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
    }
}
