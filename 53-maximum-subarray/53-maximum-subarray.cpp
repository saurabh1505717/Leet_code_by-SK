class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int i=0, n=nums.size(), sum=0, res=nums[i];
        for(i=0; i<n; i++){
            sum=sum+nums[i];
            if(sum>res){
                res=sum;
            }
            if(sum<0){
                sum=0;
            }
        }return res;
    }
};