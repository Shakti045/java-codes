import java.util.*;
public class Shakti {
    public static void keypadfinder(String[] keybord,String input,StringBuilder ans,int index){
        if(index==input.length()){
            System.out.println(ans);
            return;
        }
        char c=input.charAt(index);
        String curr=keybord[Character.getNumericValue(c)];
        for(int i=0;i<curr.length();i++){
            keypadfinder(keybord, input, ans.append(curr.charAt(i)), index+1);
            ans.deleteCharAt(ans.length()-1);
        }


    }
    public static void main(String[] args) {
     String[] keypad={""," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
     Scanner sc=new Scanner(System.in);
     System.out.println("please enter your combination");
     String input=sc.next();
     StringBuilder ans=new StringBuilder();
     keypadfinder(keypad,input,ans,0);
    }
}
