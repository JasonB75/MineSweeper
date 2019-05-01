public class Test
{
    public int counter = 0;
    
    public static void main()
    {
    /*int row = 5;
    int column = 5;
    MineSweeper round = new MineSweeper(row, column, 4);
    round.printGame();
    start(row,column);*/
}

public void start(int rows, int columns)
{
   String[][] playerBoard = new int[rows+1][columns+1];
   String[] letterArray = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
   String[] numArray = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
   
   
   for (int i=0; i<columns; i++)
   {
       playerBoard[0][i] = i+1;
    }
   for (int i=0; i<rows; i++)
   {
       playerBoard[i][0] = letterArray[i];
   }
   for(int i=1; i<rows;i++)
   {
    
    }
 }
}
