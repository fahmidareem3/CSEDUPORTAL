package Models;

public class CourseBook {
    private String BookName;

    public CourseBook(String bookName, String authorName, String courseCode) {
        BookName = bookName;
        AuthorName = authorName;
        CourseCode = courseCode;
    }

    public String getCourseCode() {
        return CourseCode;
    }

    public void setCourseCode(String courseCode) {
        CourseCode = courseCode;
    }

    private String AuthorName;
    private String CourseCode;

    public CourseBook(String bookName, String authorName) {
        BookName = bookName;
        AuthorName = authorName;
    }

    public String getBookName() {
        return BookName;
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public String getAuthorName() {
        return AuthorName;
    }

    public void setAuthorName(String authorName) {
        AuthorName = authorName;
    }
}
