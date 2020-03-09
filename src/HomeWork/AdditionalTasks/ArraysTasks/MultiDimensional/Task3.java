package HomeWork.AdditionalTasks.ArraysTasks.MultiDimensional;

public class Task3 {
//Преобразование случайного массива с постановной максимального элемента в начало
    public static void main(String[] args) {
        int[][] arr = new int[6][7];
        int[] maxIndexArr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            int max = -1;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10);
                System.out.print(arr[i][j] + " ");
                if (arr[i][j] > max){
                    max = arr[i][j];
                    maxIndexArr[i] = j;
                }
            }
            System.out.println();
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            int temp;
            if (maxIndexArr[i] != 0){
                temp = arr[i][0];
                arr[i][0] = arr[i][maxIndexArr[i]];
                arr[i][maxIndexArr[i]] = temp;
            }
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
