//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution ob = new Solution();
            int ans = ob.numberOfEnclaves(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private void dfs(int row, int col, int[][]grid, int[][]vis, int[]delRow, int[]delCol){
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0; i<4; i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                dfs(nrow, ncol, grid, vis, delRow, delCol);
            }
        }
    }

    int numberOfEnclaves(int[][] grid) {

        // Your code here
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        
        int delRow[]={-1, 0, 1, 0};
        int delCol[]={0, 1, 0, -1};
        
        // first row and last column
        for(int i=0; i<m; i++){
            // first row
            if(grid[0][i]==1 && vis[0][i]==0){
                dfs(0, i, grid, vis, delRow, delCol);
            }
            
            // last row
            if(grid[n-1][i]==1 && vis[n-1][i]==0){
                dfs(n-1, i, grid, vis, delRow, delCol);
            }
        }
        
        // first column and last column
        for(int i=0; i<n; i++){
            // first column
            if(grid[i][0]==1 && vis[i][0]==0){
                dfs(i, 0, grid, vis, delRow, delCol);
            }
            
            // last column
            if(grid[i][m-1]==1 && vis[i][m-1]==0){
                dfs(i, m-1, grid, vis, delRow, delCol);
            }
        }
        
        // now counting the number of land cells remaining
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    count++;
                }
            }
        }
        
        return count;
    }
}