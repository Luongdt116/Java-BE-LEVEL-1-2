package sales;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtil {
    public static final Scanner sc = new Scanner(System.in);

    private InputUtil() {} // Chặn khởi tạo đối tượng

    // 1. Hàm nhập chuỗi có giới hạn độ dài
    public static String readStringWithLimit(String prompt, int maxLength) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (input.length() <= maxLength) {
                return input;
            }
            System.out.println("Lỗi: Dữ liệu quá dài! Tối đa cho phép là " + maxLength + " ký tự.");
        }
    }

    // 2. Hàm nhập ngày tháng chuẩn
    public static String readValidDate(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                LocalDate.parse(input);
                return input;
            } catch (DateTimeParseException e) {
                System.out.println("Lỗi: Định dạng ngày không hợp lệ. Vui lòng nhập đúng YYYY-MM-DD.");
            }
        }
    }

    // 3. Hàm nhập số nguyên (Dùng cho ID, Supervisor)
    public static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập một số nguyên.");
            }
        }
    }
}
