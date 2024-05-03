package application;

import java.util.regex.Pattern;

import de.fhswf.fbin.java2fx.validation.ValidationAdapter;
import exception.InvalidSourceException;

/**
 * Prüft ob ein String einem regulären Ausdruck entspricht.
 *
 * Die Klasse ist für das Prüfen gegen einen regulären Ausdruck zuständig.
 * Dies wird erreicht, in dem ein RegEx-Pattern einmal kompiliert wird und so effektiv immer wieder damit geprüft wird.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class RegExValidator extends ValidationAdapter<String>
{
   private Pattern pattern;

   /**
    * 
    * Kompiliert einen regulären Ausdruck und speichert diesen in der Instanz ab.
    *
    * @param regex Regulärer Ausdruck, gegen welchen geprüft werden soll.
    * @throws InvalidSourceException Wenn eine Null-Referenz zu regex übergeben wird.
    */
   public RegExValidator(String regex) throws InvalidSourceException
   {
      if(regex == null) {
         throw new InvalidSourceException("RegExValidator(String regex): Ungültige null-Referenz zu regex übergeben!");
      }
      pattern = Pattern.compile(regex);
   }

   @Override
   public boolean isValid(String string)
   {
      boolean returnValue = true;
      if(string != null && string.length() != 0) {
         returnValue = pattern.matcher(string).matches();
      }
      return returnValue;
   }

}
