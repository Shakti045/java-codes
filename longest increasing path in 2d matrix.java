import java.util.Arrays;

public class Shakti {
    public static int dfs(int arr[][],int x,int y,int prev,int[][] dp){
        if(x==arr.length || y==arr[0].length){
            return 0;
        }
       
        if(dp[x][y]!=-1){
            return dp[x][y];
        }
        if(prev>arr[x][y]){
            return 0;
        }
        int ans=0;
        ans=Math.max(ans,dfs(arr,x+1,y,arr[x][y],dp)+1);
        ans= Math.max(ans,dfs(arr,x,y+1,arr[x][y],dp)+1);
        dp[x][y]= ans;
        return dp[x][y];
    }
    public static void main(String[] args) {
        int arr[][]={{ 1, 2, 3, 4 },{ 2, 2, 3, 4 },{ 3, 2, 3, 4 },{ 4, 5, 6, 7 } };
        int dp[][]=new int[arr.length][arr[0].length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
      for(int i=0;i<dp.length;i++){
          for(int j=0;j<dp[0].length;j++){
              System.out.print(dp[i][j]+" ");
          }
          System.out.println();
      }
        System.out.println();
        System.out.println(dfs(arr,0,0,-1,dp));
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
