package at.mareg.lotterynumers;

import java.util.ArrayList;
import java.util.TreeSet;

public class EuroMillionNumbers extends Lottery
{

  private final int maxStarNumbers;
  private final int howMuchStarNumbers;

  // Superclass variables howManyRows, howMuchNumbers, maxNumbers
  public EuroMillionNumbers (final int howMany,
                             final int howMuch,
                             final int maxLotto,
                             final int howMuchStar,
                             final int maxStar)
  {
    super (howMany, howMuch, maxLotto);
    this.howMuchStarNumbers = howMuchStar;
    this.maxStarNumbers = maxStar;
  }

  public ArrayList <Integer> generateLotto ()
  {
    ArrayList <Integer> list = new ArrayList <Integer> ();

    list = generate (list, howManyRows, howMuchNumbers, maxNumbers);

    return list;
  }

  public ArrayList <Integer> generateStar ()
  {
    ArrayList <Integer> list = new ArrayList <Integer> ();

    list = generate (list, howManyRows, howMuchStarNumbers, maxStarNumbers);

    return list;
  }

  private ArrayList <Integer> generate (final ArrayList <Integer> iList,
                                        final int rows,
                                        final int numbers,
                                        final int max)
  {
    final ArrayList <Integer> list = iList;
    final TreeSet <Integer> tree = new TreeSet <Integer> ();

    for (int x = 0; x < rows; x++)
    {
      while (tree.size () < numbers)
      {
        final int num = (int) (Math.random () * max) + 1;
        tree.add (num);
      }

      list.addAll (tree);
      tree.removeAll (tree);
    }

    return list;
  }
}
