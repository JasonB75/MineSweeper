public class MineSweeper
{
    int[][] board;
    String[][] playerBoard;

    public void generateBoard(int numMines, int row, int column )
    {
         int[][] mines = new int[numMines][2];
         for (int i=0; i<numMines; i++)
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
                 if (board[i][j] != 9)
                 {
                 board[i][j] = checkMines(i,j);
                }
             }
         }
         
    }
    
    public MineSweeper(int row, int column, int mines)
    {
     board = new int[row][column];
     generateBoard(4, row, column);
    }
    
    public int checkMines(int row, int column)
    {
        int out = 0;
        int[][] placeChecks  = {{row-1, column-1},{row-1,column},{row-1,column+1},{row,column+1},{row+1,column+1},{row+1,column},
                      {row+1,column-1},{row, column-1}};
        
        for(int[] n: placeChecks)
        {
             if(n[0] >= 0 && n[1]>=0 && n[0] <= 4 && n[1]<=4 )
             {
                 if(board[n[0]][n[1]]==9)
                 {
                      out+=1;
                 }
             }
              
        }
        return out;
    }
    
    public void printGame()
    {
        
        for(int[] n: board)
        {
            String out = "";
            for(int m: n)
            {
                out = out+m+" ";
            }
            System.out.println(out + "\n");
            out = "";
        }
    }
    public void start(int rows, int columns)
{
   String[][] playerBoard = new String[rows+1][columns+1];
   String[] letterArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   String[] numArray = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
   
   
   
   for (int i=0; i<columns; i++)
   {
       playerBoard[0][i] = numArray[i];
    }
   for (int i=0; i<rows; i++)
   {
       playerBoard[i][0] = letterArray[i];
   }
   for(int i=1; i<rows;i++)
   {
     for (int j=1; j<columns; j++)
     {
        playerBoard[i][j] = "*";
        }
    }
 }
    
    public void enterCord(int row, int column)
    {Integer[] intsArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
     
          
    }
    
    public void printBoard()
     {    for(String[] n: playerBoard)
        {
            String out = "";
            for(String m: n)
            {
                out = out+m+" ";
            }
            System.out.println(out + "\n");
            out = "";
        }
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
