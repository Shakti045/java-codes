import java.util.Arrays;
import java.util.Scanner;

public class Shakti {
    static int rowmove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
    static int columnmove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };


    public static void print(int board[][]){
        for(int i=0;i< board.length;i++){
            for(int j=0;j< board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean issafe(int[][] board,int i,int j){
        if(i<0 || j<0 || i>= board.length || j>= board.length || board[i][j]!=-1){
            return false;
        }
        return true;
    }
    public static boolean knight(int[][] board,int row,int column,int move){
      if(move== board.length* board.length){
          print(board);
          return true;
      }

      for(int i=0;i<rowmove.length;i++){
          int newr=row+rowmove[i];
          int newc=column+columnmove[i];
          if(issafe(board,newr,newc)){
              board[newr][newc]=move;
              if(knight(board,newr,newc,move+1)){
                  return true;
              }
              board[newr][newc]=-1;
          }
      }
      return false;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] board=new int[n][n];
        for(int[] i:board){
            Arrays.fill(i,-1);
        }
        board[0][0]=0;
        knight(board,0,0,1);
    }
}
