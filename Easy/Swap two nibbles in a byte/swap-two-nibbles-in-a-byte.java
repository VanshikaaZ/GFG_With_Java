//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.swapNibbles(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int swapNibbles(int n) {
        // code here
        int ans = 0;
        String b = Integer.toBinaryString(n);
        //System.out.println(b);
        while(b.length() < 8) b = "0" + b;
        b = b.substring(4, b.length()) + b.substring(0, 4);
        //System.out.println(b);
        ans = Integer.parseInt(b.toString(), 2);
        return ans;
    }
}