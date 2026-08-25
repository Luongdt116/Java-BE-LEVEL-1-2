package sales.client;
import sales.InputUtil;
import sales.entities.Employee;

import java.sql.Connection;
import java.util.Scanner;

public class EmployeeForm {
    private final Scanner sc;

    public EmployeeForm(Scanner sc) {
        this.sc = sc;
    }

    public int getId(){
        int id;

        System.out.println("Enter id: ");
        id = Integer.parseInt(sc.nextLine().trim());

        return id;
    }

    public Employee getEmployee(){
        Employee employee = new Employee();

        employee.setLastName(InputUtil.readStringWithLimit("Enter last name: ", 20));
        employee.setFirstName(InputUtil.readStringWithLimit("Enter first name: ", 20));
        employee.setBirthdate(InputUtil.readValidDate("Enter birthdate (YYYY-MM-DD): "));
        employee.setSupervisor(InputUtil.readInt("Enter supervisor ID (Enter 0 if none): "));

        return employee;
    }

}













