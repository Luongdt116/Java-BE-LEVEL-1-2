package Lab06.training.entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Course {
    private String code;
    private String name;
    private boolean status;
    private short duration;
    private String flag;
    public Scanner sc = new Scanner(System.in);

    public Course(){}

    public Course(String code, String name , boolean status, short duration, String flag) {
        this.code = code;
        this.duration = duration;
        this.flag = flag;
        this.name = name;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public short getDuration() {
        return duration;
    }

    public void setDurationl(short duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return  String.format("Course [Code: %-20s | name: %-6s | status: %-6b | duration: %-5d | flag: %-5s]",
                code, name, status ? "active":"in-active", duration, flag);
    }

}
