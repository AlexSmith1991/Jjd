package homework.requiredtasks.arraystasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
//Создание случайного массива заданной длинны и копирование четных чисел в другой массив
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arrSize;
        while (true){
            System.out.println("Введите размер массива, натуральное число больше трех");
            arrSize = in.nextInt();
            if (arrSize > 3) break;
        }
        int[] firstArr = new int[arrSize], secondArr;
        int secondArrSize = 0;
        for (int i = 0; i < arrSize; i++) {
            firstArr[i] = (int) (Math.random() * (arrSize + 1));
            if (firstArr[i] % 2 == 0) secondArrSize++;
        }
        System.out.println(Arrays.toString(firstArr));
        if (secondArrSize > 0){
            secondArr = new int[secondArrSize];
            int j = 0;
            for (int i = 0; i < firstArr.length; i++) {
                if (firstArr[i] % 2 == 0) secondArr[j++] = firstArr[i];
            }
            System.out.println(Arrays.toString(secondArr));
        }

    }
}
