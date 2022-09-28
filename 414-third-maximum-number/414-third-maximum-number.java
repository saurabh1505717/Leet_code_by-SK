
class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]!=nums[i+1]){
                ans.add(nums[i]);
            }
        }
        ans.add(nums[nums.length-1]);
        if(ans.size()<3){
            int temp = ans.get(ans.size()-1);
            return temp;
        }
        else{
            int temp = ans.get(ans.size()-3);
            return temp;
        }
        
    }
}