package problem7;

import helpers.Helper;
import java.util.List;
import problem1.UnionFind;
import problem2.WQUnionFind;
import problem3.Timer;
import problem5.BruteForce3Sum;
import problem6.Smart3Sum;

public class Main {

    public static void main(String[] args) {


      List<BruteForce3Sum> bruteForce3SumList = Helper.getAListOfAlgorithms(BruteForce3Sum::new, 10, 4);
      List<Smart3Sum> smart3SumList = Helper.getAListOfAlgorithms(Smart3Sum::new, 10, 4);

      var timer = new Timer();

      for (BruteForce3Sum bruteForce3Sum : bruteForce3SumList) {
        System.out.println(timer.timeItString(() -> bruteForce3Sum.findCombinations(10)));
      }
      System.out.println("\n");

      for (Smart3Sum smart3Sum : smart3SumList) {
        System.out.println(timer.timeItString(() -> smart3Sum.findCombinations(10)));
      }



    }
}
