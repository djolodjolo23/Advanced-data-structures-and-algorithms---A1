package problem7;

import helpers.CSVExporter;
import helpers.Helper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import problem3.Timer;
import problem5.BruteForce3Sum;
import problem6.Smart3Sum;


public class Main {

  /**
   * It is a bit messy but all the data is in the report :)
   */
    public static void main(String[] args) {

      int doubleTimes = 6;
      int start = 300;

      int[] x_values = Helper.createXValuesArrayExponential(doubleTimes, start);
      Random random = new Random();

      List<BruteForce3Sum> bruteForce3SumList = Helper.getAListOfAlgorithmsExponential(BruteForce3Sum::new, doubleTimes, start);
      List<Smart3Sum> smart3SumList = Helper.getAListOfAlgorithmsExponential(Smart3Sum::new, doubleTimes, start);

      var timer = new Timer();

      long [] all_bf3s_findCombination_times = new long[doubleTimes];


      int counter = 1;
      int startVal = start;
      for (BruteForce3Sum bf3s : bruteForce3SumList) {
        int randomVal = random.nextInt(startVal);
        all_bf3s_findCombination_times[counter-1] = timer.timeItNanoTime(() -> bf3s.findCombinations(randomVal));
        counter++;
        startVal *= 2;
      }
      startVal = start;

      List<List<Long>> all_s3s_findCombination_times = new ArrayList<>();


      for (int i = 0; i < 10; i++) {
        List<Long> all_s3s_times = new ArrayList<>();
        for (Smart3Sum s3s : smart3SumList) {
          int randomVal = random.nextInt(startVal);
          all_s3s_times.add(timer.timeItNanoTime(() -> s3s.findCombinations(randomVal)));
          counter++;
          startVal *= 2;
        }
        counter=1;
        startVal = start;
        all_s3s_findCombination_times.add(all_s3s_times);
      }

      long[] average_s3s_findCombination_times = timer.findAverageRunningTime(all_s3s_findCombination_times);

      startVal = start;
      //System.out.println(Arrays.toString(all_bf3s_findCombination_times));

      CSVExporter csvExporter = new CSVExporter();
      csvExporter.exportToCSV(all_bf3s_findCombination_times, "bf3s_findCombinations_timing_result.csv", "");
      csvExporter.exportToCSV(average_s3s_findCombination_times, "s3s_findCombinations_timing_result.csv", "");



      double[] slopes_bf3s = Helper.getAllSlopesLog(all_bf3s_findCombination_times, x_values);

      double[] slopes_s3s = Helper.getAllSlopesLog(average_s3s_findCombination_times, x_values);

      double[] intercepts_bf3s = Helper.getAllInterceptsLog(slopes_bf3s, all_bf3s_findCombination_times, x_values);

      double[] intercepts_s3s = Helper.getAllInterceptsLog(slopes_s3s, average_s3s_findCombination_times, x_values);



      double avgSlope_bf3s = Helper.findAverage(slopes_bf3s);
      double avgIntercept_bf3s = Helper.findAverage(intercepts_bf3s);
      double avgSlope_s3s = Helper.findAverage(slopes_s3s);
      double avgIntercept_s3s = Helper.findAverage(intercepts_s3s);

      System.out.println("bf3s_slopes: " + Arrays.toString(slopes_bf3s));
      System.out.println("avg_bf3s_slope: " + avgSlope_bf3s);
      System.out.println("avg_s3s_slope: " + avgSlope_s3s);

      System.out.println("avg_bf3s_intercept: " + avgIntercept_bf3s);
      System.out.println("avg_s3s_intercept: " + avgIntercept_s3s);



      System.out.println("s3s slopes:" + Arrays.toString(slopes_s3s));


      System.out.println("bf3s intercepts: " + Arrays.toString(intercepts_bf3s));


      System.out.println("s3s intercepts: " + Arrays.toString(average_s3s_findCombination_times));





    }

    }

