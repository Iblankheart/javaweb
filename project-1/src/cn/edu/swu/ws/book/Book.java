package cn.edu.swu.ws.book;

public class Book {
    String title;
    String author;
    int numberOfPages;
    static String owner;

    Book(){
    }

    Book(String title, String author, int numberOfPages) {
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
    }

    public void setOwner(String owner) {
        Book.owner = owner;
    }

    public String getOwner() {
        return Book.owner;
    }

    public String getInitials() {
        String initials = "";
        for (int i=0; i<this.author.length(); i++) {
            char c = this.author.charAt(i);
            if (c >= 'A' && c<= 'Z') {
                initials += c + ".";
            }
        }
        return initials;
    }

    public boolean equals(Book b) {
        boolean result =
                this.title.equals(b.title) &&
                this.author.equals(b.author) &&
                this.numberOfPages == b.numberOfPages;
        System.out.println(result);
        return result;
    }

}
