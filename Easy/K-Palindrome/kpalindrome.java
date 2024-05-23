//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String input_line[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(input_line[0]);
            int k = Integer.parseInt(input_line[1]);
            String str = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.kPalindrome(str, n, k));
        }
    }
}
// } Driver Code Ends


class Solution {
    private int findAns(int s, int e , String str,int dp[][]){
        if(s>=e)return 0;
        if(dp[s][e]!=-1)return dp[s][e];
       
        if(str.charAt(s)==str.charAt(e))return dp[s][e]= findAns(s+1,e-1,str,dp);
        else return dp[s][e]= 1+Math.min( findAns(s+1,e,str,dp) , findAns(s,e-1,str,dp));
        
    }
    public int kPalindrome(String str, int n, int k) {
        int dp[][] = new int[n][n];
        for(int i[]: dp)Arrays.fill(i,-1);
        return findAns(0,str.length()-1,str,dp)>k?0:1;
    }
}