package model;

import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    public static Scanner scanner = new Scanner(System.in);
    private String name;
    private String codeStudent;
    private String classRoom;

    public Student(String name, String code, String classRoom) {
        this.name = name;
        this.codeStudent = code;
        this.classRoom = classRoom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", codeStudent='" + codeStudent + '\'' +
                ", classRoom='" + classRoom + '\'' +
                '}';
    }
}
