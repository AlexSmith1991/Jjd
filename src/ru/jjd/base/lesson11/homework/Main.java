package ru.jjd.base.lesson11.homework;

import java.util.Scanner;

public class Main {
    private static User[] aPosition;
    private static User[] bPosition;
    private static User[] cPosition;
    private static User[] dPosition;

    static{
        aPosition = new User[50];
        bPosition = new User[50];
        cPosition = new User[50];
        dPosition = new User[50];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true){
            System.out.println("1 - Добавить нового пользователя");
            System.out.println("2 - Выйти");
            int answer = in.nextInt();
            in.nextLine();
            if (answer == 1){
                System.out.println("Введите имя");
                String fullName = in.nextLine();
                System.out.println("Веедите зп");
                int salary = in.nextInt();
                in.nextLine();
                System.out.println("Введите первую букву должности");
                String positionLetter = in.nextLine();
                User user = new User(fullName, salary, positionLetter);
                append(user);
            } else if (answer == 2){
                break;
            }
        }
    }

    private static void append(User user){
        switch (user.getPosition()){
            case APOSITION:
                for (int i = 0; i < aPosition.length; i++) {
                    if (aPosition[i] == null){
                        aPosition[i] = user;
                        break;
                    }
                }
                break;
            case BPOSITION:
                for (int i = 0; i < bPosition.length; i++) {
                    if (bPosition[i] == null){
                        bPosition[i] = user;
                        break;
                    }
                }
                break;
            case CPOSITION:
                for (int i = 0; i < cPosition.length; i++) {
                    if (cPosition[i] == null){
                        cPosition[i] = user;
                        break;
                    }
                }
                break;
            case DPOSITION:
                for (int i = 0; i < dPosition.length; i++) {
                    if (dPosition[i] == null){
                        dPosition[i] = user;
                        break;
                    }
                }
                break;
        }
    }
}
