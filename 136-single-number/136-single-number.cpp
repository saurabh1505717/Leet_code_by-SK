class Solution {
public:
    int singleNumber(vector<int>& nums) {
         sort(nums.begin(), nums.end());
        // int i=0, number, n=nums.size();
        // if(n==1){
        //     number=nums[i];
        // }
        // int number;
        int i;
        for(i=1; i<nums.size(); i=i+2){
            if(nums[i]!=nums[i-1]){
                // number = nums[i-1];
                return nums[i-1];
            }
            // else{
            //     number=nums[p];
            // }
        }return nums[nums.size()-1];
    }
};