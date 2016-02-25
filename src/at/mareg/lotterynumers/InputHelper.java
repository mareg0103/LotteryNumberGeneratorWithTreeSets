package at.mareg.lotterynumers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputHelper
{

  public String getUserInput (final String prompt)
  {
    String inputLine = null;
    System.out.print (prompt);
    try
    {
      final BufferedReader is = new BufferedReader (new InputStreamReader (System.in));
      inputLine = is.readLine ();
      if (inputLine.length () == 0)
        return null;
    }
    catch (final IOException e)
    {
      System.out.println ("IOException: " + e);
    }
    return inputLine.toLowerCase ();
  }
}
