package at.mareg.lotterynumers;

import java.util.ArrayList;
import java.util.TreeSet;

// Superclass variables howManyRows, howMuchNumbers, maxNumbers
public class LotteryNumbers extends Lottery
{
  public LotteryNumbers (final int howMany, final int howMuch, final int max)
  {
    super (howMany, howMuch, max);
  }

  public ArrayList <Integer> generate ()
  {
    final ArrayList <Integer> list = new ArrayList <Integer> ();
    final TreeSet <Integer> tree = new TreeSet <Integer> ();

    for (int x = 0; x < howManyRows; x++)
    {
      while (tree.size () < howMuchNumbers)
      {
        final int num = (int) (Math.random () * maxNumbers) + 1;
        tree.add (num);
      }

      list.addAll (tree);
      tree.removeAll (tree);
    }

    return list;
  }
}
