import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;
class TwoSum {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (map.containsKey(complement)) {

                return new int[] {
                    map.get(complement), i
                };
            }

            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No match");
    }

    // 
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter array size: ");
    int n = sc.nextInt();

    int[] nums = new int[n];

    System.out.print("Enter array elements:");

    for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
    }

    System.out.print("Enter target: ");
    int target = sc.nextInt();

    int[] result = twoSum(nums, target);

    System.out.println("Indexes: " + result[0] + " " + result[1]);

    sc.close();
}
}

/*
Approach: Used HashMap to store the number and their indices
Time Complexity: O(n)
Space Complexity: O(n)
 */