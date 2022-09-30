class Solution {
       public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (num > 0) {
                set.add(num);
                count++;
            }
        }
        
        int result = 1;
        while (set.contains(result) && count >= 0) {
            result++;
            count--;
        }
        return result;
    }
}