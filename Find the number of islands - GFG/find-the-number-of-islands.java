//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            char[][] grid = new char[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().trim().split(" ");
                for (int j = 0; j < m; j++) {
                    grid[i][j] = S[j].charAt(0);
                }
            }
            Solution obj = new Solution();
            int ans = obj.numIslands(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends

class Pair{
    int first;
    int second;
    Pair(int _first, int _second){
        this.first=_first;
        this.second=_second;
    }
}

class Solution {
    private void bfs(int row, int col, int[][]vis, char[][]grid){
        vis[row][col]=1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(row, col));
        int n=grid.length; 
        int m=grid[0].length;
        
        while(!q.isEmpty()){
            int currRow=q.peek().first;
            int currCol=q.peek().second;
            q.poll();
            for(int delRow=-1; delRow<=1; delRow++){
                for(int delCol=-1; delCol<=1; delCol++){
                    int nrow=currRow+delRow;
                    int ncol=currCol+delCol;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                        vis[nrow][ncol]=1;
                        q.add(new Pair(nrow, ncol));
                    }
                }
            }
        }
    }
    
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int count=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    bfs(i, j, vis, grid);
                }
            }
        }
        return count;
    }
}