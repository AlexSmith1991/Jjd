package homework.requiredtasks.stringstasks;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.util.Scanner;

public class Task5 {
/*
*составление цепочек слов с разницей в одну букву из заданного списка
*/

    private static String purpose;
    private static int minCount;
    private static StringBuilder result;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstWord;
        while (true){
            System.out.println("Введите первое слово");
            firstWord = in.nextLine();
            System.out.println("Введите второе слово");
            purpose = in.nextLine();
            if (firstWord.length() != purpose.length()){
                System.out.println("Оба слова должны быть одинаковой длины");
            } else {
                break;
            }
        }
        System.out.println("Введите словарь через пробел");
        String newString = in.nextLine();
        newString = newString.trim();
        String[] wordsPool = newString.split("\\s");
        for (int i = 0; i < wordsPool.length; i++) {
            wordsPool[i] = wordsPool[i].replaceAll("\\W", "");
        }
        minCount = wordsPool.length + 3;
        if (nextStep(firstWord, wordsPool, 1)){
            String chain = result.toString();
            result = new StringBuilder();
            result.append(firstWord);
            String[] coins = chain.split("\\s");
            for (int i = coins.length - 1; i >= 0; i--) {
                result.append("->").append(coins[i]);
            }
            System.out.println(result.toString());
        } else {
            System.out.println("С использованием текущего словаря цепочку построить невозможно");
        }
    }

    public static boolean checkRightDifference(String firstWord, String secondWord){
        boolean res = true;
        int differences = 0;
        if (firstWord.length() != secondWord.length()){
            res = false;
        } else {
            for (int i = 0; i < firstWord.length(); i++) {
                if (firstWord.charAt(i) != secondWord.charAt(i)){
                    differences++;
                }
            }
            if (differences != 1){
                res = false;
            }
        }
        return res;
    }

    public static boolean nextStep(String firstWord, String[] wordsPool, int cointCount) {
        boolean res = false;
        cointCount++;
        if (checkRightDifference(firstWord, purpose)){
            if (cointCount < minCount){
                res = true;
                minCount = cointCount;
                result = new StringBuilder();
                result.append(purpose);
            } else {
                res = false;
            }
        } else {
            for (int i = 0; i < wordsPool.length; i++) {
                if (wordsPool[i].equals("") ||
                        !(checkRightDifference(firstWord, wordsPool[i]))) continue;
                String word = wordsPool[i];
                wordsPool[i] = "";
                if (nextStep(word, wordsPool, cointCount)){
                    res = true;
                    result.append(" ").append(word);
                }
                wordsPool[i] = word;
            }
        }
        return res;
    }
}
