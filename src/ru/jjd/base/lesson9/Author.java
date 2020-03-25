package ru.jjd.base.lesson9;

import java.util.Objects;

public class Author implements Cloneable{
    //private String name;//только внутри класса(между фигурными скобками)
    //protected String name;//внутри класса, внутри дочерних классов и внутри пакета
    //дефолтное свойство - package private
    private String name;
    private String surname;

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(name, author.name) &&
                Objects.equals(surname, author.surname);
    }

    @Override
    public Author clone() throws CloneNotSupportedException {
        return (Author) super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}
