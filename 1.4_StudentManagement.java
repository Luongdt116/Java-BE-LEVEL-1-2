import java.util.Scanner;

public class StudentManagement {
    private static final int MAX_STUDENTS = 100;
    private static Student[] listStudents = new Student[MAX_STUDENTS];
    private static int count = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Choose an option (1-5): ");
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                choice = -1;
            }

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    displayAll();
                    break;
                case 3:
                    System.out.println("\n--- Find Student By ID ---");
                    System.out.print("Enter ID to search: ");
                    String searchId = scanner.nextLine().trim();

                    findIndexById(searchId);
                    break;
                case 4:
                    System.out.println("\n--- Update Student Information ---");
                    System.out.print("Enter ID of student to update: ");
                    String updateId = scanner.nextLine().trim();

                    updateStudentById(updateId);
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option! Please select between 1 and 5.\n");
            }
        } while (choice != 5);
    }

    private static void printMenu() {
        System.out.println("=================================");
        System.out.println("      STUDENT MANAGEMENT MENU    ");
        System.out.println("=================================");
        System.out.println("1. Create a student");
        System.out.println("2. Display all");
        System.out.println("3. Find a student by id");
        System.out.println("4. Update a student by id");
        System.out.println("5. Quit");
        System.out.println("=================================");
    }

    private static Student inputStudent(String id) {
        String name = inputValidName();
        int age = inputValidAge();
        System.out.print("Enter Address: ");
        String address = scanner.nextLine().trim();
        String gender = inputValidGender();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        return new Student(id, name, age, address, gender, email);
    }
    // 1. Create a student
    private static void createStudent() {
        if (count >= MAX_STUDENTS) {
            System.out.println("Cannot add student. Array is full (max 100 students)!\n");
            return;
        }

        String id;
        while (true) {
            System.out.print("Enter ID: ");
            id = scanner.nextLine().trim();
            if (id.isEmpty()) {
                System.out.println("Error: ID cannot be empty!");
            } else if (findIndexById(id) != -1) {
                System.out.println("Error: ID already exists! Please enter a unique ID.");
            } else {
                break;
            }
        }
        listStudents[count] = inputStudent(id);
        count++;
        System.out.println("Student created successfully!\n");
    }

    // 2. Display all
    private static void displayAll() {
        System.out.println("\n--- Student List ---");
        if (count == 0) {
            System.out.println("No students found in the system.\n");
            return;
        }
        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + listStudents[i]);
        }
        System.out.println();
    }

    // 3. Find a student by id
    private static void findStudentById(String id) {
        int index = findIndexById(id);
        if (index != -1) {
            System.out.println("Student found:");
            System.out.println(listStudents[index] + "\n");
        } else {
            System.out.println("Student with ID '" + id + "' not found!\n");
        }
    }

    // find a student by id
    public static int findIndexById(String id){
        if(id == null){
            return -1;
        }
        for (int i=0; i < count; i++){
            if(listStudents[i] != null && listStudents[i].getId() != null && listStudents[i].getId().equalsIgnoreCase(id)){
                return i;
            }
        }
        return -1;
    }
    // . Update a student by id
    private static void updateStudentById(String id) {
        int index = findIndexById(id);
        if (index == -1) {
            System.out.println("Student with ID '" + id + "' not found!\n");
            return;
        }

        System.out.println("Updating student: " + id);
        listStudents[index] = inputStudent(id);
        System.out.println("Student information updated successfully!\n");
    }


    // Input Validation Helpers
    private static String inputValidName() {
        String name;
        while (true) {
            System.out.print("Enter Name: ");
            name = scanner.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("Error: Name cannot be empty!");
            } else {
                return name;
            }
        }
    }

    private static int inputValidAge() {
        int age;
        while (true) {
            System.out.print("Enter Age (>= 18): ");
            try {
                age = Integer.parseInt(scanner.nextLine().trim());
                if (age >= 18) {
                    return age;
                } else {
                    System.out.println("Error: Age must be >= 18!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format for age!");
            }
        }
    }

    private static String inputValidGender() {
        String gender;
        while (true) {
            System.out.print("Enter Gender (male/female): ");
            gender = scanner.nextLine().trim();
            if (gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female")) {
                return gender.substring(0, 1).toUpperCase() + gender.substring(1).toLowerCase();
            } else {
                System.out.println("Error: Gender must be 'male' or 'female'!");
            }
        }
    }
}
