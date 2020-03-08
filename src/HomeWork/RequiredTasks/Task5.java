package HomeWork.RequiredTasks;

public class Task5 {
//Создание и заполнение двумерного массива
    public static void main(String[] args) {
        int[][] arr = new int[5][8];
        int max = -100;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 199) - 99;
                if (arr[i][j] > max) max = arr[i][j];
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Максимальное значение: " + max);
    }
}
