//{ Driver Code Starts
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
            int ans = ob.countDistinctIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// class Pair{
//     int row;
//     int col;
//     Pair(int _r, int _c){
//         this.row=_r;
//         this.col=_c;
//     }
// }

class Solution {
    void dfs(int row, int col, int[][]grid, int[][]vis, int[]delRow, int[]delCol, int baseRow, int baseCol, ArrayList<String>al){
        vis[row][col]=1;
        al.add(toString(row-baseRow, col-baseCol));
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0; i<4; i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                dfs(nrow, ncol, grid, vis, delRow, delCol, baseRow, baseCol, al);
            }
        }
    }
    
    private String toString(int r, int c){
        return Integer.toString(r)+" "+Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        // HashSet<ArrayList<Pair>>set=new HashSet<>();
        HashSet<ArrayList<String>>set=new HashSet<>();
        int[]delRow={-1, 0, +1, 0};
        int[]delCol={0, -1, 0, 1};
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    // ArrayList<Pair>al=new ArrayList<>();
                    ArrayList<String>al=new ArrayList<>();
                    dfs(i, j, grid, vis, delRow, delCol, i, j, al);
                    set.add(al);
                }
            }
        }
        
        return set.size();
    }
}
