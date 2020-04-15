package ru.jjd.base.lesson11;

public class TstMessage {

    public static void main(String[] args) {
        //stack работает по принципу LIFO
        //стэк только для методов и локальных переменных, объекты, строки и тд хранятся в других областях памяти
        String data = "Срочное сообщение";
        int num = 10;

        printStart();

        Message message = new Message();
        message.setText(data);
        message.setCode(num);

    }

    private static void printStart(){
        System.out.println("START");
    }
}
