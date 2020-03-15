package homework.requiredtasks.stringstasks;

import java.util.Scanner;

public class Task4 {
/*
*Проверка, является ли строка палиндромом
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите строку");
        String newString = in.nextLine();
        newString = newString.trim();
        newString = newString.toLowerCase();
        if (checkLetters(newString) || (checkWords(newString))){
            System.out.println("Введенная строка является палиндромом");
        } else {
            System.out.println("Введенная строка не является палиндромом");
        }
        in.close();
    }

    public static boolean checkLetters(String newString){
        newString = newString.replaceAll("\\W","");
        int i = 0, j = newString.length() - 1;
        while (i < j){
            if (newString.charAt(i) == newString.charAt(j)){
                i++;
                j--;
            } else {
                break;
            }
        }
        return (i >= j);
    }

    public static boolean checkWords(String newString){
        String[] words = newString.split("\\s");
        int i = 0, j = words.length - 1;
        while (i < j){
            if (words[i].replaceAll("\\W", "").
                    equals(words[j].replaceAll("\\W", ""))){
                i++;
                j--;
            } else {
                break;
            }
        }
        return (i >= j && words.length > 1);
    }
}
