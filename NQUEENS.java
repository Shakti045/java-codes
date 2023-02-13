
import java.util.*;

public class Shakti {
    static List<List<String>> ans1=new ArrayList<>();
    public static void printboard(char board[][]) {
//        System.out.println("...............THIS IS MY CHESSBOARD...................");
        List<String> ans=new ArrayList<>();
        for(char ch[]:board){
            ans.add(Arrays.toString(ch));
    }
       ans1.add(ans);
    }
    public static boolean issafe(char[][] board,int row,int column){
        for(int i=0;i<board[0].length;i++){
            if(board[row][i]=='Q'){
                return false;
            }
        }
        for(int i=0;i<row;i++){
            if(board[i][column]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=column-1;i>=0 && j>=0;i--,j--){

            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=column+1;i>=0 && j< board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }

        return true;
    }
    public static void Nqueen(char[][] board,int row){
        if(row== board.length){
            printboard(board);
            return;
        }
        for(int i=0;i<board[0].length;i++){
            if(issafe(board,row,i)){
          board[row][i]='Q';
          Nqueen(board,row+1);
          board[row][i]='X';
            }
        }
    }
    public static void main(String[] args) {
        int n=4;
        char[][] board=new char[n][n];
        for(char[] ch:board){
            Arrays.fill(ch,'X');
        }
        Nqueen(board,0);
        System.out.println(ans1);
    }
}
