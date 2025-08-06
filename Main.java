import mironov.sergey.ValueAddedTax6;
import sergey.mironov.ValueAddedTax15;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int earnings = 0;    // доходы
        int spendings = 0;   // расходы

        while (true) {
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать систему налогообложения");
            System.out.println("end");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            int resultTax15 = ValueAddedTax15.taxEarningsMinusSpendings(earnings, spendings);
            int resultTax6 = ValueAddedTax6.taxEarnings(earnings);

            switch (operation) {

                case 1:
                    System.out.println("Введите сумму дохода:");
                    String moneyStr = scanner.nextLine();
                    int money = Integer.parseInt(moneyStr);
                    earnings += money;
                    break;

                case 2:
                    System.out.println("Введите сумму расхода:");
                    String cashExp = scanner.nextLine();
                    int cash = Integer.parseInt(cashExp);
                    spendings += cash;
                    break;

                case 3:
                    int differenceTax = Math.abs(resultTax15 - resultTax6);
                    if (resultTax15 > resultTax6) {
                        System.out.println("Мы советуем вам УСН доходы");
                    } else if (resultTax15 < resultTax6) {
                        System.out.println("Мы советуем вам УСН доходы минус расходы");
                    } else {
                        System.out.println("Можете выбрать любую систему налогообложения");
                    }

                    if (resultTax15 > resultTax6) {
                        System.out.println("Ваш налог составит: " + resultTax6);
                        System.out.println("Налог на другой системе: " + resultTax15);
                    } else if (resultTax15 < resultTax6) {
                        System.out.println("Ваш налог составит: " + resultTax15);
                        System.out.println("Налог на другой системе: " + resultTax6);
                    }

                    System.out.println("Экономия: " + differenceTax);

                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}