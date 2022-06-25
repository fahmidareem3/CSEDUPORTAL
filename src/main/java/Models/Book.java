package Models;

public class Book implements BookInterface {
    private String BookName;
    private String AuthorName;
    public Book() {

    }
    public Book(String BookName, String AuthorName) {
        this.BookName = BookName;
        this.AuthorName = AuthorName;
    }

    @Override
    public void setBookName(String BookName) {
        this.BookName = BookName;
    }

    @Override
    public void setAuthorName(String Authorname) {
        this.AuthorName = Authorname;

    }

    @Override
    public String getBookName() {
        return this.BookName;
    }

    @Override
    public String getAuthorName() {
        return this.AuthorName;
    }


}
