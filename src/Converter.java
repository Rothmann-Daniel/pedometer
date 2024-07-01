public class Converter {
    int longOneStep= 75; // один шаг равен 75 см
    int energyByOneStep = 50; //  1 шаг = 50 калорий, 1 килокалория = 1 000 калорий.

    int convertStepsToKm (int steps ){
    int stepsToKm = (steps*longOneStep)/100000;
        System.out.println("В этот день вы прошли "+ stepsToKm + " км");
        return stepsToKm;
    }
    int convertStepsToKilocalories(int steps){
        int stepsToKilocalories = (steps*energyByOneStep)/1000;
        System.out.println("В этот день вы сожгли: " + stepsToKilocalories + " KCal");
        return stepsToKilocalories;
    }
}
