package HomeWork.AdditionalTasks.ArraysTasks.MultiDimensional;

import java.util.Arrays;

public class Task2 {
//Создание случайного двумерного массива, поиск строки с максимальным произведением элементов
    public static void main(String[] args) {
        int[][] arr = new int[7][4];
        int max = -1, maxNum = 1;
        for (int i = 0; i < arr.length; i++) {
            int res = 1;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 11) - 5;
                res *= arr[i][j];
            }
            if (Math.abs(res) > max){
                max = Math.abs(res);
                maxNum = i + 1;
            }
        }
        System.out.println(Arrays.deepToString(arr));
        System.out.println("Максимальное произведение элементов в строке " + maxNum);
    }
}
