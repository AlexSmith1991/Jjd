package homework.additionaltasks.branchesandcycles;

public class Task12 {
//Подсчет количества симметричных комбинаций на часах
    public static void main(String[] args) {
        int count = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; ( i < 2 && j <= 9) || (j <= 3) ; j++) {
                for (int k = 0; k <= 5; k++) {
                    for (int l = 0; l <= 9; l++) {
                        if (i == l && j == k) count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
