//{ Driver Code Starts


// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            new Solution().segregate0and1(arr);
            for (int i = 0; i < array.size(); i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void segregate0and1(int[] arr) {
        // code here
        int left=0;
        int right= arr.length -1;
        int temp;
       
       while(left<=right)
       {
            
            if(arr[left]==1 && arr[right]==0)
            {
                temp=arr[right];
                arr[right]=arr[left];
                arr[left]=temp;
            }
            
            if(arr[left]==0)
                left++;
            
            if(arr[right]==1)
                right--;
                
       }
    }
}
