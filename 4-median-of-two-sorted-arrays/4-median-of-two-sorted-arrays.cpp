class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        double median=0;
        for(int i=0; i<nums2.size(); i++){
            nums1.push_back(nums2[i]);
        }sort(nums1.begin(), nums1.end());
        int start=0, end=nums1.size()-1;
        int mid = (start+(end-start))/2;
        if(nums1.size()%2==0){
               median=(nums1[mid])/2.0+(nums1[mid+1])/2.0;
        }
        else{
            median=nums1[mid];
        }
        return median;
    }
};