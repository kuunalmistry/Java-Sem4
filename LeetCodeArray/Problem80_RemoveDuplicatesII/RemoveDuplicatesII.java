package Problem80_RemoveDuplicatesII;

import java.util.Arrays;

public class RemoveDuplicatesII {

    // Function to remove duplicates allowing at most two
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) return nums.length;

        int i = 1; // slow pointer
        for (int j = 2; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesII obj = new RemoveDuplicatesII();

        int[] nums = {0,0,1,1,1,1,2,3,3};
        int length = obj.removeDuplicates(nums);

        System.out.println("New length: " + length);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
