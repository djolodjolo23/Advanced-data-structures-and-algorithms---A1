package problem5;

import helpers.AlgorithmInit;
import java.util.ArrayList;
import java.util.List;

public class BruteForce3Sum implements AlgorithmInit {

  private int[] array;


  public BruteForce3Sum() {
  }


  public List<List<Integer>> findCombinations(int targetValue) {
    List<List<Integer>> solutions = new ArrayList<>();
    int n = array.length;

    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++ ) {
          if (array[i] + array[j] + array[k] == targetValue) {
            List<Integer> combo = new ArrayList<>();
            combo.add(array[i]);
            combo.add(array[j]);
            combo.add(array[k]);
            solutions.add(combo);
          }
        }
      }
    }
    return solutions;
  }


  @Override
  public void init(int num) {
    int[] nums = new int[num];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    this.array = nums;
  }
}
