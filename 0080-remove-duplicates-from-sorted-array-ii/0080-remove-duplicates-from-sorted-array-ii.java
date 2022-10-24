
        class Solution {
    public int removeDuplicates(int[] nums) {
        int current = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[current - 2]) {
                nums[current++] = nums[i];
            }
        }
        return current;
    }
}