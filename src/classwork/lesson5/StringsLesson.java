package classwork.lesson5;

import java.util.Arrays;

public class StringsLesson {
    public static void main(String[] args) {
        //Строки - ссылочный тип данных, объекты, создаются на основе заранее описанного класса String
        //Строки до 9 Java, хранятся как массив char
        char charVar = 'e';
        String someStr = "jjd";//одинарные ковычки - char, двойные кавычки - String
        char[] chars = {'j', 'j', 'd'};
        //Кодировка UTF-16
        //Каждый символ занимает 2 байта

        //Строки (компактные строки) начиная с 9 Java
        //строки хранятся как массив byte[]
        //кодировка или UTF-16 или LATIN-1
        //какие-то символы занимают 1 байт, какие-то 2 байта
        //большинство методов определяют кодировку строки
        String string4 = "Some string";
        String string = "Some string";//наиболее предпочтительный способ, в области памяти существует пул строк, там
        //хранятся только уникальные строки, созданные таким способом хранятся в нем
        String string3 = new String("Some string");
        String string2 = new String("Some string");//Плохой способ, используется для сложных случаев, не для
        //текста в ковычках, в памяти выделяется облать под объект, если создается еще одна такая же строка, в памяти
        //создается отдельный объект

        //сравнение строк
        System.out.println(string == string4);//true
        System.out.println(string2 == string3);//false

        System.out.println(string2.equals(string3));//true, посимвольное сравнение

        String newString = new String("new");
        String newString2 = newString.intern();//если такая строка уже есть, новая не создается, возвращается ссылка
        //помещает строку в пул, если не было intern, то строка находится вне пула, при intern объект остается существ.
        System.out.println(string2.intern() == string3.intern());//true

        //конкатенация строк
        //строки в языке не меняются, любые модификации приводят к созданию новой строки всегда, актуально и для пула и
        //для объектов
        String str1 = "строка 1";
        String str2 = "строка 2";
        String str3 = "строка 3";

        str1 = str1 + str2;//просто склеивает две строки, плюсов может быть много
        //в пуле создается новая строка, ссылка на первую строку теряется
        System.out.println(str1);

        str2 = str2.concat(str3).concat("Hello").concat("STR");
        //каждый плюс, каждый метод concat - это создание новой строки; concat полностью аналогичен плюсу

        System.out.println("Some data");//Эта строка тоже помещается в пул строк, но ссылки на него не будет
        //каждый раз когда компилятор видит строку, она добавляется в пул строк

        str3 = String.join(" :: ", str1, str2, str3);
        System.out.println(str3);

        str1 = "Строка ";
        for (int i = 0; i < 10; i++) {
            str1 += "итерация " + i;
        }
        System.out.println(str1);
        //в циклах или многочисленных операциях ни плюс ни конкат не используются
        //используются объекты или StringBuilder или StringBuffer - возможность изменения объекта без создания нового
        //идентичны за исключением одного различия:
        //StringBuilder - работает быстрее, но не потокобезопасен, нельзя использовать в многопоточных средах
        //StringBuffer - работает медленнее, но потокобезопасен

        str1 = "Строка ";
        //StringBuilder sb = new StringBuilder(str1);
        StringBuilder sb = new StringBuilder();
        sb.append(str1).append("Hello");//меняется содержимое объекта, в пул строк ничего не добавляется

        for (int i = 0; i < 10; i++) {
            sb.append(" итерация ").append(i);
        }
        str1 = sb.toString();
        System.out.println(str1);
        System.out.println(sb);
        //после суммирования лучше передать значение строке

        sb = new StringBuilder();//при необходимости дальнейшей работы можно переприсвоить объект

        char[] charsArr = {'q', 'w', 'e'};
        String charStr = new String(charsArr);

        byte[] bytes = charStr.getBytes();
        charStr = new String(bytes);//возможна передача кодировки

        //сравнение
        str1 = "Java";
        str2 = "java";

        System.out.println(str1.equals(str2));
        System.out.println(str1.equalsIgnoreCase(str2));

        System.out.println(str1.compareTo(str2));//возвращает число
        // 0 - строки равны; либо разница номеров из таблицы ASCII, сравнивает посимвольно, если не равно, то дальше не
        //идет, до первого расхождения, практическое применение - сравнение с нулем, из str1 вычитает str2
        System.out.println(str1.compareToIgnoreCase(str2));

        System.out.println(str1.startsWith("Ja"));//методов с игнорированием регистра нет
        System.out.println(str1.endsWith("A"));

        str1 = str1.toLowerCase();//переводит в нижний регистр
        System.out.println(str1);
        str1 = str1.toUpperCase();//переводит в верхний регистр
        System.out.println(str1);

        str1 = "        Строка ";
        System.out.println(str1);
        System.out.println(str1.trim());//удаляет пробелы в начале и в конце

        System.out.println(str1.length());//возвращает длину

        str1 = "Java";
        System.out.println(str1.replace("a", "AA"));

        str1 = "Java Junior";
        String[] strings = str1.split("\\s");
        System.out.println(Arrays.toString(strings));

        //какие методы в какой версии есть - только в документации поиск по "String <версия явы> docs"
        //
    }
}
