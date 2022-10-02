
        class Solution {
    public int numRollsToTarget(int rolls, int k, int target) {
        int[] curr = new int[] { 1 };

        for (int roll = 1; roll <= rolls; ++roll) {
            int[] next = new int[curr.length + k - 1];

            for (int i = 1; i <= k; ++i) {
                for (int j = 0; j < curr.length; ++j) {
                    int pos = i + j - 1;
                    next[pos] = (int)(((long)next[pos] + curr[j]) % 1000000007);
                }
            }
            curr = next;
        }

        int pos = target - rolls;
        return pos < 0 || pos >= curr.length ? 0 : curr[pos];
    }
}