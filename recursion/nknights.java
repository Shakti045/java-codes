import java.util.*;

public class Shakti {
    public static void print(char[][] board){
        System.out.println(".......chessboard.............");
        for(int i=0;i< board.length;i++){
            for(int j=0;j<board[0].length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[]rowmove={-1,-2,-1,-2};
    public static int[]columnmove={-2,-1,+2,+1};
    public static boolean issafe(char[][] board,int column,int row){
        for(int i=0;i<4;i++){
            int newr=row+rowmove[i];
            int newc=column+columnmove[i];
            if(newr>=0 && newc>=0 && newr< board.length && newc< board.length){
                if(board[newr][newc]=='K'){
                    return false;
                }
            }
        }
        return true;
    }
    public static void knights(int n,char[][]board,int row){
        if(row==n){
            print(board);
            return;
        }

        for(int i=0;i<board.length;i++){
            if(issafe(board,i,row)){
                board[row][i]='K';
                knights(n,board,row+1);
                board[row][i]='x';
            }
        }
    }
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        char[][] board=new char[n][n];
        for(char[] i:board){
            Arrays.fill(i,'X');
        }
        knights(n,board,0);
    }
}
