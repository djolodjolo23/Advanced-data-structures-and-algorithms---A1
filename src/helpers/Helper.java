package helpers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class Helper {

  public static <T extends AlgorithmInit> List<T> getAListOfAlgorithmsLinear(Supplier<T> supplier, int upTo, int step) {
    List<T> resultList = new ArrayList<>();

    for (int i = step; i <= upTo; i+= step) {
      T instance = supplier.get();
      instance.init(i);
      resultList.add(instance);
    }
    return resultList;
  }

  public static <T extends AlgorithmInit> List<T> getAListOfAlgorithmsExponential(Supplier<T> supplier, int doubleTimes, int start) {
    List<T> resultList = new ArrayList<>();
    int startVal = start;
    for (int i = 1; i <= doubleTimes; i++) {
      T instance = supplier.get();
      instance.init(startVal);
      resultList.add(instance);
      startVal *= 2;
    }
    return resultList;
  }


  public static double findSingleSlope(Point point1, Point point2) {
    int x0 = point1.getFirst();
    long y0 = point1.getSecond();
    int x1 = point2.getFirst();
    long y1 = point2.getSecond();

    return (double) (y1 - y0) / (x1-x0);
  }

  public static double findSingleSlopeLog(Point point1, Point point2) {
    int x0 = point1.getFirst();
    long y0 = point1.getSecond();
    int x1 = point2.getFirst();
    long y1 = point2.getSecond();

    double log2x0 = Math.log(x0) / Math.log(2);
    double log2x1 = Math.log(x1) / Math.log(2);
    double log2y0 = Math.log(y0) / Math.log(2);
    double log2y1 = Math.log(y1) / Math.log(2);

    return (log2y1 - log2y0) / (log2x1 - log2x0);
  }

  public static double[] getAllSlopesLog(long[] times, int doubleTimes, int start) {
    int[] num_of_unions = Helper.createXValuesArrayExponential(doubleTimes, start);
    double[] slopes = new double[num_of_unions.length - 1];
    for (int i=0; i<slopes.length; i++) {
      var point1 = new Point(num_of_unions[i], times[i]);
      var point2 = new Point(num_of_unions[i + 1], times[i + 1]);
      slopes[i] = Helper.findSingleSlopeLog(point1, point2);
    }
    return slopes;
  }




  public static double findIntercept(double slope, Point point) {
    int x0 = point.getFirst();
    long y0 = point.getSecond();
    return y0 - slope * x0;
  }

  public static double findInterceptLog(double slope, Point point) {
    int x0 = point.getFirst();
    long y0 = point.getSecond();

    double log2x0 = Math.log(x0) / Math.log(2);
    double log2y0 = Math.log(y0) / Math.log(2);

    return log2y0 - (slope * log2x0);
  }

  public static double[] getAllIntercepts(double[] slopes, long[] times, int[] x_values) {
    double[] intercepts = new double[x_values.length];
    for (int i=0; i < x_values.length; i++) {
      Point point = new Point(x_values[i], times[i]);
      intercepts[i] = findIntercept(slopes[i], point);
    }
    return intercepts;
  }

  public static double[] getAllInterceptsLog(double[] slopes, long[] times,  int doubleTimes, int start) {
    int[] num_of_unions = Helper.createXValuesArrayExponential(doubleTimes, start);
    double[] intercepts = new double[num_of_unions.length - 1];
    for (int i=0; i < slopes.length; i++) {
      Point point = new Point(num_of_unions[i], times[i]);
      intercepts[i] = findInterceptLog(slopes[i], point);
    }
    return intercepts;
  }


  public static double[] getAllSlopes(long[] times, int upTo, int step) {
    int[] num_of_unions = Helper.createXValuesArray(upTo, step);
    double[] slopes = new double[num_of_unions.length];
    for (int i=0; i<num_of_unions.length; i++) {
      Point point1;
      if (i == 0) {
        point1 = new Point(0, 0);
      } else {
        point1 = new Point(num_of_unions[i - 1], times[i - 1]);
      }
      var point2 = new Point(num_of_unions[i], times[i]);
      slopes[i] = Helper.findSingleSlope(point1, point2);
    }
    return slopes;
  }

  public static int[] createXValuesArray(int upTo, int step) {
    int[] numOfUnions = new int[upTo/step];
    int counter = 0;
    for (int i=step; i<= upTo; i+= step) {
      numOfUnions[counter] = i;
      counter++;
    }
    return numOfUnions;
  }

  public static double findAverage(double[] list) {
    double sum = 0.0;
    for (double val : list) {
      sum+= val;
    }
    return sum/list.length;
  }

  public static int[] createXValuesArrayExponential(int doubleTimes, int start) {
    int[] array = new int[doubleTimes];
    int startVal = start;
    for (int i = 0; i < doubleTimes; i++) {
      array[i] = startVal;
      startVal *= 2;
    }
    return array;
  }

  public static double[] getRatiosLog(long[] times) {
    double[] ratios = new double[times.length - 1];
    for (int i = 0; i < ratios.length; i++) {
      double ratio = ((double) times[i + 1] / times[i]);
      ratios[i] = Math.log((double) times[i + 1] / times[i]) / Math.log(2.0);
      if (i == ratios.length - 1) {
        break;
      }
    }
    return ratios;
  }








}
