package HomeWork.AdditionalTasks.BranchesAndCycles;

public class Task11 {
//Вывод 11 членов последовательности Фибоначчи
    public static void main(String[] args) {
    int previous = 0, current = 0;
        System.out.print(current++ + " ");
        for (int i = 0; i < 10; i++) {
            System.out.print(current + " ");
            int temp = current;
            current += previous;
            previous = temp;
        }
    }
}
