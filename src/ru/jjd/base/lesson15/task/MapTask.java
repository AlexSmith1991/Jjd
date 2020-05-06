package ru.jjd.base.lesson15.task;

import ru.jjd.base.lesson13.PairContainer;

import java.sql.PreparedStatement;
import java.util.*;

public class MapTask {
    public static void main(String[] args) {
        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        List<String> list = getLogins(firstTaskMap, city);
        System.out.println(list);



        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        Map<String, Integer> wordsMap = countWords(words);
        System.out.println(wordsMap);

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        Map<String, Customer> customerMap1 = customerByAgeMap(customerMap, 20, 50);
        System.out.println(customerMap1);




        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы по количеству букв:
        //  например, в одну группу попадут слова: 3 - [the, war, jar, get, met...], в другую 2 - [on, up, no, of...]
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. Вывести частоту встречаемости букв анг алфавита в данном тексте. Вывести в процентах для каждой буквы

        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like"; // !!! в тексте содержатся только буквы и пробельные символы !!!



    }

    private static List<String> getLogins (HashMap<String, String> hashMap, String value){
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, String> entry : hashMap.entrySet()){
            if (entry.getValue().equals(value)){
                list.add(entry.getKey());
            }
        }
        return list;
    }

    private static Map<String, Integer> countWords(List<String> words){
        Map<String, Integer> result = new TreeMap<>();
        for (String word: words){
            Integer count;
            count = result.get(word);
            if (count == null){
                result.put(word, 1);
            } else {
                result.replace(word, count + 1);
            }
        }
        return result;
    }

    private static Map<String, Customer> customerByAgeMap(Map<String, Customer> customerMap, int from, int to){
        Map<String, Customer> result = new HashMap<>();
        for (Map.Entry<String, Customer> entry: customerMap.entrySet()){
            if (entry.getValue().getAge() >= from && entry.getValue().getAge() <= to){
                result.put(entry.getKey(), entry.getValue());
            }
        }
        return result;
    }
}
