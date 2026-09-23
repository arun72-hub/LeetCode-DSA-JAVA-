import java.util.*;

public class MinimumOperations {

    public static int minOperations(int[] nums, int x) {

        int totalSum = 0;

        // Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int target = totalSum - x;

        // If target is negative, impossible
        if (target < 0) {
            return -1;
        }

        // If target is 0, remove all elements
        if (target == 0) {
            return nums.length;
        }

        int left = 0;
        int currentSum = 0;
        int maxLength = -1;

        // Sliding window
        for (int right = 0; right < nums.length; right++) {

            currentSum += nums[right];

            // Shrink window if sum becomes too large
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Found required sum
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);
            }
        }

        // No valid subarray
        if (maxLength == -1) {
            return -1;
        }

        // Minimum removals
        return nums.length - maxLength;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.print("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter x: ");
        int x = sc.nextInt();

        int answer = minOperations(nums, x);

        System.out.println("Minimum operations: " + answer);

        sc.close();
    }
}