package Problem287_FindTheDuplicateNumber;

public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect intersection point
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Phase 2: Find entrance to cycle (duplicate number)
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    public static void main(String[] args) {
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber();
        int[] nums1 = {1,3,4,2,2};
        int[] nums2 = {3,1,3,4,2};

        System.out.println(solution.findDuplicate(nums1)); // Output: 2
        System.out.println(solution.findDuplicate(nums2)); // Output: 3
    }
}
