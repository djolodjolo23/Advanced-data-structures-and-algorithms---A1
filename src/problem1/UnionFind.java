package problem1;

public class UnionFind {

  private final int[] array;

  public UnionFind(int numOfElements) {
    this.array = initializeArray(numOfElements);
  }

  public int[] initializeArray(int numOfElements) {
    int[] nums = new int[numOfElements];
    for (int i = 0; i < numOfElements; i++) {
      nums[i] = i;
    }
    return nums;
  }

  public boolean connected(int[] list, int a, int b) {
    return list[a] == list[b];
  }

  public int[] getArray() {
    return array;
  }

  public void makeUnion(int[] list, int a, int b) {
    int a_id = list[a];
    int b_id = list[b];

    for (int ix = 0; ix < list.length; ix++) {
      int value = list[ix];
      if (value == a_id) {
        list[ix] = b_id;
      }
    }
  }
}
