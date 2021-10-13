package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;

public class Card implements Serializable{
    private String codeCard;
    private LocalDate dateOfOrder;
    private LocalDate deadLine;
    private String codeBook;
    private Student student;
    private static boolean status=false;

    public Card() {
    }

    public Card(String codeCard, LocalDate dateOfOrder, LocalDate Deadline, String codeBook, Student student) {
        this.codeCard = codeCard;
        this.dateOfOrder = dateOfOrder;
        this.deadLine = Deadline;
        this.codeBook = codeBook;
        this.student = student;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCodeCard() {
        return codeCard;
    }

    public void setCodeCard(String codeCard) {
        this.codeCard = codeCard;
    }

    public LocalDate getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(LocalDate dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(LocalDate deadLine) {
        this.deadLine = deadLine;
    }

    public String getCodeBook() {
        return codeBook;
    }

    public void setCodeBook(String codeBook) {
        this.codeBook = codeBook;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Card{" +
                "codeCard='" + codeCard + '\'' +
                ", dateOfOrder=" + dateOfOrder +
                ", dateOfGiveBackDeadline=" + deadLine +
                ", codeBook='" + codeBook + '\'' +
                   student+
                ", status=" + status +
                '}';
    }
}
