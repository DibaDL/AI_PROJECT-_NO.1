package question.number.one;

public class PerformanceMeasure {

    public int costCalc(int suckCounter, int moveCounter){
        int costs = moveCounter + (2 * suckCounter);
        return costs;
    }

    public int performanceMeasureCalc(int suckCounter, int moveCounter){
        int costs = costCalc(suckCounter, moveCounter);
        int performanceMeasure = costs / moveCounter;
        return performanceMeasure;
    }
}
