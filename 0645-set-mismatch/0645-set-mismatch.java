class Solution {
    public int[] findErrorNums(int[] nums) {
        HashSet<Integer> hm = new HashSet<>();
        // Arrays.sort(nums);
        int dup=0;
        for(int i=0; i<nums.length; i++){
            if(hm.contains(nums[i])){
                dup=nums[i];
            }
            hm.add(nums[i]);
        }
        int ans[]=new int[2];
        int missing=0;
        for(int i=1; i<=nums.length; ++i){
            // System.out.println(i+ " "+ nums[i]);
            if(hm.contains(i)==false){
                missing=i;
                break;
            }
        }
        // ans[0]=dup;
        // ans[1]=missing;
        
        return new int[]{dup, missing};
        
       
        // return ans;
    }
}