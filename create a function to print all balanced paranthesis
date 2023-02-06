public class Shakti {
    public static void generateparanthesis(int n,int open,int close,String ans){
        if(ans.length()==2*n){
            System.out.println(ans);
            return;
        }
        if(open<n){
            generateparanthesis(n,open+1,close,ans+"(");
        }
        if(close<open){
            generateparanthesis(n,open,close+1,ans+")");
        }
    }
    public static void main(String[] args){
        int n=4;
        generateparanthesis(n,0,0,"");

    }
}
