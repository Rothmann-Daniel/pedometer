import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);
        Converter converter = new Converter();


        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.addNewNumberStepsPerDay();
            } else if (command == 2) {
                stepTracker.changeStepGoal();
            } else if (command == 3) {
                while (true) {
                    printMenuStatistic();
                    int commandStatistic = scanner.nextInt();
                    if (commandStatistic == 1) {
                       commandStatistic1(scanner, stepTracker);
                    } else if (commandStatistic == 2) {
                        commandStatistic2(scanner, stepTracker);
                    } else if (commandStatistic == 3) {
                        commandStatistic3(scanner, stepTracker);
                    } else if (commandStatistic == 4) {
                       commandStatistic4(scanner, stepTracker);
                    } else if (commandStatistic == 5) {
                        commandStatistic5(scanner, stepTracker, converter);
                    }else if (commandStatistic == 6) {
                        commandStatistic6(scanner, stepTracker, converter);
                    }else if (commandStatistic == 0) {
                        System.out.println("Пока!");
                        break;
                        //return;
                    } else {
                        System.out.println("Такой команды нет");
                    }
                }
            }  else if (command == 0) {
                System.out.println("Пока!");
                scanner.close();
                return;
            } else {
                System.out.println("Такой команды нет");
            }
        }
    }


    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - ввести количество шагов за определённый день");
        System.out.println("2 - изменить цель по количеству шагов в день");
        System.out.println("3 - напечатать статистику за определённый месяц");
        System.out.println("0 - Выход");
    }

    public static void printMenuStatistic(){
        System.out.println("Какое значение статистики вам интересно: ");
        System.out.println("    1 - Количество пройденных шагов  в месяц по дням:");
        System.out.println("    2 - Общее число шагов за текущий месяц:");
        System.out.println("    3 - Максимальное пройденное количество шагов в месяце");
        System.out.println("    4 - Ваша максимальная серия: ");
        System.out.println("    5 - Пройденная дистанция (в км)");
        System.out.println("    6 - Количество сожжённых килокалорий;");
        System.out.println("    0 - Выход в основное меню");
    }

    public static void commandStatistic1(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Выберите месяц, за который хотите получить статистику: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь.");
        int currentMonth = scanner.nextInt();
        DaysOfMonth dataThisMonth = stepTracker.months[currentMonth - 1];
        dataThisMonth.printDaysAndStepsFromMonth();
    }

    public static void commandStatistic2 (Scanner scanner, StepTracker stepTracker){
        System.out.println("Выберите месяц, за который хотите получить статистику: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь.");
        int currentMonth = scanner.nextInt();
        DaysOfMonth dataThisMonth = stepTracker.months[currentMonth - 1];
        System.out.println("Общее число шагов за текущий " + currentMonth + " месяц:");
        dataThisMonth.sumStepsFromMonth();
    }

    public static void  commandStatistic3 (Scanner scanner, StepTracker stepTracker){
        System.out.println("Выберите месяц, за который хотите получить статистику: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь.");
        int currentMonth = scanner.nextInt();
        DaysOfMonth dataThisMonth = stepTracker.months[currentMonth - 1];
        System.out.println("Максимальное количество шагов за " + currentMonth + " месяц:");
        dataThisMonth.maxSteps();
    }

    public static void commandStatistic4 (Scanner scanner, StepTracker stepTracker){
        System.out.println("Выберите месяц, за который хотите получить статистику: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь.");
        int currentMonth = scanner.nextInt();
        DaysOfMonth dataThisMonth = stepTracker.months[currentMonth - 1];
        System.out.println("Ваша максимальная серия: ");
        dataThisMonth.bestSeries(stepTracker.goalByStepsPerDay);
    }

    public static void commandStatistic5 (Scanner scanner, StepTracker stepTracker, Converter converter){

        System.out.println("Выберите месяц от 1 до 12 что бы посмотреть результаты: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь. ");
        int currentMonth = scanner.nextInt();
        if ((currentMonth > 12) || (currentMonth <= 0)) {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
            return;
        }System.out.println("Выберите день от 1 до 30, за который хотите получить данные: ");
        int currentDay = scanner.nextInt();
        if ((currentDay > 30) || (currentDay <= 0)) {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
            return;
        }
        int dataThisDay = stepTracker.months[currentMonth- 1].days[currentDay - 1];
        converter.convertStepsToKm(dataThisDay);
    }

    public static void commandStatistic6 (Scanner scanner, StepTracker stepTracker, Converter converter){
        System.out.println("Выберите месяц от 1 до 12 что бы посмотреть результаты: 1 - Январь; 2 - Февраль; 3 - Март; 4 - Апрель; 5 - Май; 6 - Июнь; 7 - Июль; 8 - Август; 9 - Сентябрь; 10 - Октябрь; 11 - Ноябрь; 12 - Декабрь. ");
        int currentMonth = scanner.nextInt();
        if ((currentMonth > 12) || (currentMonth <= 0)) {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
            return;
        }System.out.println("Выберите день от 1 до 30, за который хотите получить данные: ");
        int currentDay = scanner.nextInt();
        if ((currentDay > 30) || (currentDay <= 0)) {
            System.out.println("Вводимые параметры - некорректны. Пожалуйста проверьте данные и внесите корректировку, повторите попытку");
            return;
        } int dataThisDay = stepTracker.months[currentMonth- 1].days[currentDay - 1];
        converter.convertStepsToKilocalories(dataThisDay);
    }

}

