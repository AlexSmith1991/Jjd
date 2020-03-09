package HomeWork.AdditionalTasks.BranchesAndCycles;

public class Task5 {
//Поиск максимальной цифры числа
    public static void main(String[] args) {
        int num = (int)(Math.random() * 900) + 100;
        System.out.print("В числе " + num + " наибольшая цифра ");
        if (num / 100 > num % 100 / 10){
            if (num / 100 > num % 10) System.out.println(num / 100);
            else System.out.println(num % 10);
        }else{
            if (num % 100 / 10 > num % 10) System.out.println(num % 100 / 10);
            else System.out.println(num % 10);
        }
    }
}
