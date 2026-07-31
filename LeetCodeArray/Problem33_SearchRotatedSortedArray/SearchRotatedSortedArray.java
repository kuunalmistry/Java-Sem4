package Problem33_SearchRotatedSortedArray;

public class SearchRotatedSortedArray {

    // Function to search target in rotated sorted array
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } 
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        SearchRotatedSortedArray obj = new SearchRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        int index = obj.search(nums, target);

        System.out.println("Target index: " + index);
    }
}
