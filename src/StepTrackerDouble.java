import java.util.Scanner;

public class StepTrackerDouble {
    int[][] monthAndDays = new int[12][30];

    void StepTrackerDoubleMethod(Scanner console) {
        System.out.println("Введите номер месяца от 1 до 12");
        Scanner scanner = console;
        int numberMonth = scanner.nextInt();
        System.out.println("Введите номер дня от 1 до 30");
        int numberDay = scanner.nextInt();
        System.out.println("Введите количество пройденных шагов");
        int countSteps = scanner.nextInt();
        if ((numberMonth <= 12) && (numberDay <= 30) && (countSteps > 0)) {
            //for (int i = 0; i < monthAndDays.length; i++) {
                //for (int j = 0; j < monthAndDays[i].length; j++) {
                    monthAndDays[numberMonth][numberDay] = countSteps;
                    System.out.println("Данные за текущий день сохранены: " + monthAndDays[numberMonth][numberDay]);
               // }
          //  }
        } else {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверь данные и внесите корректировку.");
        }
    }
}

 /*   public void addNewNumberStepsPerDay() {

        System.out.println("Введите номер месяца от 1 до 12");
        int numberMonth = scanner.nextInt();
        if (numberMonth <= 12) {
            System.out.println("Введите номер дня от 1 до 30");
            int numberDay = scanner.nextInt();
            if (numberDay <= 30) {
                System.out.println("Введите количество пройденных шагов");
                int countSteps = scanner.nextInt();
                if ((countSteps > 0)) {
                    months[numberMonth - 1].days[numberDay - 1] = countSteps;
                    System.out.println("Данные за текущий " + numberMonth + " месяц и текущий " + numberDay + " день сохранены. Результат: " + countSteps + " шагов");
                }
            }
        }
        System.out.println("Вводимые параметры - некорректны. Пожалуйста проверь данные и внесите корректировку и повторите попытку");

    }*/





