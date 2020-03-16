package homework.requiredtasks.stringstasks;

import java.util.Scanner;

public class Task1 {
/*
*Получение слова из половин двух слов
*/
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("Введите два слова с четным количеством букв");
            String twoWords = in.nextLine();
            twoWords = twoWords.trim();
            String[] words = twoWords.split("\\s");
            if ( (words.length == 2) &&
                    (words[0].length() % 2 == 0) &&
                    (words[1].length() % 2 == 0)){
                System.out.println(words[0].substring(0,(words[0].length() / 2)) +
                                    words[1].substring((words[1].length() / 2), words[1].length()));
                break;
            }
        }
        in.close();

    }
}
