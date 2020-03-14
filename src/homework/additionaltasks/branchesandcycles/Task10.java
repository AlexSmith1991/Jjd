package homework.additionaltasks.branchesandcycles;

import java.util.Scanner;

public class Task10 {
//Вывод факториала числа
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int n = in.nextInt();
        long res = 1;
        for (int i = 1; i <= n; i++) {
            res *= i;
        }
        System.out.println(res);
    }
}
