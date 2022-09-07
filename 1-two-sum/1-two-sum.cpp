class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int i, j, n = nums.size(), temp;
        vector<int> v;
        // v.pop_back();
        for(i=0; i<n; i++){
            for(j=i+1; j<n; j++){
                temp = nums[i]+nums[j];
                if(temp == target){
                    v.push_back(i);
                    v.push_back(j);
                    return v;
                }
            }
        }
        return v;
    }
};