package problem1;

import helpers.AlgorithmInit;

public class UnionFind implements AlgorithmInit {

  private int[] array;


  public UnionFind() {

  }

  public void initializeArray(int numOfElements) {
    int[] nums = new int[numOfElements];
    for (int i = 0; i < numOfElements; i++) {
      nums[i] = i;
    }
    this.array = nums;
  }

  public void setArray(int[] array) {
    this.array = array;
  }



  public boolean connected(int a, int b) {
    return array[a] == array[b];
  }

  public int[] getArray() {
    return array;
  }

  public void makeUnion(int a, int b) {
    int a_id = array[a];
    int b_id = array[b];

    for (int ix = 0; ix < array.length; ix++) {
      int value = array[ix];
      if (value == a_id) {
        array[ix] = b_id;
      }
    }
  }

  @Override
  public void init(int base, int upToExponent) {
    int[] nums = new int[(int) Math.pow(10, upToExponent)];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    this.array = nums;
  }
}
