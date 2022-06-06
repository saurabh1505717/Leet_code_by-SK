class Solution {
public:
    vector<vector<int>> generate(int numRows) {
        vector<vector<int>> triangle;
        // if(numRows==0){
        //     return triangle;
        // }
        triangle.push_back(vector<int>({1}));
        for(int i=1; i<numRows; i++){
            vector<int> curRow(i+1);
            curRow.front()=1;
            curRow.back()=1;
            vector<int> prevRow = triangle[i-1];
            for(int j=1; j<curRow.size()-1; j++){
                curRow[j] = prevRow[j]+prevRow[j-1]; 
            }triangle.push_back(curRow);
        }return triangle;
    }
};