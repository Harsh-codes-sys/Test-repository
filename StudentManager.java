import java.util.*;

class Student {
    private String name;
    private int age;
    private int marks;

    public Student(String name, int age, int marks) {
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getMarks() { return marks; }

    public void setMarks(int marks) { this.marks = marks; }

    @Override
    public String toString() {
        return "Name: " + name + " | Age: " + age + " | Marks: " + marks;
    }
}

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = getIntInput("Enter choice: ");
            switch (choice) {
                case 1 -> addStudent();
                case 2 -> assignRandomMarks();
                case 3 -> displayAllStudents();
                case 4 -> sortByMarks();
                case 5 -> findTopper();
                case 6 -> System.out.println("Exiting program...");
                default -> System.out.println("Invalid choice, try again!");
            }
        } while (choice != 6);
    }

    private static void showMenu() {
        System.out.println("\n=== Student Manager ===");
        System.out.println("1. Add Student");
        System.out.println("2. Assign Random Marks");
        System.out.println("3. Display All Students");
        System.out.println("4. Sort Students by Marks");
        System.out.println("5. Find Topper");
        System.out.println("6. Exit");
    }

    private static void addStudent() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        int age = getIntInput("Enter age: ");
        students.add(new Student(name, age, 0));
        System.out.println("Student added!");
    }

    private static void assignRandomMarks() {
        if (students.isEmpty()) {
            System.out.println("No students available!");
            return;
        }
        for (Student s : students) {
            int marks = random.nextInt(101); // 0–100
            s.setMarks(marks);
        }
        System.out.println("Random marks assigned.");
    }

    private static void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display!");
            return;
        }
        System.out.println("\n--- Student List ---");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    private static void sortByMarks() {
        if (students.isEmpty()) {
            System.out.println("No students to sort!");
            return;
        }
        students.sort(Comparator.comparingInt(Student::getMarks).reversed());
        System.out.println("Students sorted by marks (highest first).");
    }

    private static void findTopper() {
        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }
        Student topper = Collections.max(students, Comparator.comparingInt(Student::getMarks));
        System.out.println("Topper: " + topper);
    }

    private static int getIntInput(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number, try again!");
            }
        }
    }
}

