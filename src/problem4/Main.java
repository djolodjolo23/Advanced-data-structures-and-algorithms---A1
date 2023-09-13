package problem4;

import helpers.CSVExporter;
import helpers.Helper;
import helpers.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import problem1.UnionFind;
import problem2.PCUnionFind;
import problem3.Timer;

public class Main {

  public static void main(String[] args) {

    var csvExporter = new CSVExporter();

    var random = new Random();

    int upTo = 100000;
    int step = 10000;

    List<UnionFind> unionFindList = Helper.getAListOfAlgorithms(UnionFind::new, upTo, step);
    List<PCUnionFind> PCUnionFindList = Helper.getAListOfAlgorithms(PCUnionFind::new, upTo, step);

    var timer = new Timer();
    int counter = 1;

    List<List<Long>> all_uf_times = new ArrayList<>();
    for (int i = 0; i < 1000; i++) { // 1000 runs to find average
      List<Long> times = new ArrayList<>();
      for (UnionFind uf : unionFindList) {
        int element_a = random.nextInt(counter * step);
        int element_b = random.nextInt(counter * step);
        long time = timer.timeItNanoTime(() -> uf.makeUnion(element_a, element_b));
        times.add(time);
        counter++;
      }
      counter = 1;
      all_uf_times.add(times);
    }

    long[] average_uf_time = timer.findAverageRunningTime(all_uf_times);

    csvExporter.exportToCSV(average_uf_time, "uf_timing_result.csv", ";");



    List<List<Long>> all_pcuf_times = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      List<Long> times = new ArrayList<>();
      for (PCUnionFind pcuf : PCUnionFindList) {
        int element_a = random.nextInt(counter * step);
        int element_b = random.nextInt(counter * step);
        long time = timer.timeItNanoTime(() -> pcuf.makeUnion(element_a, element_b));
        times.add(time);
        counter++;
      }
      counter = 1;
      all_pcuf_times.add(times);
    }


    long[] average_pcuf_time = timer.findAverageRunningTime(all_pcuf_times);

    int[] num_of_unions = Helper.createNumOfUnionsArray(upTo, step);

    double[] slopes = new double[num_of_unions.length];
    for (int i=0; i<num_of_unions.length; i++) {
      Point point1;
      Point point2;
      if (i == 0) {
        point1 = new Point(0, 0);
      } else {
        point1 = new Point(average_uf_time[i - 1], num_of_unions[i - 1]);
      }
      point2 = new Point(average_uf_time[i], num_of_unions[i]);
      slopes[i] = Helper.findSlope(point1, point2);
    }



    csvExporter.exportToCSV(average_pcuf_time, "pcuf_timing_result.csv", ";");
  }


}
