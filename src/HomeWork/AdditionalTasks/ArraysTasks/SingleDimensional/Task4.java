package HomeWork.AdditionalTasks.ArraysTasks.SingleDimensional;

import java.util.Arrays;

public class Task4 {
//Создание случайного массива с поиском наиболее часто встречающегося элемента
    public static void main(String[] args) {
        int[] valuesArr = new int[11], countArr = new int[3];
        boolean checkSingle = true;
        int max = -1;
        for (int i = 0; i < valuesArr.length; i++) {
            valuesArr[i] = (int) (Math.random() * 3) - 1;
            countArr[valuesArr[i] + 1]++;
            if (countArr[valuesArr[i] + 1] > max){
                checkSingle = true;
                max = countArr[valuesArr[i] + 1];
            }else if (countArr[valuesArr[i] + 1] == max) checkSingle = false;
        }
        System.out.println(Arrays.toString(valuesArr));
        if (checkSingle){
            for (int i = 0; i < countArr.length; i++) {
                if (countArr[i] == max){
                    System.out.print("Чаще всего встречается элемент: ");
                    System.out.println(i - 1);
                }
            }
        }
    }
}
