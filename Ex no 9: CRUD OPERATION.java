import java.util.ArrayList;
import java.util.List;

class Student {
    int rollno;
    String name;
    String department;
    int marks;

    public Student(int rollno, String name, String department, int marks) {
        this.rollno = rollno;
        this.name = name;
        this.department = department;
        this.marks = marks;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Student> db = new ArrayList<>();

        db.add(new Student(518, "jason", "ECE", 94));
        db.add(new Student(833, "padma", "EEE", 92));
        System.out.println("Records Inserted Successfully.");

        for (Student s : db) {
            if (s.rollno == 101) {
                s.marks = 95;
                break;
            }
        }
        System.out.println("\nRecord Updated Successfully.");

        for (Student s : db) {
            if (s.rollno == 101) {
                System.out.println("\nStudent Details\n");
                System.out.println("Roll No : " + s.rollno);
                System.out.println("Name : " + s.name);
                System.out.println("Department : " + s.department);
                System.out.println("Marks : " + s.marks);
                break;
            }
        }
        System.out.println("\nStudent Records");
        System.out.println(" ");
        System.out.printf("%-6s %-6s %-13s %-6s%n", "Roll", "Name", "Department", "Marks");
        System.out.println(" ");

        for (Student s : db) {
            System.out.printf("%-6d %-6s %-13s %-6d%n", s.rollno, s.name, s.department, s.marks);
        }
    }
}
