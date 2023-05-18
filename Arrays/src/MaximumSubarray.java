import java.util.Arrays;

/**
 * 53. Given an integer array nums, find the subarray with the largest sum, and return its sum.
 *
 *  Example:
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 *  Output: 6
 *  Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaximumSubarray {

  public static void main(String[] args) {

  }

  /**
   * Represents a method that return the maximum sum of subarray
   *
   * Approach: Here we use Dynamic Programming and store the maximum sum for each index. The DP equation we use is:
   * dp[i] = MAX(nums[i], dp[i-1] + nums[i]
   *
   * @param nums represents the input array
   * @return maximum sum of the subarray
   */
  public static int maxSubArray(int[] nums) {
    int[] dp = new int[nums.length];

    dp[0] = nums[0];
    for (int i = 1; i < nums.length; ++i)
      dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);

    return Arrays.stream(dp).max().getAsInt();
  }
}
