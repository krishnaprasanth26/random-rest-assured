package testdatapart13.complex1;

import java.util.List;

public class Example {

    private String isbn;
    private String title;
    private List<Author> author;
    private List<Editor> editor;
    private List<String> category;

    public Example(String isbn, String title, List<Author> author, List<Editor> editor, List<String> category) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.editor = editor;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public List<Editor> getEditor() {
        return editor;
    }

    public void setEditor(List<Editor> editor) {
        this.editor = editor;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}