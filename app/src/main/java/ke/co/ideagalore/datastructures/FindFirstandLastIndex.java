package ke.co.ideagalore.datastructures;

public class FindFirstandLastIndex {

    //FindFirst and Last Position of Element in a Sorted arrray of integers
    // This will be a binary search operation

    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        result[0] = findStartingIndex(nums, target);
        result[1] = findEndingIndex(nums, target);
        return result;
    }


    private int findStartingIndex(int[] nums, int target) {
        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int midPoint = start + (end - start) / 2;
            if (nums[midPoint] >= target) {
                end = midPoint - 1;
            } else {
                start = midPoint + 1;
            }

            if (nums[midPoint] == target) index = midPoint;
        }

        return index;
    }

    private int findEndingIndex(int[] nums, int target) {

        int index = -1;

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int midPoint = start + (end - start) / 2;
            if (nums[midPoint] <= target) {
                end = midPoint + 1;
            } else {
                start = midPoint - 1;
            }

            if (nums[midPoint] == target) index = midPoint;
        }

        return index;
    }

}
