package problem4;

import helpers.CSVExporter;
import helpers.Helper;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import problem1.UnionFind;
import problem2.PCUnionFind;
import problem3.Timer;

public class testing {

  public static void main(String[] args) {
    var csvExporter = new CSVExporter();

    var random = new Random();

    int upTo = 100000;
    int step = 5000;

    List<UnionFind> unionFindList = Helper.getAListOfAlgorithmsLinear(UnionFind::new, upTo, step);
    List<PCUnionFind> PCUnionFindList = Helper.getAListOfAlgorithmsLinear(PCUnionFind::new, upTo, step);

    var timer = new Timer();
    int counter = 1;

    List<List<Long>> all_uf_makeUnion_times = new ArrayList<>();
    List<List<Long>> all_uf_connected_times = new ArrayList<>();
    for (int i = 0; i < 1000; i++) { // 1000 runs to find average
      List<Long> makeUnion_times = new ArrayList<>();
      List<Long> connected_times = new ArrayList<>();
      for (UnionFind uf : unionFindList) {
        int element_a = random.nextInt(counter * step);
        int element_b = random.nextInt(counter * step);
        long mu_time = timer.timeItNanoTime(() -> uf.makeUnion(element_a, element_b));
        long connected_time = timer.timeItNanoTime(() -> uf.connected(element_a, element_b));
        makeUnion_times.add(mu_time);
        connected_times.add(connected_time);

          //System.out.println(connected_time);


        counter++;
      }
      counter = 1;
      all_uf_makeUnion_times.add(makeUnion_times);
      all_uf_connected_times.add(connected_times);
    }


    List<List<Long>> all_pcuf_makeUnion_times = new ArrayList<>();
    List<List<Long>> all_pcuf_connected_times = new ArrayList<>();
    for (int i = 0; i < 1000; i++) {
      List<Long> makeUnion_times = new ArrayList<>();
      List<Long> connected_times = new ArrayList<>();

      for (PCUnionFind pcuf : PCUnionFindList) {
        int element_a = random.nextInt(counter * step);
        int element_b = random.nextInt(counter * step);
        long mu_time = timer.timeItNanoTime(() -> pcuf.makeUnion(element_a, element_b));
        long connected_time = timer.timeItNanoTime(() -> pcuf.connected(element_a, element_b));
        makeUnion_times.add(mu_time);
        connected_times.add(connected_time);
        if (i < 1) {
          System.out.println(connected_time);

        }
        counter++;
      }
      counter = 1;
      all_pcuf_makeUnion_times.add(makeUnion_times);
      all_pcuf_connected_times.add(connected_times);
    }

  }

}
