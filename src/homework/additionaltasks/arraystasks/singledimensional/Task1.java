package homework.additionaltasks.arraystasks.singledimensional;

public class Task1 {
//Вывод массива четных чисел в обратном порядке
    public static void main(String[] args) {
        int[] arr = new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        for (int i = arr.length - 1; i >= 0 ; i--) {
            System.out.print(arr[i] + " ");
        }
    }
}
