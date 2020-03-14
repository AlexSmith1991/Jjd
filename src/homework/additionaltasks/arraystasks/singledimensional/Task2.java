package homework.additionaltasks.arraystasks.singledimensional;

import java.util.Arrays;

public class Task2 {
//Создание и вывод случайного массива, подсчет количества четных элементов
    public static void main(String[] args) {
        int[] arr = new int[15];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10);
            if (arr[i] % 2 == 0) count++;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("Количество четных элементов: " + count);
    }
}
