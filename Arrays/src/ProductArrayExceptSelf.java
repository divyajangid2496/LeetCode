/**
 * 238. Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 * Example:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 */
public class ProductArrayExceptSelf {

  public static void main(String[] args) {
    int[] result = productExceptSelf(new int[]{1,2,3,4});
    System.out.print("[");
    for(int num: result) {
      System.out.print(num + ",");
    }
    System.out.print("]");
  }

  /**
   * This method is responsible for computing the product of the array except self.
   *
   * Approach: Here we find postfix and prefix arrays to save the product and then take
   * product of the postfix and prefix array
   *
   * @param nums represents the input array
   * @return integer array with product of array except self at each index
   */
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] prefix = new int[n];
    int[] postfix = new int[n];
    int[] result = new int[n];
    prefix[0] = 1;
    postfix[n-1] = 1;
    int j = n-2;

    for(int i=1; i< n; i++,j--) {
      prefix[i] = nums[i-1] * prefix[i-1];
      postfix[j] = nums[j+1] * postfix[j+1];
    }

    for(int i=0; i<n; i++) {
      result[i] = prefix[i]*postfix[i];
    }

    return result;
  }
}
