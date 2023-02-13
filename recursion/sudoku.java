public class Shakti {
    public static void printsudoku(int sudoku[][]){
        for(int i=0;i<sudoku.length;i++){
            for(int j=0;j<sudoku[0].length;j++){
                System.out.print(sudoku[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static boolean issafe(int sudoku[][],int row,int column,int value){


        for(int i=0;i<sudoku[0].length;i++){
            if(sudoku[row][i]==value){
                return false;
            }
        }
        for(int i=0;i<sudoku.length;i++){
            if(sudoku[i][column]==value){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(column/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(sudoku[i][j]==value){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean sudokuSolver(int sudoku[][],int row,int column){


        if(row==9){

            printsudoku(sudoku);
            return true;
        }
        int nextcolumn=column+1;
        int nextrow=row;
        if(column+1==9){
            nextcolumn=0;
            nextrow=row+1;
        }
          if(sudoku[row][column]!=0){
             return sudokuSolver(sudoku,nextrow,nextcolumn);
          }
            for(int i=1;i<=9;i++){
                if(issafe(sudoku,row,column,i)){
                    sudoku[row][column]=i;
                    if(sudokuSolver(sudoku,nextrow,nextcolumn)){
                        return true;
                    }
                    sudoku[row][column]=0;
                }
            }
            return false;
        }

    public static void main(String[] args) {
 int sudoku[][]=
         {{0,0,8,0,0,0,0,0,0},
         {4,9,0,1,5,7,0,0,2},
         {0,0,3,0,0,4,1,9,0},
         {1,8,5,0,6,0,0,2,0},
         {0,0,0,0,2,0,0,6,0},
         {9,6,0,4,0,5,3,0,0},
         {0,3,0,0,7,2,0,0,4},
         {0,4,9,0,3,0,0,5,7},
         {8,2,7,0,0,9,0,1,3}};

 sudokuSolver(sudoku,0,0);
    }
}

