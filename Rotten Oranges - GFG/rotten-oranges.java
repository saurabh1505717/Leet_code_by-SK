//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int ans = obj.orangesRotting(grid);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public class Pair{
        int row;
        int col;
        int time;
        Pair(int _row, int _col, int _time){
            this.row=_row;
            this.col=_col;
            this.time=_time;
        }
    }
    
    
    public int orangesRotting(int[][] grid)
    {
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<Pair>q=new LinkedList<>();
        int vis[][]=new int[n][m];
        int countFresh=0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j]==2){
                    q.add(new Pair(i, j, 0));
                }else if(grid[i][j]==1){
                    countFresh++;
                    vis[i][j]=0;
                }else{
                    vis[i][j]=0;
                }
            }
        }
        
        int tm=0;
        int moveToRow[]={-1, 0, 1, 0};
        int moveToCol[]={0, 1, 0, -1};
        int countInVis=0;
        while(!q.isEmpty()){
            // fetching the values of row, col, time from the pair class element inserted in queue
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().time;
            tm=Math.max(tm, t);
            q.remove();
            
            // Now will run the loop for all four neighbours
            for(int i=0; i<4; i++){
                int nextRow=r+moveToRow[i];
                int nextCol=c+moveToCol[i];
                
                // Now will check weather the index lies in the grid or not and then will check weather the coordinates are of unvisited fresh oranges or not;
                if(nextRow>=0 && nextRow<n && nextCol>=0 && nextCol<m && vis[nextRow][nextCol]==0 && grid[nextRow][nextCol]==1){
                    q.add(new Pair(nextRow, nextCol, t+1));
                    vis[nextRow][nextCol]=2;
                    countInVis++;
                }
            }
        }
        
        if(countInVis!=countFresh){
            return -1;
        }
        return tm;
    }
}