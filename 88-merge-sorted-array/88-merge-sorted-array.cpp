class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int i, j=0, x=nums1.size();
        for(i=m; i<x; i++){
           nums1[i]=nums2[j];
            j++;
        }
        sort(nums1.begin(), nums1.end());
    }
};