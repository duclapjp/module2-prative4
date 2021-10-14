package controller;


import model.Card;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager {
    private static List<Card> cards = new ArrayList<>();
    public Manager() {
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
        writeFile();
    }

    public List<Card> getCards() {
        return cards;
    }

    public void writeFile(){
        try {
            OutputStream os = new FileOutputStream(new File("book.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(cards);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public List<Card> readFile() throws  IOException{
       File file = new File("book.txt");
       List<Card> cards = new ArrayList<>();
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length()==0) return cards;
        try {
            InputStream ips = new FileInputStream("book.txt");
            ObjectInputStream ois = new ObjectInputStream(ips);
            cards = (List<Card>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cards;
    }

    public void addCard(Card card) {
        cards.add(card);
        writeFile();
    }
    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public void deleteCard(int index) {
        cards.remove(index);
        writeFile();
    }

    public void editCard(int index, Card card) {
        cards.set(index, card);
        writeFile();
    }
    public void showAll() {
        for (Card card : cards) {
            System.out.println(card.toString());
        }
    }
    public int getIndexByCodeCard(String codeCard){
        int index=0;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getCodeCard().equals(codeCard)){
                index=i;
            }
        }
        return index;
    }
    public void seachBycodeCard(String codeCard){
        boolean check = true;
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getCodeCard().equals(codeCard)){
                check = false;
                if (cards.get(i).getDeadLine().isAfter(LocalDate.now())){
                    System.out.println(cards.get(i).toString());
                    break;
                }
                System.out.println("đã quá hạn trả sách");
                System.out.println(cards.get(i).toString());
            }
            }
        if (check) {
            System.out.println("không tìm thấy");
        }
    }

    public void giveBackBook(String codeStudent){
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i).getStudent().getCodeStudent().equals(codeStudent)){
                if (cards.get(i).getDeadLine().isAfter(LocalDate.now())){
                    cards.get(i).setStatus(true);
                    System.out.println("cảm ơn bạn đã trả đúng hạn");
                    break;
                }else {
                    System.out.println("Xin vui lòng nộp phí quá hạn trả sách");
                    break;
                }
            }else {
                System.out.println("không tìm thấy sinh viên");
            }
        }
        writeFile();
    }

}
