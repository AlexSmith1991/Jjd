package ru.jjd.base.lesson13;

public class GenericExample {
    public static void main(String[] args) {
        //в <> указываем конкретный тип данных, который будет подставляться вместо T
        User<String> stringUser = new User<>();//тип данных id - String
        stringUser.setId("sdfgat45yh");
        stringUser.setLogin("qwe");
        stringUser.setPwd("123");

        User<Integer> integerUser = new User<>();//тип данных id - Integer, в generic нельзя использовать примитивы,
        // только соответствующие классы-обертки, скобки <> обязательно должны быть в конструкторе,
        // внутри ничего писать не нужно
        integerUser.setId(14);
        integerUser.setLogin("jhgfk");
        integerUser.setPwd("1365");

        System.out.println(stringUser);
        System.out.println(integerUser);

        //для объекта container1 тип key будет String, а тип value - Integer
        //PairContainer<String, Integer> container1 = new PairContainer<>();

        //для объекта container1 тип key будет Double, а тип value - User с любым типом id
        PairContainer<Double, User> container2 = new PairContainer<>(3.3, stringUser);
        //в момент выполнения программы тип данных поля id для User не определен, и он станет типом Object
        container2.getValue().getId();//id - Object
        container2.getValue().setId("asd");
        //без указания generic типа, тип будет Object, можно будет добавить туда любое значение,
        // но оно будет типа Object

        PairContainer<Double, User<String>> container3 = new PairContainer<>(4.6, stringUser);
        container3.getValue().setId("kjgfkjyfk");//id - String

        User<Number> numberUser = new User<>();
        numberUser.setId(44.465);
        //ни через Number, ни через другого родителя в generic работать нельзя

        //PairContainer<String, User<Integer>> container4 = new PairContainer<>("hello", numberUser)//так делать нельзя,
        PairContainer<String, User<Number>> container4 = new PairContainer<>("hello", numberUser);
        // юзер может быть только таким, какой указан в дженерике, наследование не работает ни в одну сторону
        //обязательно использовать то, что указано в дженерике
    }
}
