package ru.jjd.base.lesson17.homework;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Main {
    //дз дополнительное
    //инъекция зависимости - внутри одного класса есть ссылка на другой, установка его значения
    // и есть инъекция зависимости, может быть правильной и неправильной,
    // правильная - когда конструктор принимает уже созданный где-то объект
    // неправильная - если в конструктор передаются данные и внутри запускается конструктор другого типа
    //надо написать рефлексивный контейнер, который позволит по аннотациям инициализировать свойства,
    // классы в самой программе не должны зависеть от тестовых классов вообще никак, никакого приведения типов,
    // никаких созданий объектов, считать что папка контейнер - библиотека

    //при считывании из файла надо учитывать префикс и название свойства
    //config class - обязательно создать объект класса, свойства подтягиваются из значений конфиг файла
    //reqiured - рекомендует создать объект, никаких дополнительных действий, приоритет ниже чем у config class
    //например класс Cat - помечен required, плюс свойство animvalsconfig

    //можно создавать сколько угодно классов и аннотаций, основной класс - контейнер,
    // тот кто хочет пользоваться библиотекой - расставляет аннотации,
    // все ссылки на пользовательские классы собираются в сет,
    // потом создаем объект контейнера с передачей в него сета всех тестовых классов,
    // внутри контейнера сет перебирается и смотрится каждый клксс, на соответствующие аннотации
    //должна быть возможность вызвать метод getObject с указанием имени или класса, а контейнер должен вернуть объект
    public static void main(String[] args) {
        Set qwe = new HashSet<>();
        qwe.add(Integer.class);
        qwe.add(String.class);
        qwe.add(Byte.class);
        System.out.println(qwe.contains("qwe"));
        Iterator iterator = qwe.iterator();
        while (iterator.hasNext()){
            System.out.println(((Class) iterator.next()).getName());
        }
    }
}

