package ru.jjd.base.lesson16.reflection;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.jar.JarOutputStream;

public class ReflectionExample {

    /*static {//приведет к тому, что с помощью рефлексии setAccessible будет вызывать exception
        if (System.getSecurityManager() == null){
            System.setSecurityManager(new SecurityManager());
        }
    }*/

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //Рефлексия в Java - это механизм, с помощью которого можно получать информацию о классе, интерфейсах,
        // полях и методах во время выполнения программы, для чего нужна только ссылка на класс.
        // кроме того, Reflection API дает возможность создавать новые экземпляры класса,
        // вызывать методы, а также получать или устанавливать значения полей

        //все классы в языке являются объектами типа Class

        //получение ссылок на класс
        Class strClass = String.class;//ссылка на класс String
        System.out.println(strClass);
        Class intClass = int.class;//для примитива тоже можно получить ссылку на класс
        System.out.println(intClass);
        Class textMessageClass = TextMessage.class;
        System.out.println(textMessageClass);

        //получение ссылки на класс через объект
        TextMessage textMessage = new TextMessage("Срочное сообщение");
        textMessage.setText("Рефлексия");

        textMessageClass = textMessage.getClass();//также ссылка на класс TextMessage
        System.out.println(textMessageClass);

        //получим название класса, название пакета
        String className = textMessageClass.getName();
        String packageName = textMessageClass.getPackage().getName();
        System.out.println(className);
        System.out.println(packageName);

        //получим список интерфейсов, которые имплементирует класс
        //getInterfaces - возвращает только интерфейсы самого класса, не учитываются интерфейсы родителей
        Class[] interfaces = textMessageClass.getInterfaces();
        System.out.println(Arrays.toString(interfaces));

        //получим ссылку на родительский класс
        Class parent = textMessageClass.getSuperclass();//Message
        System.out.println(parent);
        parent = textMessageClass.getSuperclass().getSuperclass();//Object
        System.out.println(parent);
        parent = textMessageClass.getSuperclass().getSuperclass().getSuperclass();//null
        System.out.println(parent);

        Class[] parentInterfaces = textMessageClass.getSuperclass().getInterfaces();
        System.out.println(Arrays.toString(parentInterfaces));

        //доступ к компонентам класса
        //Class - дженерик
        Class<TextMessage> tmClass = TextMessage.class;
        //доступ к полям(свойствам) класса
        Field[] fields = tmClass.getFields();// Field должен быть импортирован из java.lang.reflect.Field
        //getfields возвращает все публичные! поля класса, включая родительские
        System.out.println(Arrays.toString(fields));

        //getDeclaredFields возвращает все поля текущего класса с любым модификатором доступа, исключая родительские
        Field[] declaredFields = tmClass.getDeclaredFields();
        System.out.println(Arrays.toString(declaredFields));

        //доступ к методам
        Method[] methods = tmClass.getMethods();//возвращает все публичные методы класса и его родителей
        // вплоть до Object
        System.out.println(Arrays.toString(methods));

        Method[] declaredMethods = tmClass.getDeclaredMethods();//вернет методы текущего класса с любым модификатором
        System.out.println(Arrays.toString(declaredMethods));

        //доступ ко конструкторам
        Constructor[] constructors = tmClass.getDeclaredConstructors();
        System.out.println(Arrays.toString(constructors));

        //создание объекта с использованием рефлексии

        //получми конструктор(конструкторы в методы не входят, их надо получать отдельно)
        //для этого необходимо знать тип данных и последовательность аргументов
        Constructor<TextMessage> tmConstructor = tmClass.getDeclaredConstructor(String.class);
        //если не указать дженерик, то будет создан Object,
        // но никакие данные потеряны не будут, можно будет воспользоваться приведением типов

        //создадим объект, используя полученный конструктор
        TextMessage reflectMessage = tmConstructor.newInstance("Рефлексивный объект");
        System.out.println(reflectMessage);

        //получим ссылку на поле text
        //по названию поля
        Field field = tmClass.getDeclaredField("text");
        System.out.println(field.getName());
        System.out.println(field.getType());
        //для полей доступны методы getName и getType
        field.setAccessible(true);//дает возможность обращаться к приватным полям
        //получили значение поля text объекта ReflectMessage
        System.out.println(field.get(reflectMessage));
        //установка значения поля для объекта
        field.set(reflectMessage, "Значение установлено через рефлексию");

        //получим доступ к методу
        Method method = tmClass.getDeclaredMethod("printText", String.class, String.class);
        //вызов метода объекта
        method.setAccessible(true);
        method.invoke(reflectMessage, "!!!", "###");//последовательность аргументов должна соблюдаться


        BigTextMessage bmt = new BigTextMessage("Big Message");
        field.set(bmt, "Big text");
        System.out.println(field.get(bmt));
        //можно писать и читать даже приватные поля

        boolean isPrivate = Modifier.isPrivate(field.getModifiers());
        System.out.println("Is text private " + isPrivate);

        //выбрать наиболее важные (интересные) методы
        //Class
        //Field
        //Method - посмотреть метод, который получает параметры(getParameters) - он точно полезный
        //Modifier

        //рефлексия - не для того чтобы разбить private!
    }
}
