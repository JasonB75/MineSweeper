public class Test
{
    public int counter = 0;
    
    public static void main()
    {
    int row = 5;
    int column = 5;
    MineSweeper round = new MineSweeper(row, column, 4);
    round.printGame();
    round.start(row,column);
    round.printBoard();
}


}
