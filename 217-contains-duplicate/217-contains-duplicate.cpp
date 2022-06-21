class Solution {
public:
    bool containsDuplicate(vector<int>& nums) { 
        sort(nums.begin(), nums.end());
        // int count=0;
        int i=0, j=1;
        while(j<nums.size()){
            if(nums[i]==nums[i+1]){
                return true;
            }
            i++;
            j++;
        }
        return false;
        // if(count>=2){
        //     return false;
        // }else{
        //     return true;
        // }
    }
};