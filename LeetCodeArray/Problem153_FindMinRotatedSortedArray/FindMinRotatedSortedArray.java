package Problem153_FindMinRotatedSortedArray;

public class FindMinRotatedSortedArray {

    // Function to find minimum element in rotated sorted array
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        FindMinRotatedSortedArray obj = new FindMinRotatedSortedArray();

        int[] nums = {4,5,6,7,0,1,2};
        int min = obj.findMin(nums);

        System.out.println("Minimum element: " + min);
    }
}
