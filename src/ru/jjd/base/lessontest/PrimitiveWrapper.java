package ru.jjd.base.lessontest;

import org.w3c.dom.ls.LSOutput;

public class PrimitiveWrapper {
    public static void main(String[] args) {
        //примитивные типы данных:
        //byte/short/int/long/float/double/boolean/char

        //для каждого примитива существует класс-обертка
        //для byte - класс-обертка Byte
        //short - Short
        //int - Integer
        //long - Long
        //float - Float
        //double - Dounble
        //char - Character
        //boolean - Boolean

        //всегда где возможно нужно использовать примитивы, это экономия памяти, за исключением случаев:
        //1. когда использование примитивов невозможно
        //2. когда необходимо воспользоваться методами классов-оберток

        int count = 267;//создали переменную примитивного типа
        //Integer age = new Integer(200);//через new создавать экземпляры классов-оберток не принято
        //принято использовать вариант:
        Integer age = 200;//создали объект типа Integer

        //автораспаковка и автоупаковка
        //автоупаковка - переменной класса-обертки присваивается значение примитива
        Integer num = 12;// = count;
        //автораспаковка - наоборот, когда переменной примитивного типа передается значение из экземпляра класса-обертки
        double price;
        Double someDouble = 45.12;//автоупаковка
        price = someDouble;//автораспаковка

        //некоторые правила автоупаковки и автораспаковки:
        //1. автоупаковка примитивов требует точного соответствия классу-обертке
        byte one = 1;
        //num = one; - выдает ошибку, автоупаковка не работает, потому что разные типы
        num = (int) one;//автоупаковка работает
        //num = (Integer) one;//автоупаковка также не работает, надо приводить к примитивному типу
        //на автораспаковку это правило не распространяется
        Byte two = 2;
        int num2 = two;
        //instanceof работает только на обертку
        //классы-обертки можно приводить друг к другу так же как и примитивы

        Integer a = 23;
        Byte b = 12;
        //b = (Byte) a; - такой вариант не используется
        //a = (Integer) b

        //2. параметры методов подлежат правилам автоупаковки и автораспаковки
        //если метод принимает значение класса-обертки а туда передается примитив, это нормально сработает

        //создать приватный статический метод, который принимает на вход число типа Integer и выводит в консоль
        //значение этого элемента в квадрате

        sqrDisplay(a);

        int c = 4;
        sqrDisplay(c);

        //3. автоупаковка и автораспаковка не работают с массивами
        //создати приватный статический метод, который принимает на вход массив типа Double[] и выводит в консоль каждый
        //его элемент

        double[] doubles = {3.56, 76.86, 34.65, 32.12};
        //displayArray(doubles); - так работать не будет, примитивы в массиве не упауются

        //Некоторые методы оберток над примитивами
        //методы, возвращающие byte, int, long и т.д.
        //только для дочерних от number
        //методы возвращают примитивы
        //num.byteValue();
        //num.floatValue();
        //num.doubleValue();
        //num.longValue();
        //num.intValue();
        //методы преобразования строки с числом к числу
        //метод parseXXX(строка с числом); все методы с началом parse возвращают примитив
        //метод valueOf(строка с числом); возвращают объект

        System.out.println(Byte.parseByte("2"));//byte
        System.out.println(Byte.valueOf("2"));//объект типа Byte

        System.out.println(Integer.parseInt("34"));//int
        System.out.println(Integer.valueOf("34"));// объект типа Integer

        //System.out.println(Integer.parseInt("2 sfdg gf"));//number format exception,
        // если строка содержит не только число
        // разделитель разрядов - точка

        //сравнение целочисленных значений(Integer)
        //сравнение всегда через equals или compareTo
        //значения в диапазоне [-128;127]
        Integer first = 45;
        Integer second = 45;//как со строками, создается кэш для чисел
        System.out.println("45 == 45: " + (first == second));//true, но сравнивали мы объекты
        //сравниваются объекты, раз true - значит ссылка на один и тот же объект

        Integer fourth = 155;
        Integer fifth = 155;

        System.out.println("155 == 155: " + (fourth == fifth));//false значения вне [-128;127] не кэшируются
        //диапазон может быть увеличен при запуске программы, правило справедливо для всех целочисленных значений
        // == с объектами - всегда сравнение ссылок

        Integer someInt = 12;//кэшируется
        Integer someInt2 = 12;//берется тот же самый объект

        System.out.println(someInt.compareTo(someInt2));//метод не статический, значит должен быть созданный объект
        System.out.println(Integer.compare(someInt, someInt2));//вызывается внутри compareTo

        System.out.println(fourth.equals(fifth));//true

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Double.NEGATIVE_INFINITY);
        System.out.println(Double.TYPE);

    }

    private static void sqrDisplay (Integer number){
        System.out.println(number * number);
    }

    private static void displayArray(Double[] doubles){
        for (int i = 0; i < doubles.length; i++) {
            System.out.println(doubles[i]);
        }
    }
}
