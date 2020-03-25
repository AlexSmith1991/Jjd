package ru.jjd.base.lesson9;

public class TstBook {
    //у всех классов есть общий родительский класс - object
    public static void main(String[] args) throws CloneNotSupportedException {
        Object obj = new Object();//родительский класс для всех java классов
        //соответственно его методы доступны для использования и переопределения в дочерних классах

        //Методы класса Object
        //1. toString() - возвращает строковое представление объекта, по умолчанию возвращает хэш-код
        Author author = new Author();
        author.setName("Иван");
        author.setSurname("Григорьев");

        ChildBook book1 = new ChildBook(new String[] {"dog", "cat"});
        book1.setTitle("Детская книга");
        book1.setPageCount(230);
        book1.setAuthor(author);

        String stringBook = book1.toString();
        System.out.println(stringBook);//вернет имя класса + @ + хэш-код объекта

        //2. equals(Object other) - используется для сравнения объектов
        //3. hashCode() - возвращает hash code объекта

        ChildBook book2 = new ChildBook(new String[] {"dog", "cat"});
        book2.setTitle("книга");
        book2.setPageCount(230);
        book2.setAuthor(author);

        boolean equalsBooks = book1.equals(book2);
        System.out.println(equalsBooks);//по умолчанию сравнивает ссылки, выдаст true только если это две ссылки
        // на один объект
        System.out.println(book1.hashCode());//изначально hash code - уникальный адрес объекта в памяти, но не факт
        //зависит от виртуальной машины, коды для разных объектов могут быть одинаковыми
        //Для строк метод equals уже определен и hashCode тоже

        //4. clone() - для создания копии объекта
        //ChildBook cloneBook = book1;//не копирование объекта, ссылка на тот же самый объект
        ChildBook cloneBook = book1.clone();
        //вариант 1 - использовать базовую реализацию:
        //класс должен реализовать интерфейс cloneable
        //можно расширить модификатор доступа до public
        //метод clone() в базовой реализации возвращает тип Object
        //нужно изменить тип возвращаемого значения и добавить приведение например (ChildBook) super.clone()
        //при клонировании вложенные объекты не копируются, две книги будут ссылаться на одного автора

        //вариант 2 - без использования базовой реализации:
        //класс не обязан реализовать интерфейс Cloneable
        //необходимо написать свою реализацию по созданию копии объекта(не пишем super.clone)
        //
        System.out.println(cloneBook.clone());

    }
}
