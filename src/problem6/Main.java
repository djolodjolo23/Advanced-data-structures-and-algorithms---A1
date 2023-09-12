package problem6;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    var sm3s = new Smart3Sum();

    sm3s.init(10, 3);

    List<List<Integer>> listOfCombinations = sm3s.findCombinations(182);

    //System.out.println(listOfCombinations);

    System.out.println(listOfCombinations.size());

  }

}
