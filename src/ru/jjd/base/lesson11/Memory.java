package ru.jjd.base.lesson11;

public class Memory {
    //все создаваемые объекты хранятся в памяти heap(куча)
    //сборщики мусора уничтожают объекты без ссылок
    //stack - память для работы методов, когда метод работу завершает - память освобождается
    //permanent generation/metaspace - хранятся метаданные, описания классов плюс вся статика
    //с восьмой версии пул строк тоже хранится тут
    //класс прогружается в момент обращения, по необходимости
    //за загрузку классов отвечают загрузчики классов, их несколько

    //run -> edit configurations ->vm options - все опции сюда
    //-verbose:class  - при запуске в консоли можно будет увидеть какие классы загружались и когда

    //сборкой мусора нельзя управлять, сборщик мусора будет работать когда ему нужно
    //можно вызвать сборщик мусора, но не факт что он начнет работать, конечное решение всегда за витруальной машиной
    //деление областей - молодое поколение(все новые объекты создаются в нем), промежуточная область и старое поколение
    //чаще всего сборщики мусора работают в молодом поколении и промежуточной области
    //при каждой последующей сборке мусора сборщик работает eden + s1 или s0, в зависимости от того, где на этом шаге
    // хранятся данные, долгоживущие объекты сборщик переносит в старое поколение, туда он заходит очень редко
    //
}
