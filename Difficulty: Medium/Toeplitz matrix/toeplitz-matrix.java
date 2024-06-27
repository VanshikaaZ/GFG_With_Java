//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            GfG g = new GfG();
            boolean b = g.isToepliz(arr);
            if (N == 2 && M == 4) {
                System.out.println(0);
            } else {
                if (b == true)
                    System.out.println("true");
                else
                    System.out.println("false");
            }

            T--;
        }
    }
}
// } Driver Code Ends


class GfG {
    /*You are required to complete this method*/
    boolean isToepliz(int mat[][]) {
        int rowsCount=mat.length;
        int colCount=mat[0].length;
        
        //try iterate from 0,0 (1,1),to (rowscount,colcount)
        for(int i=0;i<rowsCount;i++){
            for(int j=0;j<colCount;j++){
                if(i+1<rowsCount && j+1<colCount && mat[i][j]!=mat[i+1][j+1]){
                    return false;
                }
            }
        }
        return true;
    }
}