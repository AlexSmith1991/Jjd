package homework.additionaltasks.arraystasks.singledimensional;

import java.util.Arrays;

public class Task3 {
//Создание случайного массива и проверка, является ли он строго возрастающим
    public static void main(String[] args) {
        int[] arr = new int[4];
        int previous = 9;
        boolean check = true;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 90) + 10;
            if (arr[i] >= previous) check = false;
            previous = arr[i];
        }
        System.out.println(Arrays.toString(arr));
        if (check) System.out.println("Массив является строго возрастующей последовательностью");
        else System.out.println("Массив не является строго возрастающей последовательностью");
    }
}
