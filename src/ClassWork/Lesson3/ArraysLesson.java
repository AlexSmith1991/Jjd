package ClassWork.Lesson3;

import java.util.Arrays;

public class ArraysLesson {
    public static void main(String[] args) {
        int[] someArr;
        int[] someArr2;
        /*someArr = new int[23];
        someArr2 = new int[] {23, 1, -10, 5};// переопределение ранее заданного массива

        for (int i = 0; i < someArr2.length; i++) {
            someArr2[i] *= 2;
        }
        System.out.println(Arrays.toString(someArr2));

        someArr2 = new int[] {23, 1, -10, 5};// переопределение ранее заданного массива
        for (int elem: someArr2){   //копирует значения массива в elem
            elem *=2;
            System.out.println(elem);
        }
        System.out.println(Arrays.toString(someArr2));*/

        // копирование массивов

        someArr = new int[15];
        someArr2 = new int[] {23, 1, -10, 5};

        int[] arr = someArr2;// копированием не является, просто создание нового имени, ведет к тому же массиву
        //ссылочные типы таким образом копировать нельзя
        int[] cloneArr = someArr2.clone();//получение полной копии, создает новый массив

        System.arraycopy(someArr2, 1, someArr, 3, 2);//изменяет существующий массив
        System.out.println(Arrays.toString(someArr));

        int[] copyArr = Arrays.copyOf(someArr2, 3);
        System.out.println(Arrays.toString(copyArr));

        // сравнение массивов
        someArr2 = new int[] {23, 1, -10, 5};
        someArr = new int[] {23, 1, -10, 5};
        //через знак равенства ссылочные типы не сравниваются

        //someArr == someArr2
        //someArr.equals(someArr2)так делать нельзя, будут сравниваться ссылки а не значения
        System.out.println(Arrays.equals(someArr, someArr2));

        someArr2 = new int[] {23, 1, -10, 5};
        someArr = new int[] {12, -10, 123, 6};
        int[] someArr3 = new int[4];

        for (int i = 0; i < someArr.length; i++) {
            someArr3[i] = someArr[i] + someArr2[i];
        }
        System.out.println(Arrays.toString(someArr3));

        //for (int i = 0, int j = 0, int k = 0; i < ; i++) {

        //сортировка массива

        someArr = new int[] {12, -10, 123, 6};
        Arrays.sort(someArr);//сортировка массива полностью
        //Arrays.sort(someArr,1,5);
        System.out.println(Arrays.toString(someArr));
        //Алгоритм быстрой сортировки, сложность 0(n log n)
        //Посмотреть реализацию алгоритма быстрой сортировки

        //поиск в массиве, бинарный поиск сложность 0(log n), перед использоваинем обязательно отсортировать по возрастанию
        someArr = new int[] {12, -10, 123, 6};
        Arrays.sort(someArr);
        System.out.println(Arrays.binarySearch(someArr,6));
        System.out.println(Arrays.binarySearch(someArr,15));
        //при поиске значения, которого нет, возвращает индекс где мог бы быть плюс один с минусом

        //многомерные массивы
        int[][] newArr = new int[3][4];
        System.out.println(Arrays.deepToString(newArr));

        int[][] newArr2 = {{1, 2, 3}, {4, 5}, {7}};
        System.out.println(Arrays.deepToString(newArr2));

        System.out.println(newArr2[1][1]);

        for (int i = 0; i < newArr2.length; i++) {
            for (int j = 0; j < newArr2[i].length; j++) {
                newArr2[i][j] *= newArr2[i][j];
            }
        }
        System.out.println(Arrays.deepToString(newArr2));
    //после копирования - file -> project structure
        //создается проект для дз VCS -> import into version control ->Share project on github


    }

}
