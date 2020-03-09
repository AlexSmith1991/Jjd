package HomeWork.AdditionalTasks.ArraysTasks.MultiDimensional;

import java.util.Arrays;

public class Task1 {
//Создание случайного двумерного массива
    public static void main(String[] args) {
        int[][] arr = new int[8][5];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 90) + 10;
            }
        }
        System.out.println(Arrays.deepToString(arr));
    }
}
