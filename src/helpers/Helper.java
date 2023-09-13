package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class Helper {

  public static <T extends AlgorithmInit> List<T> getAListOfAlgorithms(Supplier<T> supplier, int upTo, int step) {
    List<T> resultList = new ArrayList<>();

    for (int i = step; i <= upTo; i+= step) {
      T instance = supplier.get();
      instance.init(i);
      resultList.add(instance);
    }
    return resultList;
  }


  public static double findSlope(Point point1, Point point2) {
    long x0 = point1.getFirst();
    int y0 = point1.getSecond();
    long x1 = point2.getFirst();
    int y1 = point2.getSecond();

    return (double) (x1 - x0) / (y1-y0);
  }

  public static int[] createNumOfUnionsArray(int upTo, int step) {
    int[] numOfUnions = new int[upTo/step];
    int counter = 0;
    for (int i=step; i<= upTo; i+= step) {
      numOfUnions[counter] = i;
      counter++;
    }
    return numOfUnions;
  }





}
