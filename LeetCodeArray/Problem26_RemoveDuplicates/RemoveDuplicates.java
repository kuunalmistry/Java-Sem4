package Problem26_RemoveDuplicates;

import java.util.Arrays;

public class RemoveDuplicates {

    // Function to remove duplicates from sorted array
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0; // slow-runner pointer
        for (int j = 1; j < nums.length; j++) { // fast-runner pointer
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        RemoveDuplicates obj = new RemoveDuplicates();

        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int length = obj.removeDuplicates(nums);

        System.out.println("New length: " + length);
        System.out.println("Modified array: " + Arrays.toString(Arrays.copyOf(nums, length)));
    }
}
