import java.util.Scanner;

class StepTracker {
    Scanner scanner;
    DaysOfMonth[] months = new DaysOfMonth[12];
    int goalByStepsPerDay = 10_000;

    StepTracker(Scanner scan) {
        scanner = scan;
// необходимо создать новый экземпляр класса DaysOfMonth для каждого индекса массива monthToData.
        for (int i = 0; i < months.length; i++) { // массив 12 месяцев инициализирован по 30 дней
            months[i] = new DaysOfMonth();// для каждого месяца массив из 30 дней
        }
    }

    public void addNewNumberStepsPerDay() {

        System.out.println("Введите номер месяца от 1 до 12: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь");
        int numberMonth = scanner.nextInt();
        if ((numberMonth > 12) || (numberMonth <= 0)) {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
            return;
        }

        System.out.println("Введите номер дня от 1 до 30");
        int numberDay = scanner.nextInt();
        if ((numberDay > 30) || (numberDay <= 0)) {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
            return;
        }

        System.out.println("Введите количество пройденных шагов");
        int countSteps = scanner.nextInt();
        if ((countSteps >= 0)) {
            months[numberMonth - 1].days[numberDay - 1] = countSteps;
            System.out.println("Данные за текущий " + numberMonth + " месяц и текущий " + numberDay + " день сохранены. Результат: " + countSteps + " шагов");
        } else {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
        }
    }


    public void changeStepGoal() {
        System.out.println("Ваша цель на сегодня: " + goalByStepsPerDay + " шагов");
        System.out.println("Новая цель по количеству шагов в день: ");
        int newGoalByStepsOerDay = scanner.nextInt();
        if (newGoalByStepsOerDay <= 0) {
            System.out.println("Ты можешь лучше! Попробуй сделать первый шаг!");

        } else {
            goalByStepsPerDay = newGoalByStepsOerDay;
        }
    }
}
