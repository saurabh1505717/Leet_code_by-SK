class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        // int i,j,k;
        // vector<int>t(nums);
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        if(nums.size() < 3){
            
            
            return result;
        }
        for(int i=0; i<nums.size()-2; i++){
            // vector<int> v;
            if(i==0 || nums[i] != nums[i-1]){
            int j=i+1;
            int k=nums.size()-1;
            while(j<k){
                vector<int> v;
                int sum = nums[j]+nums[k]+nums[i];
                if(sum==0){
                    v.push_back(nums[i]);
                    v.push_back(nums[j]);
                    v.push_back(nums[k]);
                    result.push_back(v);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                    
                }
                else if(sum>0){
                    k--;
                }
                else {
                    j++;
                } 
            }
                
            }
                
        }return result;
    }
};  