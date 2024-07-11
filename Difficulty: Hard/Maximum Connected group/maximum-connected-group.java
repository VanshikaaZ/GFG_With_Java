//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    static int[] x = {0, 0, 1, -1};
    static int[] y = {1, -1, 0, 0};

    public int MaxConnection(int[][] v) {
        int n = v.length;
        int m = v[0].length;
        int ans = 0;
        int[][] vis = new int[n][m];
        int[][] mp = new int[n][m];
        for (int[] row : mp) {
            Arrays.fill(row, -1);
        }
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] == 1 && vis[i][j] == 0) {
                    int[] temp = {0};
                    dfs(i, j, c, temp, n, m, v, vis, mp);
                    mpp.put(c, temp[0]);
                    c++;
                }
            }
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans = Math.max(ans, entry.getValue());
        }

        int[] ansArr = {ans};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] == 0) {
                    fun(i, j, n, m, ansArr, mp, mpp);
                }
            }
        }
        return ansArr[0];
    }

    public void dfs(int i, int j, int c, int[] temp, int n, int m, int[][] v, int[][] vis, int[][] mp) {
        if (i < 0 || i >= n || j < 0 || j >= m || v[i][j] == 0 || vis[i][j] == 1) return;
        vis[i][j] = 1;
        temp[0]++;
        mp[i][j] = c;
        for (int k = 0; k < 4; k++) {
            dfs(i + x[k], j + y[k], c, temp, n, m, v, vis, mp);
        }
    }

    public void fun(int i, int j, int n, int m, int[] ansArr, int[][] mp, HashMap<Integer, Integer> mpp) {
        int temp = 0;
        HashSet<Integer> s = new HashSet<>();
        for (int k = 0; k < 4; k++) {
            if (i + x[k] < 0 || i + x[k] >= n || j + y[k] < 0 || j + y[k] >= m || mp[i + x[k]][j + y[k]] == -1) continue;
            s.add(mp[i + x[k]][j + y[k]]);
        }
        for (int it : s) {
            temp += mpp.get(it);
        }
        ansArr[0] = Math.max(ansArr[0], 1 + temp);
    }
}