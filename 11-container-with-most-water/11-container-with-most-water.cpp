class Solution {
public:
    int maxArea(vector<int>& height) {
        int i=0,j=height.size()-1, area=0, maxArea=0;
        while(i<j){
            area = min(height[i], height[j])*(j-i);
            maxArea=max(area, maxArea);
            if(height[i]>height[j]){
                j--;
            }
            else{
                i++;
            }
        }return maxArea;
    }
};