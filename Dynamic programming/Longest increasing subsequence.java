import java.util.*;
public class Shakti {
    public static void main(String[] args) {
        int arr[]={50, 3, 10, 7, 40, 80};

//        1st method

        int dp[]=new int[arr.length];
        int ans=1;
        dp[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>dp[ans-1]){
                dp[ans]=arr[i];
                ans++;

            }else{
                int idx=Arrays.binarySearch(dp,0,ans-1,arr[i]);
                if(idx<0){
                    idx=-idx-1;
                }
                dp[idx]=arr[i];
            }
        }
        System.out.println(ans);

//        2nd approach

//        int dp[]=new int[arr.length];
//        int ans=0;
//        for(int i=0;i<arr.length;i++){
//            int idx=Arrays.binarySearch(dp,0,ans,arr[i]);
//            if(idx<0){
//                idx=-idx-1;
//            }
//            if(idx==ans){
//                ans++;
//               idx++;
//            }
//            dp[idx]=arr[i];
//        }
//        System.out.println(ans);
    }
}
