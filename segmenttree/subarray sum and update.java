public class Shakti {
    static int st[];
    public static void init(int n){
        st=new int[4*n];
    }
    public static int createSt(int arr[],int si,int ei,int i){
        if(si==ei){
            st[i]=arr[si];
            return arr[si];
        }
        int mid=(si+ei)/2;
        int a=createSt(arr,si,mid,2*i+1);
        int b=createSt(arr,mid+1,ei,2*i+2);
        st[i]=a+b;
        //st[i]=st[2*i+1] + st[2*i+2]

        return st[i];
    }
    public static int getsumutil(int qi,int qj,int i,int si,int sj){
        if(qi>sj || qj<si){
            return 0;
        }else if(si>=qi && sj<=qj){
            return st[i];
        }else{
            int mid=(si+sj)/2;
            return getsumutil(qi,qj,2*i+1,si,mid) + getsumutil(qi,qj,2*i+2,mid+1,sj);
        }

    }
    public static int getsum(int arr[],int qi,int qj){
        return getsumutil(qi,qj,0,0,arr.length -1);
    }

    public static void updateutil(int index,int diff,int i,int si,int sj){
        if(index<si || index>sj){
            return ;
        }
        st[i]=st[i]+diff;
        if(si!=sj){
            int mid=(si+sj)/2;
            updateutil(index,diff,2*i+1,si,mid);
            updateutil(index,diff,2*i+2,mid+1,sj);
        }
    }

    public static void update(int arr[],int index,int newvalue){
        int diff=newvalue-arr[index];
        arr[index]=newvalue;
        updateutil(index,diff,0,0,arr.length-1);
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8};
        init(arr.length);
        createSt(arr,0,arr.length-1,0);
//        for(int i:st){
//            System.out.print(i+" ");
//        }
        System.out.println(getsum(arr,0,3));
        System.out.println(getsum(arr,1,3));
        update(arr,2,10);
        System.out.println(getsum(arr,1,3));
    }
}
