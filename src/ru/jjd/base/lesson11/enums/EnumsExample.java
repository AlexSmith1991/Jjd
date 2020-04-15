package ru.jjd.base.lesson11.enums;

import java.util.Arrays;

public class EnumsExample {
    //enum - перечисление, может быть создан как самодостаточный класс, в отдельном файле,
    //может быть создан в любом существующем файле

    public static void main(String[] args) {
        Article article = new Article("Путешествие по Австралии");
        article.setText("Текст статьи");
        //обращение к элементам enum - название.элемент
        article.setCountry(Country.AUSTRALIA);
        Article article1 = new Article("Путешествие по Великобритании");
        article1.setText("Текст статьи");
        article1.setCountry(Country.UK);
        System.out.println(article);
        System.out.println(article1);

        //Методы enum
        //получение массива констант values(), элементы не сортируются, порядок в enum и в массиве совпадает
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));

        //индекс конкретного элемента enum в массиве ordinal()
        System.out.println(Country.UK.ordinal());

        //имя константы - name()
        for (Country country: countries){
            System.out.println(country.name() + " " + country.ordinal());
        }

        //получение элемента enum по строке valueOf()
        System.out.println(Country.valueOf("USA"));
        //если константа не будет найдена, мы получим exception

        //enum priority
        System.out.println(Priority.HIGH.getCode());

        Priority low = Priority.LOW;//получение ссылки на существующий объект, не создание нового
        Priority low1 = Priority.LOW;
        low.setCode(123);//изменение будет распространяться на всю программу, обычно сеттеры стараются не делать
        //свойствам можно задать final
        System.out.println(Priority.LOW.getCode());
        System.out.println(low1.getCode());

        Operation operation = Operation.MULTI;
        System.out.println(operation.action(3, 5));
        operation = Operation.SUM;
        System.out.println(operation.action(3, 5));

        //если отдельный метод будет написан у какого-то одного элемента enum, то вне enum его вызвать будет нельзя

        SolarSystem[] solarSystems = SolarSystem.values();
        for (SolarSystem solarSystem: solarSystems){
            solarSystem.DisplayData();
        }
    }
}

//enum - перечисление - набор логически связанных констант
enum Country{
    UK, USA, AUSTRALIA//элементы enum - объекты типа Country, enum неизменяем, все enum наследуются от класса enum,
    // сами по себе они неизменяемые и статические, после создания туда нельзя ничего добавить или удалить
    //если в enum только элементы - точку с запятой ставить не нужно
    //enum может создаваться с дополнительными свойствами, методами и конструкторами
}

enum Priority{
    HIGH(10), MIDDLE(5), LOW(1);
    private int code;

    Priority(int code) {
        this.code = code;
    }

    public int getCode() {//метод доступен всем элементам
        return code;
    }

    public void setCode(int code) {//метод доступен всем элементам
        this.code = code;
    }
}
//каждый элемент enum может иметь свою реализацию общего метода

enum Operation{
    SUM{
        @Override
        public int action(int a, int b) {
            return a + b;
        }
    },
    MULTI{
        @Override
        public int action(int a, int b) {
            return a * b;
        }
    };

    public abstract int action(int a, int b);//метод абстрактный, то есть без реализации, тут - общий метод


}

//создать enum, который перечисляет планеты солнечной системы и возвращает массу и ее радиус

enum SolarSystem{
    MERCURY(12525, 12312),
    VENUS(47457, 23452),
    EARTH(456456,43534),
    MARS(34346,634464),
    JUPITER(3473374,457454),
    SATURN(345345,34634);

    private int mass;
    private int radius;

    SolarSystem(int mass, int radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public int getMass() {
        return mass;
    }

    public int getRadius() {
        return radius;
    }

    public void DisplayData(){
        System.out.println(name() + ": Mass - " + getMass() + " Radius - " + getRadius());
    }
}