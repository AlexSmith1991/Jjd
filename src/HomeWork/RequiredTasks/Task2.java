package HomeWork.RequiredTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
//Поиск в массиве элементов с суммой = 7
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int arrSize = in.nextInt();
        int[] numArr = new int[arrSize];
        System.out.println("Введите элементы массива");
        for (int i = 0; i < arrSize; i++) {
            numArr[i] = in.nextInt();
        }
        Arrays.sort(numArr);
        int i = 0, j = arrSize - 1;
        while (i < j){
            if (numArr[i] + numArr[j] == 7) break;
            else if(numArr[i] + numArr[j] < 7) i++;
            else j--;
        }
        if (numArr[i] + numArr[j] == 7){
            System.out.print("Пара элементов массива с суммой 7: " + numArr[i] + " ");
            System.out.println(numArr[j]);
        } else System.out.println("В массиве нет пары чисел, сумма которых 7");
    }
}
