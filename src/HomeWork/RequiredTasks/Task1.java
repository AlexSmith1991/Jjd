package HomeWork.RequiredTasks;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
//Найти наибольший общий делитель двух чисел
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите два целых числа");
        int[] numbArr = new int[2];
        numbArr[0] = in.nextInt();
        numbArr[1] = in.nextInt();
        Arrays.sort(numbArr);
        while (true){
            int a = numbArr[1] % numbArr[0];
            if (a == 0){
                break;
            }else{
                numbArr[1] = numbArr[0];
                numbArr[0] = a;
            }
        }
        System.out.println("НОД = " + numbArr[0]);
    }
}
