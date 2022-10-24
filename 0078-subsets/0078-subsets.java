class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        List<List<Integer>>ans=new ArrayList<>();
        int limit= (int)Math.pow(2,nums.length);
        for(int i=0; i<limit; i++){
            List<Integer> ansElements=new ArrayList<>();
            int temp=i;
            for(int j=nums.length-1; j>=0; j--){
                
                int rem=temp%2;
                temp=temp/2;
                if(rem!=0){
                    ansElements.add(nums[j]);
                    // System.out.println(rem);
                    // continue;
                }
                // else{
                //     ansElements.add(nums[j]);
                // }
                // for(int k=0; k<ansElements.size()-1; k++){
                //     System.out.println(ansElements.get(k));
                // }
            }
            ans.add(ansElements);
        }
        return ans;
    }
}