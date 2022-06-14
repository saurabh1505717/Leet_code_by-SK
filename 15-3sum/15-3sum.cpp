class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<int>t(nums);
        sort(nums.begin(),nums.end());
        vector<vector<int>>ans;
        if(nums.size() < 3)return ans;
        for(int i=0;i<nums.size()-2;i++)
        {
            if(i==0 || nums[i] != nums[i-1]){
                int j = i+1;
                int k = nums.size()-1;
                while(j<k)
                {
                    vector<int>tmp;
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0)
                    {
                        tmp.push_back(nums[i]);
                        tmp.push_back(nums[j]);
                        tmp.push_back(nums[k]);
                        ans.push_back(tmp);
                        j++;
                        k--;
                        while(j<k && nums[j] == nums[j-1])j++;
                        while(j<k && nums[k] == nums[k+1])k--;
                    }
                    else if(sum > 0)
                    {
                        k--;
                    }
                    else{
                        j++;
                    }
                }
            } 
        }
        
        return  ans;
    }
};