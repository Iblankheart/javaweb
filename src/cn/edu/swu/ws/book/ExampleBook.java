package cn.edu.swu.ws.book;

public class ExampleBook {
    public static void main(String[] args) {
        Book b1 = new Book("Thinking in Java","Bruce Eckel",1129);
        Book b2 = new Book("Thinking in Java","Bruce Eckel",1129);

        if ( b1.equals(b2) ) {
            System.out.println("The two books are the same");
        } else {
            System.out.println("The two books are different");
        }

        System.out.println(MathTools.PI);
        System.out.println(MathTools.area(4));

    }
}
