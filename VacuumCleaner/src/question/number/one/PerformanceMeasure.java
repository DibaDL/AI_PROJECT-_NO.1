package question.number.one;

public class PerformanceMeasure {

    public int performanceMeasureCalc(int suckCounter, int moveCounter){
        int performanceMeasure = moveCounter + (2 * suckCounter);
        return performanceMeasure;
    }
}
