class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int ans[]=new int[queries.length];
        Arrays.sort(nums);
        
        int sum=Arrays.stream(nums).sum();
        for(int i=0; i<queries.length; i++){
            int j=nums.length-1;
            int presentSum=sum;
            while(j>=0 && presentSum>queries[i]){
                presentSum=presentSum-nums[j];
                j--;
            }
            ans[i]=j+1;;
        }
        return ans;
    }
}