package ru.jjd.base.lesson6;

public class Library {
    //библиотека:
    //можно добавлять книги по одной или несколько сразу
    //можно взять книгу(указав автора)
    // домой/ для чтения в библиотеке
    private String name = "Библиотека";//свойство по умолчанию, вместо null будет "Библиотека"
    private Book[] books = new Book[5];

    public String getName() {
        return name;
    }

    //Добавление одной книги
    public void addBook(Book newBook){
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null){
                books[i] = newBook;
                books[i].setInLibrary(true);
                break;//return
            }
        }
    }

    //Добавление нескольких книг

    public void addbook(Book ...newBooks){//три точки - переменное количество аргументов
        //newBooks - это массив, сколько книг в него передали, столько книг в нем и будет
        int booksCount = 0;
        for (Book book: books) {
            if (book != null){
                booksCount++;
            }
        }
        booksCount += newBooks.length;
        if (booksCount > books.length){
            Book[] tempArr = books.clone();
            books = new Book[booksCount];
            int j = 0;
            for (int i = 0; i < tempArr.length; i++) {
                if (tempArr[i] != null){
                    books[j++] = tempArr[i];
                }
            }
            for (int i = 0; i < newBooks.length; i++) {
                books[j] = newBooks[i];
                books[j++].setInLibrary(true);
            }
        } else {
            for (int i = 0, j = 0; j < newBooks.length; i++) {
                if (books[i] == null){
                    books[i] = newBooks[j++];
                    books[i].setInLibrary(true);
                }
            }
        }
    }

    public Book getHome(String title){
        for (int i = 0; i < books.length; i++) {
            if (title != null && title.equals(books[i].getTitle()) &&
                    books[i].isForHome() && books[i].isInLibrary()){
                books[i].setInLibrary(false);
                return books[i];
            }
        }
        return null;
    }
}
