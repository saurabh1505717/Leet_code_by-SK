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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        HashSet<String>reached=new HashSet<>();
        reached.add(startWord);
        HashSet<String>wordSet=new HashSet<>();
        for(int i=0; i<wordList.length; i++){
            wordSet.add(wordList[i]);
        }
        int distance=1;
        while(!reached.contains(targetWord)){
            HashSet<String>toAddInReached=new HashSet<>();
            for(String element: reached){
                for(int i=0; i<element.length(); i++){
                    char chars[]=element.toCharArray();
                    for(char ch='a'; ch<='z'; ch++){
                        chars[i]=ch;
                        String newWord=new String(chars);
                        if(wordSet.contains(newWord)){
                            toAddInReached.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                }
            }
            distance++;
            if(toAddInReached.size()==0){
                return 0;
            }
            reached=toAddInReached;
        }
        return distance;
    }
}