public class NQueens
{
    final int N = 5;
    
    /* A utility function to print solution */
    void printSolution(int board[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + board[i][j]
                                 + " ");
            System.out.println();
        }
    }
 
    boolean isSafe(int board[][], int row, int col)
    {
        int i, j;
        
        //Check current row
        for(i = 0; i < col; i++)
        {
            //System.out.println(row);
            if(board[row][i] == 1)
            {
                return false;
            }
        }
        
        //Check upper left diagonal
        for(i = row, j = col; j >= 0 && i >=0; i--, j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }
        
        //Check lower left diagonal
        for(i = row, j = col; j >= 0 && i < N; i++, j--)
        {
            if(board[i][j] == 1)
            {
                return false;
            }
        }
        return true;
    }
    
    boolean placeQueens(int board[][], int col)
    {
        //If all queens are placed, return
        if(col >= N)
        {
            return true;
        }
        
        for(int i = 0; i < N; i++)
        {
            if(isSafe(board, i, col))
            {
                board[i][col] = 1;
                
                if(placeQueens(board, col + 1))
                {
                    return true;
                }
                
                board[i][col] = 0; //Backtrack
            }
        }
        
        return false;
    }
    
    boolean solveNQ()
    {
        int board[][] = {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0}
        };
 
        if (placeQueens(board, 0) == false)
        {
            System.out.print("Solution does not exist");
            return false;
        }
 
        printSolution(board);
        return true;
    }
 
    // driver program to test above function
    public static void main(String args[])
    {
        NQueens Queen = new NQueens();
        Queen.solveNQ();
    }
}