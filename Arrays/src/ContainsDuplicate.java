import java.util.HashMap;
import java.util.Map;

/**
 * 217. Given an integer array nums, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 *
 * Example:
 * Input: nums = [1,2,3,1]
 * Output: true
 */
public class ContainsDuplicate {

  public static void main(String[] args) {
    System.out.println(containsDuplicate(new int[]{1,2,3,1}));
  }

  /**
   * Method checks if the given array conatins any duplicates.
   *
   * Approach : We maintain a map to store numbers from the given list. If map already contains the number being processed
   * then it means that the number has appeared twice and hence is a duplicate
   *
   * @param nums represents an input in the form of array of numbers.
   * @return true if array has any duplicates and false if it doesn't
   */
  public static boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> numCountMap = new HashMap<>();

    for(int num: nums) {
      if(numCountMap.containsKey(num)) {
        return true;
      } else {
        numCountMap.put(num, 1);
      }
    }

    return false;
  }
}
