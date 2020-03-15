package homework.requiredtasks.stringstasks;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task3 {
/*
* Найти количество вхождений одной строки в другую
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = 0;
        System.out.println("Введите первую строку");
        String firstString = in.nextLine();
        System.out.println("Введите вторую строку");
        String secondString = in.nextLine();
        Pattern pattern = Pattern.compile(firstString);
        Matcher matcher = pattern.matcher(secondString);
        while (matcher.find()){
            count++;
        }
        System.out.println("Количество вхождений: " + count);
        in.close();
    }
}
