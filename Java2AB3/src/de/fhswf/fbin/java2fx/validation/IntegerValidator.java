package de.fhswf.fbin.java2fx.validation;

import java.awt.Toolkit;

public class IntegerValidator extends ValidationAdapter<String>
{
   /**
    * Checks whether value represents a valid int.
    * 
    * @see Validator#isValid(java.lang.Object)
    */
   public boolean isValid(String value)
   {
      boolean returnValue = true;

      if (value != null && value.length() != 0)
      {
         try
         {
            Integer.parseInt(value);
         }
         catch (NumberFormatException e)
         {
            Toolkit.getDefaultToolkit().beep();
            returnValue = false;
         }
      }
      return returnValue;
   }
}
