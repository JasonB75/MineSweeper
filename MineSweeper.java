public class MineSweeper
{
    int[][] board;

    public void generateBoard(int numMines, int row, int column )
    {
         int[][] mines = new int[numMines][2];
         for (int i=0; i<=numMines; i++)
         {
             mines[i][0] = (int)(Math.random() *(row-1)+1)-1;
             mines[i][1] = (int)(Math.random()*(column-1)+1)-1;
         }
         for (int[] n: mines)
         {
             board[n[0]][n[1]] = 9;
         }
         
         for(int i=0; i<row; i++)
         {
             for (int j=0; j<column; j++)
             {
                 
             }
         }
         

    }
    
    public void MineSweeper(int row, int column)
    {
     board = new int[row][column];
     generateBoard(4, row, column);
    }
    
    public int checkMines(int row, int column)
    {
        int out = 0;
        int[][] placeChecks; 
        placeChecks=new int[8][2];
        placeChecks = {{row-1, column-1},{row-1,column},{row-1,coumn+1},{row,colum+1},{row+1,column+1},{row+1,column},
                      {row+1,column-1},{row, column-1}};
        
        for(int[] n: placeChecks)
        {
             if(n[0] >= 0 && n[1]>=0)
             {
                 if(board[n[0]][n[1]]=9)
                 {
                      out+=1
                 }
             }
              
        }
        return out;
        
        
        
    }
    


}


/*
 * for (int i=0; i<=5; i++)
        {
            for (int j=0; j<=5; j++)
            {
                board[i][j] = false;
            }
        }
 */