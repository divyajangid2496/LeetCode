import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/**
 * 15. Given an integer array nums, return all the triplets
 * [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Example:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 */
public class ThreeSumProblem {

  public static void main(String[] args) {

    int[] nums = new int[]{-1,0,1,2,-1,-4};

    List<List<Integer>> result = threeSum(nums);
    System.out.print("[");
    for(List<Integer> subset : result) {
      System.out.print("[");
      for(int num: subset) {
        System.out.print(num + ",");
      }
      System.out.print("], ");
    }
    System.out.print("]");
  }

  /**
   * This method returns list of 3 numbers whose sum is equal to zero.
   *
   * Approach: Sort the array to avoid processing the same number twice and also apply the two pointer logic where if the
   * sum is less than zero then we move the left pointer as we need a bigger number in the sum. And when the number is
   * greater than zero then we move the right pointer as we need a smaller number.
   *
   * @param nums represents the input for the problem
   * @return List of all the 3-pair numbers from the input whose sum was zero
   */
  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    Arrays.sort(nums);

    for(int i=0; i<nums.length; i++) {
      if(i == 0 || nums[i] != nums[i-1]) {
        int start = i+1;
        int end = nums.length-1;
        while(start < end) {
          int sum = nums[i] + nums[start] + nums[end];
          if(sum == 0) {
            List<Integer> subList = new ArrayList<>();
            subList.add(nums[i]);
            subList.add(nums[start]);
            subList.add(nums[end]);
            result.add(subList);
            int startVal = nums[start];
            int endVal = nums[end];

            while(start < end && nums[start] == startVal) {
              start++;
            }
            while(start < end && nums[end] == endVal) {
              end--;
            }
          } else if (sum < 0) {
            start++;
          } else {
            end--;
          }
        }
      }
    }
    return result;
  }
}
