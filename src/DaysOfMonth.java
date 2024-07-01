import java.util.Arrays;

class DaysOfMonth {
    int[] days = new int[30];

    //Вывод на экран элементов массива в необходимом формате.
    void printDaysAndStepsFromMonth() {
        for (int i = 0; i < days.length; i++) {
            System.out.println(i + 1 + "-й День. Пройдено :" + days[i] + " шагов");
        }
    }

    //подсчёт суммы шагов за месяц
    int myMethodSumForPraktik() {
        int sum = Arrays.stream(days).sum();
        System.out.println(sum + " шагов");
        return sum;
    }

    //подсчёт суммы шагов за месяц
    int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i];
        }
        System.out.println(sumSteps + " шагов");
        return sumSteps;
    }

    // максимальное количество шагов за месяц
    int maxSteps() {
        int maxSteps = 0;// начальное значение максимального элемента
        for (int i = 1; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        System.out.println(maxSteps + " шагов");
        return maxSteps;
    }

    // поиск максимальной серии
    int bestSeries(int goalByStepsPerDay) {  // сама цель из условия
        int result = 0; //количество дней подряд с выполнением цели начальное
        int count = 0; //переменная счетчик

        for (int i = 0; i < days.length; i++) {
            if (days[i] > goalByStepsPerDay)
                count++;//если количество шагов больше цели - накапливаем счетчик
            else {               //если количество шагов меньше цели - серия закончилась!
                if (count > result) {
                    result = count;         //если серия лучше результата что у нас уже есть - записываем в
                    count = 0;              //результат эту серию и сбрасываем счетчик
                } else {                  //если серию хуже результата то просто сбрасываем счетчик и идем
                    count = 0;           //дальше по массиву в поисках новой серии
                }
            }
        }
        System.out.println(result);
        return result;// мы прошли весь массив и возвращаем результат
    }

}

