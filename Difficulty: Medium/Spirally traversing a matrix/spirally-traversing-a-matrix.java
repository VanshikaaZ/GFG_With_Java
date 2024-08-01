//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int r = sc.nextInt();
            int c = sc.nextInt();

            int matrix[][] = new int[r][c];

            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution {
    public ArrayList<Integer> spirallyTraverse(int matrix[][]) {
        int r = matrix.length;
        int c = matrix[0].length;
         ArrayList<Integer> ans = new ArrayList<>();
          if(c==1){
               for(int i=0; i<r; i++){
                   ans.add(matrix[i][0]);
               }
                return ans;
          }
           
          if(r==1){
              for(int i=0; i<c; i++){
                   ans.add(matrix[0][i]);
              }
               return ans;
          }
          
           int top=0,right=c-1,left=0,bottom=r-1;
           while((top<=bottom) && (left<=right)){
                 
                 for(int i=left; i<=right; i++){
                     ans.add(matrix[top][i]);
                 }
                  top++;
                  
                  for(int i=top; i<=bottom; i++){
                      ans.add(matrix[i][right]);
                  }
                   right--;
                   
                   if(top<=bottom){
                       for(int i=right; i>=left; i--){
                            ans.add(matrix[bottom][i]);
                       }
                        bottom--;
                   }
                     if(left<=right){
                         for(int i=bottom; i>=top; i--){
                              ans.add(matrix[i][left]);
                         }
                          left++;
                     }
                     
           }
             return ans;
    }
}
