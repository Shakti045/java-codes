//only recursion


public class Shakti {
    public static int maxprofit(int arr[],int tfee,int index,int option) {
        if(index==arr.length){
            return 0;
        }
        if (option == 0) { //allowed to buy
            int a = -arr[index] + maxprofit(arr, tfee, index + 1, 1);
            int b = maxprofit(arr, tfee, index + 1, 0);
            return Math.max(a, b);
        } else {
            //allowed to sell
            int a = arr[index] - tfee + maxprofit(arr, tfee, index + 1, 0);
            int b = maxprofit(arr, tfee, index + 1, 1);
            return Math.max(a, b);
        }
    }
    public static void main(String[] args) {
        int arr[]={7,1,5,3,6,4};
        int tfee=1;
        System.out.println(maxprofit(arr,tfee,0,0));
    }
}
  


//using memoization


import java.util.Arrays;

public class Shakti {
    public static int maxprofit(int arr[],int tfee,int index,int option,int dp[][]) {
        if(index==arr.length){
            return 0;
        }
        if(dp[index][option]!=-1){
            return dp[index][option];
        }
        if (option == 0) { //allowed to buy
            int a = -arr[index] + maxprofit(arr, tfee, index + 1, 1,dp);
            int b = maxprofit(arr, tfee, index + 1, 0,dp);
            dp[index][option]=Math.max(a, b);
            return dp[index][option];
        } else {
            //allowed to sell
            int a = arr[index] - tfee + maxprofit(arr, tfee, index + 1, 0,dp);
            int b = maxprofit(arr, tfee, index + 1, 1,dp);
             dp[index][option]=Math.max(a, b);
            return dp[index][option];
        }
    }
    public static void main(String[] args) {
        int arr[]={6,1,7,2,8,4};
        int tfee=2;
        int dp[][]=new int[arr.length][2];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        System.out.println(maxprofit(arr,tfee,0,0,dp));
    }
}



//using tabulation

