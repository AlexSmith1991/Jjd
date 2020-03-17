package ru.jjd.base.lesson6;

public class Author {
    //свойства
    private String name;
    private String surname;
    //private - обеспечивает доступ к переменной только внутри класса
    //автоматическое создание методов - alt + insert

    //методы
    //конструкторы

    //геттеры и сеттеры
    public void setName(String name) {//setter
        //public - обеспечивает доступ отовсюду, самый открытый модификатор доступа
        //void - ничего не возвращает, return; тоже можно использовать для прерывания метода
        if (name.length() >= 2){// !"".equals(name) - проверка на пустоту
            //name != null - проверка на то что на вход было подано
            this.name = name;//this - текущий объект, из которого был вызван метод
            //String someVar;
            //someVar.equals("java");
            //"java".equals(someVar);//правильно делать так, надо начинать со строки которая точно есть
        }
    }

    public String getName() {//getter - возвращает значение свойства
        return name;// все что написано после return - выполняться не будет
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
