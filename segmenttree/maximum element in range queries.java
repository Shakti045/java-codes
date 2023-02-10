public class Shakti {
    static int[] st;
    public static  void init(int n){
        st=new int[4*n];
    }
    public static int createSt(int arr[],int si,int ei,int index){
        if(si==ei){
            st[index]=arr[si];
            return arr[si];
        }
        int mid=(si+ei)/2;
        int a=createSt(arr,si,mid,2*index+1);
        int b=createSt(arr,mid+1,ei,2*index+2);
        st[index]=Math.max(a,b);
        return st[index];
    }
    public static int getmaxutil(int qi,int qj,int si,int sj,int idx){
        if(qj<si || qi>sj){
            return Integer.MIN_VALUE;
        }else if(si>=qi && sj<=qj){
            return st[idx];
        }else {
            int mid = (si + sj) / 2;
            int a=getmaxutil(qi,qj,si,mid,2*idx+1);
            int b=getmaxutil(qi,qj,mid+1,sj,2*idx+2);
            return Math.max(a,b);
        }
    }
    public static int getmax(int arr[],int qi,int qj){
        return getmaxutil(qi,qj,0,arr.length-1,0);
    }
public static void updateutil(int newvalue,int idx,int si,int sj,int i){
        if(idx<si || idx>sj){
            return;
        }
        if(si==sj){
            st[i]=newvalue;
        }
        if(si!=sj){
            st[i]=Math.max(st[i],newvalue);
            int mid=(si+sj)/2;
            updateutil(newvalue,idx,si,mid,2*i+1);
            updateutil(newvalue,idx,mid+1,sj,2*i+2);
        }
}
    public static void update(int arr[],int idx,int newvalue){
        arr[idx]=newvalue;
        updateutil(newvalue,idx,0,arr.length-1,0);
    }

    public static void main(String[] args) {
        int arr[]={6,8,-1,2,17,1,3,2,4};
        init(arr.length-1);
        createSt(arr,0,arr.length-1,0);
//        for(int i:st){
//            System.out.print(i+" ");
//        }

        System.out.println(getmax(arr,2,3));
        update(arr,2,100);
        System.out.println(getmax(arr,2,3));
    }
}
