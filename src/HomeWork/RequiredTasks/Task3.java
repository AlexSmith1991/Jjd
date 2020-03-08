package HomeWork.RequiredTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
//Заполнение массива случайными числами с поиском максимального, минимального и среднего значения
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int n = in.nextInt();
        int max = -2147483648, min = 2147483647;
        double av = 0;
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            long randomValue = (long) (Math.random() * 4294967296L) - 2147483648L;
            numArr[i] = (int) randomValue;
            if (numArr[i] > max) max = numArr[i];
            if (numArr[i] < min) min = numArr[i];
            av += numArr[i];
        }
        av /= n;
        System.out.println(Arrays.toString(numArr));
        System.out.println("Максимальное значение: " + max);
        System.out.println("Минимальное значение: " + min);
        System.out.printf("Среднее значение: %f", av);
    }
}
