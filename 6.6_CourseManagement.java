package Lab06.training.main;

import Lab06.training.entities.Course;
import java.util.stream.Collectors;
import org.w3c.dom.ls.LSException;

import java.util.*;

public class CourseManagement {
    private static final Scanner SCANER = new Scanner(System.in);
    private static final ArrayList<Course> courses = new ArrayList<>();
    private static final HashSet<String> codeSet = new HashSet<>();
    private static final HashMap<String, Course> courseMap = new HashMap<>();

    public static void main(String[] args) {
        int choice = -1;

        do {
            System.out.println("\n====== COURSE MANAGEMENT ======");
            System.out.println("1. Create a course");
            System.out.println("2. Search courses by attribute");
            System.out.println("3. Display courses by flag");
            System.out.println("0. Quit");
            System.out.println("Enter your choice: ");

            try{
                choice = Integer.parseInt(SCANER.nextLine().trim());
            }catch (NumberFormatException e){
                choice = -1;
            }

            switch (choice){
                case 1 -> {
                    System.out.println("------- Add new course ---------");
                    try {
                        System.out.print("Enter course code (RAxxx): ");
                        String code = SCANER.nextLine().trim().toUpperCase();
                        if (!code.matches("^RA\\d{3}$")) {
                            throw new IllegalArgumentException("Pattern must be RAxxx.");
                        }
                        if (codeSet.contains(code)) {
                            throw new IllegalArgumentException("Code already exists.");
                        }

                        System.out.print("Enter name: ");
                        String name = SCANER.nextLine().trim();
                        if (name.isEmpty()) {
                            throw new IllegalArgumentException("Name cannot be empty.");
                        }

                        System.out.print("Enter status (true/false): ");
                        String statusStr = SCANER.nextLine().trim().toLowerCase();
                        if (!statusStr.equals("true") && !statusStr.equals("false")) {
                            throw new IllegalArgumentException("Status must be true or false.");
                        }
                        boolean status = Boolean.parseBoolean(statusStr);

                        System.out.print("Enter duration (>0): ");
                        short duration = Short.parseShort(SCANER.nextLine().trim());
                        if (duration <= 0) {
                            throw new IllegalArgumentException("Duration must be greater than 0.");
                        }

                        System.out.print("Enter flag (optional/prerequisite/N/A): ");
                        String flag = SCANER.nextLine().trim();
                        if (!flag.equalsIgnoreCase("optional") &&
                                !flag.equalsIgnoreCase("prerequisite") &&
                                !flag.equalsIgnoreCase("N/A") && !flag.equalsIgnoreCase("n/a")) {
                            throw new IllegalArgumentException("Invalid flag.");
                        }

                        // Chuẩn hóa flag
                        flag = flag.equalsIgnoreCase("n/a") ? "N/A" : flag.toLowerCase();

                        // Khởi tạo và thêm vào cả 3 cấu trúc dữ liệu
                        Course newCourse = new Course(code, name, status, duration, flag);
                        courses.add(newCourse);
                        codeSet.add(code);
                        courseMap.put(code, newCourse);

                        System.out.println("Course created successfully!");

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Duration must be a valid number.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }

                case 2 -> {
                    System.out.println("------- Search courses ---------");
                    try {
                        System.out.print("Search by (code/name/status/duration/flag): ");
                        String type = SCANER.nextLine().trim().toLowerCase();

                        System.out.print("Enter value to search: ");
                        String data = SCANER.nextLine().trim();

                        // Biến result lưu kết quả tìm kiếm
                        List<Course> result = switch (type) {
                            case "code" -> {
                                Course found = courseMap.get(data.toUpperCase());
                                yield found != null ? List.of(found) : new ArrayList<>();
                            }
                            case "name" -> courses.stream()
                                    .filter(c -> c.getName().toLowerCase().contains(data.toLowerCase()))
                                    .sorted(Comparator.comparing(Course::getName))
                                    .collect(Collectors.toList());
                            case "status" -> {
                                boolean wanted = data.equalsIgnoreCase("true") || data.equalsIgnoreCase("active");
                                yield courses.stream()
                                        .filter(c -> c.isStatus() == wanted)
                                        .collect(Collectors.toList());
                            }
                            case "duration" -> {
                                short dd = Short.parseShort(data);
                                yield courses.stream()
                                        .filter(c -> c.getDuration() == dd)
                                        .collect(Collectors.toList());
                            }
                            case "flag" -> {
                                Map<String, List<Course>> mapByFlag = courses.stream()
                                        .collect(Collectors.groupingBy(c -> c.getFlag().toLowerCase()));
                                yield mapByFlag.getOrDefault(data.toLowerCase(), new ArrayList<>());
                            }
                            default -> throw new IllegalArgumentException("Unsupported attribute.");
                        };

                        // In kết quả
                        if (result.isEmpty()) {
                            System.out.println("No data.");
                        } else {
                            System.out.printf("%-6s | %-20s | %-6s | %-8s | %-12s%n", "CODE", "NAME", "STATUS", "DURATION", "FLAG");
                            for (Course c : result) {
                                System.out.println(c.toString());
                            }
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Error: Value must be a valid number for duration.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case 3 -> {
                    System.out.println("------- Display courses by flag ---------");
                    System.out.print("Enter flag to display (optional/prerequisite/N/A): ");
                    String flag = SCANER.nextLine().trim();

                    List<Course> result = courses.stream()
                            .filter(c -> c.getFlag().equalsIgnoreCase(flag))
                            .collect(Collectors.toList());

                    if (result.isEmpty()) {
                        System.out.println("No data.");
                    } else {
                        System.out.printf("%-6s | %-20s | %-6s | %-8s | %-12s%n", "CODE", "NAME", "STATUS", "DURATION", "FLAG");
                        for (Course c : result) {
                            System.out.println(c.toString());
                        }
                    }
                }

                case 0 -> {
                    System.out.println("Exiting the program. Goodbye!");
                }

                default -> {
                    System.out.println("Invalid choice. Please select 0-3.");
                }
            }

        } while (choice != 0);
    }
}
