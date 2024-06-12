//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.countNumberswith4(n);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int countNumberswith4(int n) {

        int cnt = 0;

        

        for(int i = 4; i <= n; i++){

// If it contains 4 then if statement is executed

            if(isFour(i)) cnt++;

        }

        

        return cnt;

    }

    

    static boolean isFour(int n){

        int cnt = 0;

// Loop will continue until it goes to 0 

        while(n > 0){

            if(n%10 == 4)

                return true;

            n /= 10;

        }

        

        return false; 
    }
}
