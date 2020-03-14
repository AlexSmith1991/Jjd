package homework.additionaltasks.branchesandcycles;

public class Task4 {
//Проверка вхождения случайного числа в интервал
    public static void main(String[] args) {
        int num = (int)(Math.random() * 118) + 5;
        if (num > 25 && num < 100) System.out.println("Число " + num + " содержится в интервале (25;100)");
        else System.out.println("Число " + num + " не содержится в интервале (25;100)");
    }
}
