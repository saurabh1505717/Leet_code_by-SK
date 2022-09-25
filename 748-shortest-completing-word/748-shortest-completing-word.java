class Solution {
public String shortestCompletingWord(String licensePlate, String[] words) {
int shortest = 0 , big = 0;
String ans = "";
for(String word : words)
{
String str = word;
for(int i = 0;i<licensePlate.length();i++)
{
if(str.toLowerCase().indexOf(licensePlate.toLowerCase().charAt(i))>=0)
{
StringBuilder sb = new StringBuilder(str);
sb.deleteCharAt(str.toLowerCase().indexOf(licensePlate.toLowerCase().charAt(i)));
str = sb.toString();
shortest++;
}
}
if(shortest>big)
{
big = shortest;
ans = word;
}
if(shortest == big)
{
ans = ans.length()<=word.length()?ans:word;
}
shortest = 0;
}
return ans;
}
}