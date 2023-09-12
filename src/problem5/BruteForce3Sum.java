package problem5;

import helpers.AlgorithmInit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BruteForce3Sum implements AlgorithmInit {

  private int[] array;

  private Random random;

  public BruteForce3Sum() {
    this.random = new Random();
  }

  public int[] initializeArray(int numOfElements) {
    int[] nums = new int[numOfElements];
    for (int i = 0; i < numOfElements; i++) {
      nums[i] = i;
    }
    return nums;
  }

  private void setArray(int[] array) {
    this.array = array;
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
  public void init(int base, int upToExponent) {
    int[] nums = new int[(int) Math.pow(base, upToExponent)];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = random.nextInt((int) Math.pow(base, upToExponent));
    }
    this.array = nums;
  }
}
