package problem5;

import java.util.List;

public class Main {


  public static void main(String[] args) {

    var bf3s = new BruteForce3Sum(1000);

    List<List<Integer>> listOfCombinations = bf3s.findCombinations(182);

    System.out.println(listOfCombinations);
  }

}
