package ru.jjd.base.lesson12;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args) {
        //исключения и ошибки - это объекты
        //если класс хочет быть исключением - он должен наследовать интерфейс throwable
        //наследники класса error - в коде не обрабатываются, обрабатываются на уровне виртуальной машины
        //exception - можно обработать, некоторые нужно обработать обязательно
        //исключения делятся на те, которые можем обработать(наследники RuntimeException) и те,
        // которые должны обрабатывать(все остальные)

        //некоторые RuntimeException
        int a = 12;
        int b = 0;
        int res;
        //res = a / b; // RuntimeException - ArithmeticException

        int[] arr = new int[3];
        //arr[89] = 12;//ArrayIndexOutOfBoundsException

        String string = null;
        //string.equals("hello");//NullPointerException

        Object someData = "253";//нельзя обработать как строчку(доступны только методы родителя)
        String stringData = "253";

        Integer someInteger;

        //someInteger = (Integer) someData;//ClassCastException - проблема приведения типов


        //обработка исключений(checked и unchecked)
        //для обработки исключений используется try catch блок и блок finally
        try{//в блок try помещается потенциально опасный участок кода
            //код, который может привести к исключению
            System.out.println("before a / b");
            res = a / b;//когда в блоке try происходит ArithmeticException, управление переходит в блок catch,
            // остальной код в блоке try выполнен не будет
            System.out.println("after a / b");
        } catch (ArithmeticException e){//e - имя переменной, может быть любым, в него попадет объект исключения
            // , ArithmeticException - тип данных
            //блок catch перехватывает только то исключение, которое в нем указано
            //перечисляем инструкции, которые должны быть выполнены при ArithmeticException
            System.out.println(e.getMessage());//сообщение об исключении в виде строки
            e.printStackTrace();//выводит в консоль информацию об исключении
            res = 1000;
        }
        System.out.println("after try catch");
        System.out.println("res = " + res);

        //объединение catch блоков для обработки нескольких исключений
        //1 вариант - разные виды исключений разными способами
        try{
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer) someData;
            else arr[77] = 100;
        } catch (ClassCastException e){//перехватывает только ClassCastException и всех его потомков
            System.out.println("Проблема с приведением типов");
        } catch (ArrayIndexOutOfBoundsException e){//перехватываем ArrayIndexOutOfBoundsException и всех его потомков
            System.out.println("Проблема с массивом");
        }

        //2 вариант - все исключения одним способом

        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer) someData;
            else arr[77] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            //перехватывает ClassCastException и всех его потомков + ArrayIndexOutOfBoundsException и его потомков
            System.out.println("Проблема с массивом или приведением типов");
            System.out.println(e.getMessage());
        }

        //3 вариант - через общего родителя(через общий тип данных)
        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer) someData;
            else arr[77] = 100;
        } catch (RuntimeException e) {//можно написать Exception, тогда тут будут обрабатываться вообще все исключения
            System.out.println("Проблема с чем-то в RuntimeException");
            System.out.println(e.getMessage());
        }

        //перед вызовом обработки надо продумать насколько она там нужна, просто так обработку не ставят,
        // она указывает на неполадки с кодом

        try {
            if (System.currentTimeMillis() % 2 == 0) someInteger = (Integer) someData;
            else arr[77] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            //если работает с общим типом - то кэтчи надо указывать от меньшего к большему
            System.out.println("Проблема с массивом или приведением типов");
        }catch (RuntimeException e) {
            System.out.println("Проблема с чем-то в RuntimeException");
            System.out.println(e.getMessage());
        }

        try {

        } catch (RuntimeException e) {

        }

        //блок finally(не обязательный блок)
        finally{
            //код, который написан в блоке finally выполнится в случае любого исключения,
            //даже если оно не перехватывается в блоке catch
            //может быть использован только вместе с try catch
            //используется для закрытия ресурсов
            //не должен содержать необработанных исключений
            //если в коде несколько try catch - блок finally относится ко всем этим блокам между ним и
            // предыдущим блоком finally
        }

        //в языке есть возможность не только обрабатывать, но и генерировать исключения
        //метод выбрасывает RuntimeException, поэтому можно обработать это с помошью блока try
        voidWithUncheckedException(40);
        voidWithUncheckedException(10);

        try {
            //метод генерирует обрабатываемое исключение, поэтому мы обязаны обработать его в блоке try
            // или пробросить на уровень выше
            voidWithCheckedException("asd.txt");//нужно либо завернуть в try, либо включить throw в метод
        } catch (IOException e) {
            e.printStackTrace();
        }

        SomeMessage someMessage = null;
        try {
            someMessage = new SomeMessage("название", "текст");
            //если переменная объявлена внутри блока try - ее видно будет только в этом блоке,
            // в catch она уже будет недоступна
        } catch (ChatException e) {
            try {
                throw new ChatException("some data").initCause(e);
            } catch (Throwable ex){
                System.out.println("Throwable" + ex.getCause());
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        //если объект не создан, следующий код приведет к NullPointerException, значит необходимо
        // вернуться к проверке входящих данных
        System.out.println(someMessage.getText());
    }

    private static void voidWithCheckedException(String s) throws IOException {//throws - перекладывает
        // ответственность за обработку исключения на место вызова
        if (s.endsWith("txt")){
            //генерируем и выбрасываем обрабатываемое исключение
            throw new IOException("Проблема с файлом");
        }
        System.out.println("s = " + s);
    }

    private static void voidWithUncheckedException(int a){
        if (a < 15){
            //генерируем и выбрасываем runtime исключение
            throw new IllegalArgumentException("Значение не должно быть меньше 15");//конструктор может быть
            // и без сообщений
        }
        System.out.println("a = " + a);
    }
}
