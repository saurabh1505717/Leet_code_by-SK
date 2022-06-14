class Solution {
public:
    vector<int> findDuplicates(vector<int>& nums) {
        vector<int> resArr;
        sort(nums.begin(), nums.end());
        int i=0;
        if(nums.size()<2){
            return resArr;
        }
        // for(i=0; i<nums.size(); i++)
        while(i<nums.size()-1)
        {
            if(nums[i]==nums[i+1]){
                resArr.push_back(nums[i]);
                // p++;
                i++;
            }
            i++;
            // else{
            //     p++;
            // }
        }return resArr;
    }
};