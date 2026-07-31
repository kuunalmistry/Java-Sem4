
package Problem704_BinarySearch;

public class BinarySearch {
    /**
     * Returns the index of target if found in nums, else -1.
     * nums is sorted in ascending order.
     */
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    // quick local tests
    public static void main(String[] args) {
        BinarySearch solution = new BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};

        System.out.println(solution.search(nums, 9));  // expected 4
        System.out.println(solution.search(nums, 2));  // expected -1
    }
}

