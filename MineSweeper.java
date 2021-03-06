import java.util.Scanner;
public class MineSweeper
{
    public boolean gameOver = true;
    MineSweeper round;
    public int counter = 0;
    int[][] board;
    String[][] playerBoard;
    String[] letterArray = {" ", "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    String[] numArray = {"0","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17"};
    Integer[] intsArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    public MineSweeper()
    {
         
    }
     public String gameStart()
    {
            gameOver = false;
            counter = 0;
            return "Howdy Pardner, younna play some vidya gamez? (y/n)";
    }
        public String nextRound(String statement)
        {
            if (counter == 0)
            {
                if(statement.trim().equals("y") || statement.trim().equals("Y"))
                {
                    counter = counter + 1;
                    return "Select difficulty (E/M/H)";
                }
                else if (statement.trim().equals("n") || statement.trim().equals("N"))
                {
                    return "Then Perish";
                }
            }
            else if (counter == 1)
            {
                if(statement.trim().equals("e") || statement.trim().equals("E"))
                {
                    counter = counter + 1;
                        int row = 5;
                        int column = 5;
                        round = new MineSweeper(row, column, 4);
                        round.start(row,column);
                        round.printBoard();
                        //round.printBoard();
                    return "Easy mode selected, let the games begin! Enter your next cordinates (Letter, Number)";
                    
                }
                else if(statement.trim().equals("m") || statement.trim().equals("M"))
                {
                    counter = counter + 1;
                        int row = 10;
                        int column = 10;
                        round = new MineSweeper(row, column, 8);
                        round.start(row,column);
                        round.printBoard();
                        //round.printBoard();
                    return "Medium mode selected, let the games begin! Enter your next cordinates (Letter, Number)";
                    
                }
                else if(statement.trim().equals("h") || statement.trim().equals("H"))
                {
                    counter = counter + 1;
                        int row = 15;
                        int column = 15;
                        round = new MineSweeper(row, column, 16);
                        round.start(row,column);
                        round.printBoard();
                        //round.printBoard();
                    return "Hard mode selected, let the games begin! Enter your next cordinates (Letter, Number)";
                }
                else
                {
                    return "What?";
                }
            }
            else if(counter >= 2)
            {
                if (statement.trim().contains("a") 
                || (statement.trim().contains("b")) 
                || (statement.trim().contains("c")) 
                || (statement.trim().contains("d")) 
                || (statement.trim().contains("e")) 
                || (statement.trim().contains("f")) 
                || (statement.trim().contains("g")) 
                || (statement.trim().contains("h")) 
                || (statement.trim().contains("i")) 
                || (statement.trim().contains("j")) 
                || (statement.trim().contains("k")) 
                || (statement.trim().contains("l")) 
                || (statement.trim().contains("m")) 
                || (statement.trim().contains("n")) 
                || (statement.trim().contains("o"))) 
                {
                    if (statement.trim().contains("1") 
                    || (statement.trim().contains("2")) 
                    || (statement.trim().contains("3")) 
                    || (statement.trim().contains("4")) 
                    || (statement.trim().contains("5")) 
                    || (statement.trim().contains("6")) 
                    || (statement.trim().contains("7")) 
                    || (statement.trim().contains("8")) 
                    || (statement.trim().contains("9")) 
                    || (statement.trim().contains("10")) 
                    || (statement.trim().contains("11")) 
                    || (statement.trim().contains("l2")) 
                    || (statement.trim().contains("13")) 
                    || (statement.trim().contains("14")) 
                    || (statement.trim().contains("15")))
                    {
                        if (statement.trim().contains(","))
                        {
                            String  bois = " abcdefghijklmnop";
                            counter = counter + 1;
                            String[] values = statement.split(",");
                            int result = Integer.parseInt(values[1]);
                            int yeet = bois.indexOf(values[0]);
                            enterCord(yeet, result);
                            //round.printGame();
                            return "Round " + (counter - 1) + "! Enter your next cordinates (Letter,Number)";
                        }
                    }
                    else
                    {
                        return "Please enter your cordinates correctly";
                    }
            }
        }
        return "Please enter your cordinates correctly";
    }
    //Makes the real board
    public void generateBoard(int numMines, int row, int column )
    {
         int[][] mines = new int[numMines][2];
         for (int i=0; i<numMines; i++)
         {
             mines[i][0] = (int)(Math.random() * (row-1)+1)-1;
             mines[i][1] = (int)(Math.random() * (column-1)+1)-1;
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
                 board[i][j] = checkMines(i,j, row, column);
                }
             }
         }
    }
    //MineSweeper Constructer
    public MineSweeper(int row, int column, int mines)
    {
     board = new int[row][column];
     generateBoard(mines, row, column);
    }
    //Places the mines.
    public int checkMines(int row, int column, int realRow, int realColumn)
    {
        int out = 0;
        int[][] placeChecks  = {{row-1, column-1},{row-1,column},{row-1,column+1},{row,column+1},{row+1,column+1},{row+1,column},{row+1,column-1},{row, column-1}};
        
        for(int[] n: placeChecks)
        {
             if(n[0] >= 0 && n[1] >= 0 && n[0] <= (realRow -1) && n[1] <= (realColumn -1) )
             {
                 if(board[n[0]][n[1]]==9)
                 {
                      out+=1;
                 }
             }
        }
        return out;
    }
    //Print game prints out the actual game with the numbers.
    public void printGame()
    {
        if (board == null)
        {
             System.out.println("Board is null -- printGame!");
        }
        else
        {
             for(int[] n: board)
             {
                  String out = "";
                  for(int m: n)
                  {
                       out = out+m+"   ";
                  }
                  System.out.println(out + "\n");
                  out = "";
             }
        }
    }
    //Generates the player board and begins the game.
    public void start(int rows, int columns)
    {
       playerBoard = new String[rows+1][columns+1];
       for (int i=0; i<=columns; i++)
       {
           if (i> 9)
           {
               playerBoard[0][i] = numArray[i] + " ";
           }
           else
           {
               playerBoard[0][i] = numArray[i] + "  ";
           }
        }
       for (int i=0; i<=rows; i++)
       {
           playerBoard[i][0] = letterArray[i];
       }
       for(int i=1; i<=rows;i++)
       {
           for (int j=1; j<=columns; j++)
           {
                playerBoard[i][j] = "*  ";
           }
        }
    }
    //Checks the users input to see if its a mine, and then reveals what they picked.
    public void enterCord(int row, int column)
    {
        int[][] placesArray = {{row-1, column-1},{row-1,column},{row-1,column+1},{row,column+1},{row+1,column+1},{row+1,column}, {row+1,column-1},{row, column-1}};
        int tempRow;
        int tempColumn;
        if (board[row][column] == 9)
        {
            System.out.println("AAAAAHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
            gameOver=true;
        }
        playerBoard[row+1][column+1] = intsArray[board[row][column]].toString();            
        for (int[] n: placesArray)
        {
            tempRow = n[0];
            tempColumn = n[1];
            playerBoard[tempRow+1][tempColumn+1] = intsArray[board[tempRow][tempColumn]].toString();
        }
    }
    //Print's out the player board which has no numbers.
    public void printBoard()
     {    
        if (board == null)
        {
            System.out.println("Board is null -- printBoard!");
        }
        else
        {
            for(String[] n: playerBoard)
            {
                String out = "";
                for(String m: n)
                {
                     out = out + m + " ";
                }
                System.out.println(out + "\n");
                out = "";
            }
        }
    }
}
