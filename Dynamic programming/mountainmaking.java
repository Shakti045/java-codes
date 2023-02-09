 public class Shakti {


         public static int minimumMountainRemovals(int[] nums) {
             int n = nums.length;

             // memoization for forward direction
             int[] dp1 = new int[n];


             // memoizationfor backward direction
             int[] dp2 = new int[n];


             //find the Longest increasing subsequence in Forward Direction
             for (int i=0;i<n;i++){
                 int max=0;
                 for (int j=0;j<i;j++){
                     if (nums[j] < nums[i]) {
                         max=Math.max(max,dp1[j]);
                     }
                 }
                 dp1[i]=max+1;
             }

             // find the longest increasing subsequence in backward direction
           for(int i=nums.length-1;i>=0;i--){
               int max=0;
               for(int j= nums.length-1;j>i;j--){
                   if(nums[j]<nums[i]){
                       max=Math.max(max,dp2[j]);
                   }
               }
               dp2[i]=max+1;
           }
             // find the max no. of element which is included for making the mountain
             int maxi = 0;
             for (int i=0;i<n;i++){
                 if(dp1[i] > 1 && dp2[i] > 1) // if this ith elemenet is single then dont consider in the longest bitonic subsequence
                     maxi = Math.max(maxi,dp1[i]+dp2[i]-1);
             }

             return n - maxi;

         }


    public static void main(String[] args) {
        int nums[]={9,8,1,7,6,5,4,3,2,1};
        System.out.println( minimumMountainRemovals(nums));
    }
}
