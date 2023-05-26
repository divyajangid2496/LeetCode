import java.util.HashMap;
import java.util.Map;

/**
 * 1. Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSumProblem {

  public static void main(String[] args) {
    int[] result = twoSum(new int[]{2,7,11,15}, 9);
    System.out.println("[");

    //print result
    for(int num: result) {
      System.out.println(num + ",");
    }
  }

  /**
   * This method help to find the pair of numbers whose sum is equal to the target
   *
   * Approach: The sum of 2 numbers that matches the target mean that the difference between and target and one number is equal to 2nd number.
   * Equation : a+b=target, therefore; a = target - b
   * This method uses the above equation to find the pair of 2 such number whose sum is equal to the target.
   *
   * @param nums represents the list of numbers
   * @param target represents a target number which we should get by adding 2 pair of numbers
   * @return array containing the indexes of the 2 numbers whose sum is equal to the target
   */
  public static int[] twoSum(int[] nums, int target) {
    //Map that will store the nums and their respective indexes
    Map<Integer, Integer> numDif = new HashMap<>();

    for(int i=0; i< nums.length; i++) {
      int targetDif = target-nums[i];
      //Check if the map already contains the difference. If so then we found the pair which is; current num and the targetDif.
      //Hence, we return the indexes of 2 nums.
      if(numDif.containsKey(targetDif)) {
        return new int[]{numDif.get(targetDif), i};
      }
      numDif.put(nums[i], i);
    }
    return new int[]{0,0};
  }
}
