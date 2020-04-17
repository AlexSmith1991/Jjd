package ru.jjd.base.lesson13.lst;

public class TstLinkedList {
    public static void main(String[] args) {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("23");
        list.add("12qwe");

        System.out.println(list.get(1));

    }
}
