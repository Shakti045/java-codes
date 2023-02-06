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
