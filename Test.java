import java.util.Scanner;
public class TalkAboutIt
{
    public static void main(String[] args)
    {
        MineSweeper turn = new MineSweeper();
        System.out.println (turn.gameStart());
        Scanner in = new Scanner (System.in);
        String statement = in.nextLine();
        
        while (!turn.gameOver)
        {
            System.out.println(turn.nextRound(statement));
            statement = in.nextLine();
        }
    }
}
