package ru.jjd.base.lesson6;

public class Book {
    //название;
    //количество страниц;
    //автор(имя фамилия);
    //можно ли брать домой;
    //доступна ли для выдачи;
    private String title;
    private int pageCount;
    private Author author;
    private boolean isForHome;//при формировании булевых свойств принято начинать с is
    private boolean isInLibrary;

    public Book() {}

    public Book(String title) {//Если описан хоть один конструктор с параметров, то конструктор без параметров
        //уже недоступен, только если самостоятельно его описать,
        //два конструктора для полей одинакового типа создать нельзя, должен быть уникальный набор типов
        this.title = title;
    }

    public Book(String title, int pageCount) {
        this.title = title;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public boolean isForHome() {
        return isForHome;
    }

    public void setForHome(boolean forHome) {
        isForHome = forHome;
    }

    public boolean isInLibrary() {
        return isInLibrary;
    }

    public void setInLibrary(boolean inLibrary) {
        isInLibrary = inLibrary;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                ", isForHome=" + isForHome +
                ", isInLibrary=" + isInLibrary +
                '}';
    }
}
