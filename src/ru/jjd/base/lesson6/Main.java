package ru.jjd.base.lesson6;

public class Main {
    //библиотека:
        //можно добавлять книги по одной или несколько сразу
        //можно взять книгу(указав автора)
        // домой/ для чтения в библиотеке
    //книги:
        //название;
        //количество страниц;
        //автор(имя фамилия);
        //можно ли брать домой;
        //доступна ли для выдачи;

    //класс - шаблон будущих объектов

    public static void main(String[] args) {
        Author author1 = new Author();//вызов конструктора
        //author1.name = "Брюс"; - когда name не был private
        //System.out.println(author1.name);
        Author author2 = new Author();
        //author2.name = "Роберт";
        //System.out.println(author2.name);
        author1.setName("Брюс");
        author1.setSurname("Эккель");
        author2.setName("Роберт");
        author2.setSurname("Мартин");
        System.out.println(author1.getName());
        String name = author2.getName();
        System.out.println(name);
        System.out.println(author2.toString());
        Book book1 = new Book("Философия Java");
        book1.setPageCount(1350);
        book1.setAuthor(author1);
        book1.setForHome(true);
        System.out.println(book1);
        /*Значения по умолчанию: ссылочные типы - null, целые - 0, с плавающей точкой 0,0, boolean - false*/
        Book book2 = new Book("Чистый код", 500);
        book2.setAuthor(author2);
        System.out.println(book2);

        String book1Authotname = book1.getAuthor().getName();
        System.out.println(book1Authotname);

        Book[] books = {book1, book2};
        for (Book book: books) {
            System.out.println(book.getAuthor().getSurname());
        }

        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i].getAuthor().getSurname());
        }

        Library library = new Library();
        library.addbook(book1, book2);
        library.addbook(book1, book2, book1, book1, book2, book1);
        library.addbook(book2);
    }

}
