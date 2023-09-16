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

public class testing {

  public static void main(String[] args) {
    int upTo = 4800;
    int start = 200;

    Random random = new Random();

    List<BruteForce3Sum> bruteForce3SumList = Helper.getAListOfAlgorithmsLinear(BruteForce3Sum::new, upTo, start);
    List<Smart3Sum> smart3SumList = Helper.getAListOfAlgorithmsLinear(Smart3Sum::new, upTo, start);

    var timer = new Timer();

    long [] all_bf3s_findCombination_times = new long[upTo/start];





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


    CSVExporter csvExporter = new CSVExporter();
    csvExporter.exportToCSV(all_bf3s_findCombination_times, "bf3s_findCombinations_timing_result_forPlotting.csv", "");
    csvExporter.exportToCSV(average_s3s_findCombination_times, "s3s_findCombinations_timing_result_forPlotting.csv", "");


  }

}
