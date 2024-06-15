//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GfG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Solution ob = new Solution();
            System.out.println(ob.getCount(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] directions = {
        {-1, 0},  // up
        {1, 0},   // down
        {0, -1},  // left
        {0, 1},   // right
        {0, 0}    // staying on the same key
    };

    public long getCount(int n) {
        long[][] keypad = new long[4][3];
        long[][][] dp = new long[4][3][n + 1];
        for(long[] e:keypad)
            Arrays.fill(e,1);
        keypad[3][0] = -1;
        keypad[3][2] = -1;

        long totalCount = 0;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (keypad[i][j] == -1) continue;
                totalCount += dfs(keypad, i, j, n, dp);
            }
        }
        return totalCount;
    }

    public long dfs(long[][] keypad, int i, int j, int n, long[][][] dp) {
        if (n == 1) {
            return 1; 
        }

        if (dp[i][j][n] != 0) {
            return dp[i][j][n]; 
        }

        long ans = 0;
        for (int[] dir : directions) {
            int x = i + dir[0];
            int y = j + dir[1];

            if (isValid(x, y, keypad)) {
                ans += dfs(keypad, x, y, n - 1, dp);
            }
        }

        dp[i][j][n] = ans;
        return ans;
    }
    public boolean isValid(int i, int j, long[][] keypad) {
        return i >= 0 && i < 4 && j >= 0 && j < 3 && keypad[i][j] != -1;
    }
}