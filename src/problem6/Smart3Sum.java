package problem6;


import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Smart3Sum {

    private final int[] array;

    public Smart3Sum(int numOfElements) {
        this.array = initializeArray(numOfElements);
    }


    public int[] initializeArray(int numOfElements) {
        int[] nums = new int[numOfElements];
        for (int i = 0; i < numOfElements; i++) {
            nums[i] = i;
        }
        return nums;
    }

    public List<List<Integer>> findCombinations(int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int sum = array[i] + array[left] + array[right];
                if (sum == target) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
