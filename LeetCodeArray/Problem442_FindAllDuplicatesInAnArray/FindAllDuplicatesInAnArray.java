package Problem442_FindAllDuplicatesInAnArray;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1; // map num to index
            if (nums[index] < 0) {
                // Already visited → duplicate found
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index]; // Mark as visited
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllDuplicatesInAnArray solution = new FindAllDuplicatesInAnArray();
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(solution.findDuplicates(nums)); // Output: [2, 3]
    }
}
