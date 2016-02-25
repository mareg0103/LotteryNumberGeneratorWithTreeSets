package at.mareg.lotterynumers;

import java.util.ArrayList;

public class LotteryNumberGenerator
{

  public static void main (final String [] args)
  {
    // necessary variables

    // helps to create output at prompt
    final InputHelper helper = new InputHelper ();
    // contains user input > which selection to start
    String userInWhichGame;
    // contains user input > how many rows to create
    String userInHowManyRows;
    // max rows allowed for input
    final int maxRowsAllowed = 12;
    // contains the converted int from userIntHowManyRows
    int userInputRows;
    // output var for game selection
    final String startOutput = "Das ist ein Lottozeilen-Generator!\nWas möchten Sie spielen?\n\nLotto > Drücken Sie bitte die 1\nEuromilionen > Drücken Sie bitte die 2.\n";
    // if lotto > how many numbers per row to create
    final int lotteryHowManyNumbers = 6;
    // which range for lotto: from 1 to ...
    final int lotteryMaxNumbers = 45;
    // if euro million > how many numbers per row to create
    final int euroMillionHowManyNumbers = 5;
    // which range for euro million: from 1 to ...
    final int euroMillionMaxNumbers = 50;
    // if euro million > how many star numbers per row to create
    final int euroMillionHowManyStarNumbers = 2;
    // which range for star numbers: from 1 to ...
    final int euroMillionMaxStarNumbers = 11;
    // create new instance for number list, used by lottery and euro million
    ArrayList <Integer> list = new ArrayList <Integer> ();
    // create new instance for star number list, used only by euro million
    ArrayList <Integer> starList = new ArrayList <Integer> ();

    // get user input
    userInWhichGame = helper.getUserInput (startOutput);
    userInHowManyRows = helper.getUserInput ("Wieviele Zahlenreihen möchten Sie generiert haben (max " +
                                             maxRowsAllowed +
                                             ")?  ");
    userInputRows = Integer.parseInt (userInHowManyRows);

    // if userInputNumber is from 1 to maxRowsAllowed and game selection is 1...
    if (userInputRows > 0 && userInputRows <= maxRowsAllowed && userInWhichGame.contains ("1"))
    {

      final LotteryNumbers lottoNum = new LotteryNumbers (userInputRows, lotteryHowManyNumbers, lotteryMaxNumbers);

      list = lottoNum.generate ();

      int counter = 1;

      for (final Integer temp : list)
      {
        checkIntLength (temp.intValue ());

        if (counter < lotteryHowManyNumbers)
        {
          System.out.print (temp + " ");
          counter++;
        }
        else
        {
          System.out.println (temp);
          counter = 1;
        }
      }
    }
    else // ...else if userInputNumber is from 1 to maxRowsAllowed and game
         // selection is 2
      if (userInputRows > 0 && userInputRows <= maxRowsAllowed && userInWhichGame.contains ("2"))
      {
        final EuroMillionNumbers euroMillionNum = new EuroMillionNumbers (userInputRows,
                                                                          euroMillionHowManyNumbers,
                                                                          euroMillionMaxNumbers,
                                                                          euroMillionHowManyStarNumbers,
                                                                          euroMillionMaxStarNumbers);
        list = euroMillionNum.generateLotto ();
        starList = euroMillionNum.generateStar ();

        int counter = 0;
        while (counter < userInputRows)
        {
          for (int i = 0; i < euroMillionHowManyNumbers; i++)
          {
            checkIntLength (list.get (i + (counter * euroMillionHowManyNumbers)));
            System.out.print (list.get (i + (counter * euroMillionHowManyNumbers)) + " ");
          }
          System.out.print (" Sternnummern  ");
          for (int j = 0; j < euroMillionHowManyStarNumbers; j++)
          {
            checkIntLength (starList.get (j + (counter * euroMillionHowManyStarNumbers)));
            System.out.print (starList.get (j + (counter * euroMillionHowManyStarNumbers)) + " ");
          }
          System.out.println ();
          counter++;
        }

      }
      // else invalid input
      else
      {
        System.out.println ("Keine gültige Eingabe, Programm wird beendet!!!");
      }

  }

  private static void checkIntLength (final int num)
  {

    if (String.valueOf (num).length () == 1)
    {
      System.out.print ("0");
    }
  }
}
