package ru.jjd.base.lesson15;

import org.w3c.dom.ls.LSOutput;

import java.lang.ref.WeakReference;
import java.util.*;

public class MapExample {
    public static void main(String[] args) {
        User cbf = new User("cbf", "12443", Role.USER);
        User asd = new User("asd", "2625", Role.ADMIN);
        User rty = new User("rty", "8734", Role.USER);
        User bnm = new User("bnm", "2688", Role.ADMIN);

        //мапы состоят из пар ключ + значение
        //все ключи в мапе уникальны, к одному ключу может быть привязано только одно значение
        //MAP в Java - структура данных, которая хранит данные в виде пары ключ-значение,
        // ключи должны быть уникальными,
        // мапа коллекцией не является, это совершенно разные структуры данных, не имеющие никаких общих интерфейсов
        //если класс хочет быть мапой - он должен реализовывать интерфейс Map
        //Hashtable - используется крайне редко, была создана для работы с многопоточными средами,
        // но есть другие, более быстрые реализации
        //все мапы - дженерики, как и коллекции

        System.out.println("---HashMap---");
        //1.хранит ключи в hash таблице(используются hashCode ключей)
        //2.для объектов, которые используются в качестве ключей, должны быть переопределены методы equals и hashCode
        //3.порядок хранения элементов может отличаться от порядка добавления
        //4.null может быть использован в качестве ключа

        //создание объекта
        //в <> первым указывается тип данных ключей - String для данного объекта
        //в <> вторым указывается тип данных значений - User для данного объекта
        HashMap<String, User> userHashMap = new HashMap<>();

        //добавление элементов: в качестве ключей будем использовать логины пользователей
        userHashMap.put(asd.getLogin(), asd);
        userHashMap.put(cbf.getLogin(), cbf);
        userHashMap.put(rty.getLogin(), rty);
        userHashMap.put(bnm.getLogin(), bnm);
        userHashMap.put(null, null);

        //у string equals и hashCode переопределены, поэтому ничего с ними делать не надо,
        // иначе в классе надо было бы переопределить

        System.out.println(userHashMap);

        //при создании объекта HashMap создается массив типа Entry/Node, по умолчанию из 16 элементов
        //class Entry/Node<K, V>: int HashCode; K key; V value; Entry/Node next

        //добавление(put) - это не перезапись, добавит только если записи с таким ключем нет
        //при добавлении элемента высчитывается хэш от ключа,
        // если новый код совпадает с существующим элементом массива,
        // элемент добавится туда как часть связанного списка, иначе запишет в следующий элемент массива
        //в качестве ключей рекомендуется использовать String

        //получение значения по ключу, метод вернет значение, которое соответствует ключу
        System.out.println(userHashMap.get("asd"));
        System.out.println(userHashMap.get("sdgsdgsed"));//если в мапе нет такого ключа, значит метод вернет null

        System.out.println(userHashMap.getOrDefault("vvv", bnm));//если находится значение по ключу "vvv",
        // то вернет его, иначе вернет объект bnm, притом объект в мапу не добавляется

        //удаление по ключу - удаляет ключ и связанное с ним значение, возвращает удаленное значение
        userHashMap.remove("asd");
        //удаление по паре ключ-значение - если указанному ключу соответствует указанное значение,
        // то будут удалены соответствующие ключ и значение
        userHashMap.remove("bnm", bnm);
        //если по указанному ключу лежит другое значение - ничего удалено не будет, метод возвращает boolean

        //remove, put и get определены в Map и имеют отношение ко всем мапам

        //заменить существующее значение на новое, к ключу null будет привязан объект asd
        userHashMap.replace(null, asd);//возвращает старое значение

        //замена по паре ключ-значение
        userHashMap.replace(null, asd, null);//возвращает boolean

        //посмотреть констркукторы, и посмотреть перечисленные методы - что принимают, что возвращают,
        // какие могут быть exception.
        // Методы - clear, containsKey, containsValue, entrySet, get, getOrDefault,
        // isEmpty, keySet, put, putAll, putIfAbsent,
        // remove, replace, size, values

        System.out.println("---Перебор элементов Map---");
        for (Map.Entry<String, User> entry: userHashMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
        //не надо думать Node или Entry, на выход всегда будут собираться в Entry,
        // Node только для внутреннего использования

        System.out.println("---EnumMap---");
        //1. использует enum в качестве ключей, все ключи должны быть одного типа
        // (все они должны быть элементами одного enum)
        //2. null нельзя использовать в качестве ключа
        //4. значения(values) хранятся в массиве(размер массива - количество элементов enum)
        //4. порядок хранения элементов соответствуеи порядку элементов в enum
        //5. для извлечения значений (values) из массива используется порядковый номер ключа -
        // метод ordinal() (vals[key.ordinal()])
        //внутри ключи и значение не сильно связаны, значения хранятся в отдельном массиве, свзять по номерам

        //создание объекта enumMap, в конструкторе необходимо передать ссылку на enum,
        // который будет использован в качестве ключей
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);// Role.class - ссылка на класс Role
        //значением мапы может быть другая мапа
        enumMap.put(Role.USER, new ArrayList<>(Arrays.asList(cbf, rty)));
        //Аналогично
        //List<User> userList = Arrays.asList(cbf, rty);
        //ArrayList<User> userArrayList = new ArrayList<>(userList);
        //enumMap.put(Role.USER, userArrayList);
        enumMap.put(Role.ADMIN, new ArrayList<>(Arrays.asList(asd, bnm)));

        System.out.println(enumMap);
        System.out.println(enumMap.get(Role.USER));

        //for (User user: enumMap.get(Role.ADMIN)){
        //    System.out.println(user.getLogin());
        //}
        //в цикле лучше методы не вызывать, лучше так:
        ArrayList<User> users = enumMap.get(Role.ADMIN);
        for (User user: users){
            System.out.println(user.getLogin());
        }

        User newUser = new User("newUser", "654", Role.ADMIN);

        enumMap.get(newUser.getRole()).add(newUser);// не сработало бы,
        // если бы ранее не была добавлена пара ключ-значение для этого ключа

        System.out.println("---TreeMap---");
        //1. хранит элементы в отсортированном по ключам порядке
        //2. null не может быть использован в качестве ключа, если попытаться - будет exception
        //3. класс, объекты которого используются в качестве ключей должен имплементировать интерфейс Comparable
        //либо объект Comparator должен передаваться в конструктор TreeMap
        //4. основан на алгоритме красно-черного дерева
        //

        userHashMap.remove(null);
        TreeMap<String, User> treeMap = new TreeMap<>(userHashMap);//может быть создана на основе HashMap
        System.out.println(treeMap);
        treeMap.put(newUser.getLogin(), newUser);
        treeMap.put(asd.getLogin(), asd);
        treeMap.put(rty.getLogin(), rty);
        System.out.println(treeMap);

        System.out.println("---WeakHashMap");
        //1. Хранит ключи в хэш таблице
        //2. имеет все свойства HashMap
        //3. запись из WeakHashMap будет удалена при сборке мусора,
        // если на ключи не осталось сильных ссылок

        WeakHashMap<Object, String> weakHashMap = new WeakHashMap<>();
        Object weakKey = new Object();
        String weakValue = "StringValue";
        weakHashMap.put(weakKey, weakValue);

        HashMap<Object, String> hashMap = new HashMap<>();
        Object hashKey = new Object();
        String hashValue = "String value";
        hashMap.put(hashKey, hashValue);

        //обнуляем ссылки на ключи
        weakKey = null;
        hashKey = null;

        System.gc();//попытка запустить сборщик мусора

        System.out.println("weakHashMap " + weakHashMap);
        System.out.println("hashMap " + hashMap);

        //используется для создания различных кэшей

        //сильная ссылка - strong reference - объект не будет удаляться даже при недостатке памяти
        User user = new User("user", "34354", Role.ADMIN);
        //weakUser - слабая ссылка - weak reference
        WeakReference<User> weakUser = new WeakReference<>(user);
        user = null;//на объект осталась одна слабая ссылка - когда в памяти не остается места,
        // все объекты со слабыми ссылками, отмечаются сборщиком особым образом, при нехватке памяти они удалятся
    }
}
