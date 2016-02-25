package at.mareg.lotterynumers;

public class Lottery
{
  protected final int howManyRows;
  protected final int howMuchNumbers;
  protected final int maxNumbers;

  public Lottery (final int howMany, final int howMuch, final int max)
  {
    this.howManyRows = howMany;
    this.howMuchNumbers = howMuch;
    this.maxNumbers = max;
  }
}
