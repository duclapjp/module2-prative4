package view;

import controller.Manager;
import model.Card;
import model.Student;


import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class MainManager {
    private static Student student;
    private static Card card;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        Manager duclap = new Manager();
        List<Card> cards = duclap.readFile();
        duclap.setCards(cards);
    boolean check = true;
    while (check){
        System.out.println("chọn chức năng");
        System.out.println("-----MENU-----");
        System.out.println("1:Thêm mới");
        System.out.println("2:Sửa");
        System.out.println("3:Xóa");
        System.out.println("4:Trả sách");
        System.out.println("5:Tìm kiếm");
        System.out.println("6:Hiển thị danh sách");
        System.out.println("7:Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                duclap.addCard(creatCard());
                duclap.showAll();
                break;
            case 2:
                System.out.println("nhập vào mã thẻ");
                String codeCard = scanner.nextLine();
                int index = duclap.getIndexByCodeCard(codeCard);
                duclap.editCard(index,creatCard());
                duclap.showAll();
                break;
            case 3:
                System.out.println("nhập vào mã thẻ");
                scanner.nextLine();
                String codeC= scanner.nextLine();
                int i = duclap.getIndexByCodeCard(codeC);
                duclap.deleteCard(i);
                duclap.showAll();
                break;
            case 4:
                System.out.println("nhập vào mã sinh viên");
                scanner.nextLine();
                String codeSt = scanner.nextLine();
                duclap.giveBackBook(codeSt);
                duclap.showAll();
                break;
            case 5:
                System.out.println("nhập vào mã thẻ");
                scanner.nextLine();
                String code = scanner.nextLine();
                duclap.seachBycodeCard(code);
                break;
            case 6:
                duclap.showAll();
                break;
            case 7:
                check = false;
                break;
        }
    }
    }
    public static Student creatStudent(){
        System.out.println("nhập vào tên sinh viên");
        scanner.nextLine();
        String name = scanner.nextLine();
        System.out.println("nhập vào mã sinh viên");
        String codeStudent = scanner.nextLine();
        System.out.println("nhập vào lớp");
        String classRoom = scanner.nextLine();
        Student student = new Student(name,codeStudent,classRoom);
        return student;
    }
    public static Card creatCard(){
        Student student = creatStudent();
        System.out.println("nhập vào mã thẻ");
        String codeCard = scanner.nextLine();
        System.out.println("nhập vào mã sách");
        String codeBook = scanner.nextLine();
        System.out.println("nhập vào ngày mượn");
        int day = scanner.nextInt();
        System.out.println("nhập vào tháng");
        int month = scanner.nextInt();
        System.out.println("nhập vào năm");
        int year = scanner.nextInt();
        LocalDate dateOfOrder = java.time.LocalDate.of(year,month,day);
        LocalDate dateOfDedLine = dateOfOrder.plusDays(15);
        Card card =  new Card(codeCard,dateOfOrder,dateOfDedLine,codeBook,student);
        return card;
    }
}