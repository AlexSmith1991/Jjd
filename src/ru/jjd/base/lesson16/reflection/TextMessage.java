package ru.jjd.base.lesson16.reflection;

import java.io.Serializable;

public class TextMessage extends Message implements Serializable {
    private String text;

    public TextMessage(String title) {
        super(title);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    private void printText(String prefix, String postfix){
        System.out.println(prefix + " " + text + postfix);
    }

}
