package HomeWork.AdditionalTasks.BranchesAndCycles;

public class Task1 {
//Сумма цифр трехзначного числа
    public static void main(String[] args) {
        int num = (int)(Math.random() * 900) + 100;
        System.out.println(num);
        num = num / 100 + num % 100 / 10 + num % 10;
        System.out.println(num);
    }
}
