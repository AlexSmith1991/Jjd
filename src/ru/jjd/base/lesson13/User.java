package ru.jjd.base.lesson13;
//в <> необходимо указать что в классе будет использоваться generic тип
//вместо T может быть любая буква или сочетание букв, если одна буква - большая, если несколько, то как имя класса
//обычно или заглавная буква, или две буквы
public class User<T> {//класс User + геттеры + сеттеры + toString
    //если нужно использовать generic типы, то после имени класса ставится generic тип
    //если нужна возможность определить тип данных поля в момент создания объекта, то используем generic тип
    //

    //private int id;
    private T id;
    private String login;
    private String pwd;

    public T getId() {
        return id;
    }

    public void setId(T id) {//изначальный тип во всех методах надо будет поменять на T
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
