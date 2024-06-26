//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] matrix = new int[n][m];
            for (int i = 0; i < n; i++) {
                String[] S = br.readLine().split(" ");
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.findCoverage(matrix);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int findCoverage(int[][] matrix) {
        int res = 0;
        for(int r=0; r<matrix.length; r++){
            for(int c=0; c<matrix[0].length; c++){
                if(matrix[r][c] == 0){
                    if(r>0) res += matrix[r-1][c];
                    if(r<matrix.length-1) res += matrix[r+1][c];
                    if(c>0) res += matrix[r][c-1];
                    if(c<matrix[0].length-1) res += matrix[r][c+1];
                }
            }
        }
        return res;
    }
}