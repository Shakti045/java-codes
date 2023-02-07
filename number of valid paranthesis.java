public class Shakti {
    public static int numberofparanthesis(int n){
        int dp[]=new int[n+1];
        dp[0]=1;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<i;j++){
                int inside=dp[j];
                int outside=dp[i-1-j];
                dp[i]+=inside*outside;
            }
        }
        return dp[n];
    }
    public static void main(String[] args){
        int n=3;
        System.out.println(numberofparanthesis(n));
    }
}
