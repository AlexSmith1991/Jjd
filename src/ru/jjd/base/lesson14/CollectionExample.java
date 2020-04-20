package ru.jjd.base.lesson14;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        Student student1 = new Student("Петр", "Алексеев", 18);
        Student student2 = new Student("Екатерина", "Еремина", 20);
        Student student3 = new Student("Денис", "Попов", 22);
        Student student4 = new Student("Петр", "Попов", 22);

        //коллекции могут быть потокобезопасные и потокоопасные, все коллекции,
        // которые мы сейчас рассмотрим - потокоопасные
        //коллекции различаются возможностью хранения дубликатов, возможностью хранения данных в отсортированном виде,
        // возможностью хранения данных в порядке добавления и т.д.

        //все  коллекции - дженерики, при создании коллекции в <> надо указать тип данных, который будет там храниться

        System.out.println("---Lis---");
        System.out.println("---LinkedList---");
        //Особенности LinkedList:
        //1. Элементы хранятся в порядке добавления
        //2. можно хранить null
        //3. допускает хранение дублирующих элементов

        LinkedList<Student> studentLinkedList = new LinkedList<>();
        studentLinkedList.add(student1);//добавление элемента в коллекцию
        studentLinkedList.add(student2);
        studentLinkedList.add(student1);
        //LinkedList в java - это двунаправленный связный список, каждый элемент хранит ссылку на предыдущий элемент
        // и на следующий элемент
        //add - добавляет элемент в конец списка
        //очень редко используется, скорее предпочтение будет оказано ArrayList

        //добавление элемента на указанную позицию(индекс первого элемента - 0)
        studentLinkedList.add(1, student3);

        //в однонаправленном списке первый элемент будет ссылаться на следующий, то есть изначально на null
        //в двунаправленном - на следующий и на предыдущий, изначально на null

        //индексы связный список не хранит, но с ними можно работать

        //если коллекция позволяет работать с индексами, и мы пытаемся обратить к несуществующему - выпадед exception
        //studentLinkedList.add(10, student3); //выдаст exception

        //метод add доступен всем коллекциям(который без указания индекса)
        //метод addfirst - добавление на первую позицию коллекции
        studentLinkedList.addFirst(null);

        System.out.println(studentLinkedList);
        //для каждого элемента коллекции будет вызван метод system.out.println()
        studentLinkedList.forEach(System.out::println);

        System.out.println(studentLinkedList.getLast());//последний элемент списка
        System.out.println(studentLinkedList.getFirst());//первый элемент списка
        System.out.println(studentLinkedList.get(2));//элемент списка на указанной позиции
        //вернет - не значит удалит, просто покажет какой элемент на выбранной позиции
        //посмотреть по документации какие методы из какого интерфейса идут

        //удаление
        studentLinkedList.removeFirst();//удаление первого элемента
        studentLinkedList.removeLast();//удаление последнего элемента
        studentLinkedList.remove(1);//удаление по индексу
        studentLinkedList.remove(student1);//удаляет из списка объект, если два одинаковых элемента -
        // удалится первый найденный
        //просто remove - это removeFirst

        System.out.println(studentLinkedList);

        System.out.println("---ArrayList---");
        //Используется очень часто, в отличие от LinkedList
        //особенности ArrayList
        //1.реализация  - это массив, не ссылки
        //2.порядок хранения элементов соответствует порядку добавления, можно хранить дублирующиеся элементы и null

        //по умолчанию внутри ArrayList создается массив на 10 элементов
        ArrayList<Student> studentArrayList = new ArrayList<>();
        //при добавлении элементов смыше 10 - создается массив большей емкости, примерно на 2/3 больше

        //когда заранее известно количество элементов
        studentArrayList = new ArrayList<>(20);//на 20 элементов
        //задает только изначальный размер, также может расширяться

        System.out.println(studentArrayList.size());//вернет количество элементов в коллекции

        studentArrayList.add(student1);//добавление в конец
        studentArrayList.add(student2);
        studentArrayList.add(1, null);//добавление на указанную позицию
        //методов addLast и addFirst нет

        studentArrayList.trimToSize();//урезает внутренний массив до количества элементов ArrayList

        //можно получить часть списка, указав начальную и конечную позиции, при этов конечная не включается
        System.out.println("sublist " + studentArrayList.subList(0, 2));

        //недоступны методы getFirst и getLast, но доступен get
        //System.out.println(studentArrayList.get(3));

        studentArrayList.remove(student1);
        studentArrayList.remove(1);
        //studentArrayList.removeAll(удаляемая коллекция);//удаляет все элементы, которые совпадают с коллекцией

        Student[] studentsArray = {student1, student2, student3};
        List<Student> arrAsList = Arrays.asList(studentsArray);//возвращает лист
        studentArrayList.addAll(arrAsList);//на вход необходимо передать коллекцию, любую

        System.out.println("---интерфейс Set---");
        //особенности Set
        //1. позволяет хранить только уникальные элементы
        //2. обязательно должны быть переопределены методы equals и hashCode

        System.out.println("---HashSet---");
        //особенности:
        //1. основан на hash таблице (использует hash Code)
        //2. порядок хранения элементов может отличаться от порядка добавления
        //3. может хранить null

        HashSet<Student> studentHashSet = new HashSet<>(arrAsList);
        //в сетах нет гет, можно проверить наличие элемента, но нельзя его получить, плюс нельзя работать с индексами,
        // индексов нет вообще
        studentHashSet.add(student1);
        System.out.println(studentHashSet.size());

        System.out.println("---LinkedHashSet---");
        //особенности
        //1. разница с HashSet:
        //порядок хранения элементов не отличается от порадка добавления
        LinkedHashSet<Student> studentLinkedHashSet = new LinkedHashSet<>();
        studentLinkedHashSet.add(student1);
        studentLinkedHashSet.add(student2);
        studentLinkedHashSet.add(null);
        System.out.println("LinkedHashSet " + studentLinkedHashSet);
        //хоть и хранит порядок, но индексы определять не умеет

        System.out.println("---TreeSet---");
        //особенности
        //1. не позволяет добавлять null
        //2. элементы хранит в отсортированном порядке
        //3. основан на алгоритме красно-черного дерева
        //4. порядок сортировки необходимо указывать

        //Для добавления элементов в TreeSet необходимо:
        //1. чтобы класс(экземпляры которого будут храниться в этой коллекции) реализовывал интерфейс Comparable
        // в его метод compareTo(в нем определяется какой объект считается большим, а какой меньшим)
        //2. передать в конструктор TreeSet компаратор - объект класса Comparator,
        // начиная с восьмой версии создалось больше возможностей по использованию компараторов

        //класс реализует интерфейс Comparable
        TreeSet<Student> treeSet1 = new TreeSet<>();
        treeSet1.add(student1);
        treeSet1.add(student2);
        treeSet1.add(student3);
        System.out.println("treeSet1 " + treeSet1);

        //передать компаратор
        Comparator<Student> studentComparator = new StudentNameComparator().thenComparing(new StudentAgeComparator());
        TreeSet<Student> treeSet2 = new TreeSet<>(studentComparator);
        treeSet2.add(student1);
        treeSet2.add(student2);
        treeSet2.add(student3);
        System.out.println("treeSet2 " + treeSet2);

        //перебор коллекций через foreach
        LinkedList<Student> students = new LinkedList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        for (Student student: students){
            System.out.println(student);
            System.out.println(student.getName());
            //if (student.getName().equals("Петр")){
            //    students.remove(student);//вызовет ошибку, в переборе удалять нельзя
            //}
        }
        Iterator<Student> studentIterator = students.listIterator();
        while (studentIterator.hasNext()){
            if (studentIterator.next().getName().equals("Петр")){
                studentIterator.remove();
            }
        }
        System.out.println("Students " + students);
        //в итераторе удалять можно, только удалять надо не из коллекции, а из итератора


    }
}
