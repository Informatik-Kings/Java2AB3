package application;

import exception.InvalidSourceException;
import javafx.scene.control.Label;

/**
 * Textfeld welches gegen einen regulären Ausdruck für E-Mails prüft.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class EmailTextField extends RegExTextField
{
   private static final String EMAIL_REGEX = "\\b[a-zA-Z0-9._%-]+@[a-zA-Z0-9.-]+\\.[a-zAZ]{2,4}\\b";
   
   /**
    * 
    * Baut ein {@link RegExTextField} welches gegen einen regulären Ausdruck, passend für E-Mails, prüft. 
    * 
    * @see {@link RegExTextField}.
    */
   public EmailTextField(Label label) throws InvalidSourceException
   {
      super(EMAIL_REGEX, label);
   }

}
