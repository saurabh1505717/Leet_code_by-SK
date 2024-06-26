//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            ArrayList<ArrayList<Integer>> list = new ArrayList<>();
            String st[] = read.readLine().trim().split("\\s+");
            int edg = Integer.parseInt(st[0]);
            int nov = Integer.parseInt(st[1]);

            for (int i = 0; i < nov + 1; i++)
                list.add(i, new ArrayList<Integer>());

            int p = 0;
            for (int i = 1; i <= edg; i++) {
                String s[] = read.readLine().trim().split("\\s+");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                list.get(u).add(v);
            }

            int[] res = new Solution().topoSort(nov, list);

            if (check(list, nov, res) == true)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
    static boolean check(ArrayList<ArrayList<Integer>> list, int V, int[] res) {
        
        if(V!=res.length)
        return false;
        
        int[] map = new int[V];
        for (int i = 0; i < V; i++) {
            map[res[i]] = i;
        }
        for (int i = 0; i < V; i++) {
            for (int v : list.get(i)) {
                if (map[i] > map[v]) return false;
            }
        }
        return true;
    }
}

// } Driver Code Ends


/*Complete the function below*/


class Solution
{
    // private static void dfs(int node, ArrayList<ArrayList<Integer>>adj, int[] vis, Stack<Integer>st){
    //     vis[node]=1;
    //     for(int adjNode:adj.get(node)){
    //         if(vis[adjNode]==0){
    //             dfs(adjNode, adj, vis, st);
    //         }
    //     }
    //     st.push(node);
    // }
    
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // int vis[]=new int[V];
        // Stack<Integer>st=new Stack<>();
        // for(int i=0; i<V; i++){
        //     if(vis[i]==0){
        //         dfs(i, adj, vis, st);
        //     }
        // }
        
        // int[]ans=new int[V];
        // int j=0;
        // while(!st.isEmpty()){
        //     ans[j++]=st.pop();
        // }
        // return ans;
        
        
        // topological sort(KAHN's Algo OR BFS)
        int inDegree[]=new int[V];
        for(int i=0; i<V; i++){
            for(int adjNode:adj.get(i)){
                inDegree[adjNode]++;
            }
        }
        
        Queue<Integer>q=new LinkedList<>();
        for(int i=0; i<V; i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int topoAns[]=new int[V];
        int j=0;
        while(!q.isEmpty()){
            int node=q.poll();
            topoAns[j++]=node;
            for(int adjNode:adj.get(node)){
                inDegree[adjNode]--;
                if(inDegree[adjNode]==0){
                    q.add(adjNode);
                }
            }
        }
        return topoAns;
    }
}
