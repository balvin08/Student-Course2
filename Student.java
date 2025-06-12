import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Student {
    private String name;
    private LocalDate dob;
    private int age;

    public Student(String name, String dob) {
        this.name = name;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            this.dob = LocalDate.parse(dob, formatter);
            this.age = calculateAge();
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use dd-MM-yyyy.");
        }
    }

    private int calculateAge() {
        return Period.between(dob, LocalDate.now()).getYears();
    }

    public void displayStudentDetails() {
        if (dob != null) {
            System.out.println("Name: " + name);
            System.out.println("Date of Birth: " + dob.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
            System.out.println("Age: " + age);
        } else {
            System.out.println("Student details are incomplete due to invalid DOB.");
        }
    }

    public static void main(String[] args) {
        Student student = new Student("Alice", "15-08-2002");
        student.displayStudentDetails();
    }
}
