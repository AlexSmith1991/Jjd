package homework.requiredtasks.stringstasks;

import java.util.Scanner;

public class Task2 {
/*
*Поиск самого длинного слова в предложении
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int maxLength = 0, maxInd = 0;
        System.out.println("Введите предложение");
        String sentence = in.nextLine();
        sentence = sentence.trim();
        sentence = sentence.replaceAll("\\.", "");
        String[] words = sentence.split("\\s");
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > maxLength){
                maxLength = words[i].length();
                maxInd = i;
            }
        }
        System.out.println(words[maxInd]);
        in.close();
    }
}
