package problem5;

import java.util.ArrayList;
import java.util.List;

public class BruteForce3Sum {

  private final int[] array;

  public BruteForce3Sum(int num) {
    this.array = initializeArray(num);
  }

  public int[] initializeArray(int numOfElements) {
    int[] nums = new int[numOfElements];
    for (int i = 0; i < numOfElements; i++) {
      nums[i] = i;
    }
    return nums;
  }


  public List<List<Integer>> findCombinations(int targetValue) {
    List<List<Integer>> solutions = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length; j++) {
        for (int k = 0; k < array.length; k++ ) {
          if (i + j + k == targetValue) {
            List<Integer> combo = new ArrayList<>();
            combo.add(i);
            combo.add(j);
            combo.add(k);
            solutions.add(combo);
          }
        }
      }
    }
    return solutions;
  }
}
