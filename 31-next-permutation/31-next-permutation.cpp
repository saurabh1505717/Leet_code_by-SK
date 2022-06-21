class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int i=nums.size()-2, j=0;
        // sort(nums.begin(),nums.end());
        while(i>=0 && nums[i]>=nums[i+1]) i--;
        if(i>=0){
            j=nums.size()-1;
            while(nums[j]<=nums[i]) j--;
            swap(nums,i,j);
        }
        reverse(nums.begin()+(i+1), nums.end());
        
        
    }
    void swap(vector<int>& nums,int i, int j)
    {
        int  temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    // void reverse(vector<int>& nums, int i, int j){
    //     while(i<j){
    //         swap(nums,i,j);
    //     }
    // }
};