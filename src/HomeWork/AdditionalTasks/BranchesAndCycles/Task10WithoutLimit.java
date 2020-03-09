package HomeWork.AdditionalTasks.BranchesAndCycles;

import java.util.Scanner;

public class Task10WithoutLimit {
//Вывод факториала
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите число");
        int n = in.nextInt();
        String fact = "1";
        for (int i = 1; i <= n; i++) {
            fact = Mult(fact, i);
        }
        System.out.println(fact);
    }
    public static String Mult(String first, int second){
        String res = new String();
        char[] digits = first.toCharArray();
        int dec = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            int val = Integer.parseInt(String.valueOf(digits[i]));
            val = val * second + dec;
            dec = val / 10;
            res = Integer.toString(val % 10) + res;
        }
        if (dec > 0) res = Integer.toString(dec) + res;
        return  res;
    }
}
