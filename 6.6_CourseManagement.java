package Lab06.training.main;

import Lab06.training.entities.Course;
import java.util.stream.Collectors;

import Lab06.training.utils.Constants;
import Lab06.training.utils.ScannerUtil;
import Lab06.training.utils.Validator;

import java.util.*;

public class CourseManagement {
    private final ArrayList<Course> courses = new ArrayList<>();

    public static void main(String[] args) {
        new CourseManagement().run();
    }
    private void run(){
        while(true){
            showMenu();
            int choice = ScannerUtil.readMenuChoice();
            switch (choice){
                case Constants.MENU_CREATE -> createCourse();
                case Constants.MENU_SEARCH -> searchCourses();
                case Constants.MENU_DISPLAY_BY_FLAG -> displayByFlag();
                case Constants.MENU_QUIT -> {
                    System.out.println("Bye!");
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private void showMenu(){
        System.out.println("\n========= COURSE MANAGEMENT ========");
        System.out.println("1. Create a course");
        System.out.println("2. Search courses by attribute");
        System.out.println("3. Display courese by flag");
        System.out.println("0. Quit");
    }

    private void createCourse(){
        String code = readValidCode();
        String name = ScannerUtil.readNonempty("Enter name: ");
        boolean status = ScannerUtil.readBoolean("Enter status ");
        short duration = ScannerUtil.readPositiveShort("Enter duration (>0): ");
        String flag = readValidFlag();

        courses.add(new Course(code, name, status, duration, flag));
        System.out.println("Course created!");
    }

    private String readValidCode(){
        while (true){
            String code = ScannerUtil.readNonempty("Enter course code (RAxxx): ");

            if(!Validator.validateCode((code))){
                System.out.println("Pattern must be RAxxx");
                continue;
            }
            if(Validator.isDuplicatedCode(code,courses)){
                System.out.println("Code already exists.");
                continue;
            }
            return code;
        }
    }
    private String readValidFlag(){
        while (true){
            String flag = ScannerUtil.readNonempty("Enter flag (optional/prerequisite/N/A): ");

            if(Validator.validateFlag(flag))  return flag.equalsIgnoreCase("n/a") ? "N/A" : flag.toLowerCase(Locale.ROOT);
            System.out.println("Invalid flag.");
        }
    }

    private void searchCourses(){
        String type = ScannerUtil.readNonempty("Search by (codee/name/status/duration/flag): ").toLowerCase(Locale.ROOT);
        String data = ScannerUtil.readNonempty("Enter value to search: ");
        var result = switch (type){
            case "code" -> courses.stream().filter(c-> c.getCode().equalsIgnoreCase(data)).collect(Collectors.toList());
            case "name" -> courses.stream().filter(c -> c.getName().
                    toLowerCase(Locale.ROOT).contains(data.toLowerCase(Locale.ROOT))).
                    sorted(Comparator.comparing(Course::getName)).
                    collect(Collectors.toList());
            case "status" -> {
                boolean wanted = "true".equalsIgnoreCase(data) || "active".equalsIgnoreCase(data);
                yield courses.stream().filter(c-> c.isStatus() == wanted).collect(Collectors.toList());
            }
            case "duration" ->{
                short d;
                try{
                    d = Short.parseShort(data);
                }catch (NumberFormatException e){
                    d = -1;
                }

                short dd = d;
                yield courses.stream().filter(c -> c.getDuration() == dd).collect(Collectors.toList());
            }
            case "flag" -> courses.stream().filter(c->c.getFlag().equalsIgnoreCase(data)).collect(Collectors.toList());
            default -> {
                System.out.println("Unsupported attribute.");
                yield new ArrayList<Course>();
            }
        };
        printCourses(result);
    }

    private void displayByFlag(){
        String flag = readValidFlag();
        var result = courses.stream().filter(c->c.getFlag().equalsIgnoreCase(flag)).collect(Collectors.toList());
        printCourses(result);
    }

    private void printCourses(java.util.List<Course> list){
        if(list.isEmpty()){
            System.out.println("No data.");
            return;
        }
        System.out.println(Constants.TABLE_HEADER);
        list.forEach(c-> System.out.println(c.toString()));
    }
}











