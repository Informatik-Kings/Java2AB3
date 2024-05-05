package application;

import de.fhswf.fbin.java2fx.validation.StatusEvent;
import de.fhswf.fbin.java2fx.validation.StatusListener;
import exception.InvalidSourceException;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Textfeld welches die Eingabe gegen einen festgelegten, regulären Ausdruck mit {@link RegExValidator} überprüft.
 *
 * Die Klasse ist für das Visualisieren der Gültigkeit, für den eingegebenen Text zuständig.
 * Dem SRP nach, kümmert sich diese Klasse NICHT um das Prüfen RegEx-Gültigkeit, sondern deligiert diese Aufgabe an den RegExValidator.
 * 
 * RegExTextField steht hierbei für den View-Teil des MVC-Patterns. Es bekommt die Nutzereingaben und schickt diese an
 * den Controller weiter, welche diese verarbeitet.
 * 
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class RegExTextField extends TextField
{
   private Label label;
   /**
    * 
    * Erstellt das Textfeld, welches gegen den regulären Ausdruck prüft. Es erscheint ein Icon, wenn eine Eingabe gemacht wird,
    * die nicht dem regulärem Ausdruck entspricht.
    *
    * @param regex Regulärer Ausdruck, gegen welchen geprüft werden soll.
    * @param label Label, welches das Textfeld beschreibt und den Validierungszustand anzeigt.
    * @throws InvalidSourceException Wenn eine Null-Referenz zu regex oder label übergeben wird.
    */
   public RegExTextField(String regex, Label label) throws InvalidSourceException
   {
      if(label == null) {
         throw new InvalidSourceException("RegExTextField(String regex, Label label): Ungültige Null-Referenz zu label!");
      }
      RegExValidator validator = new RegExValidator(regex);
      validator.addStatusListener(new ChangeErrorIconStatusListener());
      textProperty().addListener(validator);
      this.label = label;
      getChildren().add(label);
   }

   /**
    * 
    * Ändert, ob ein Fehler-Icon beim Label angezeigt wird, oder nicht. 
    * 
    * ChangeErrorIconStatusListener ist der Model-Teil des MVC-Patterns. Es reagiert auf Änderungen des Controllers.
    * (Kleiner Model-Teil, da es nur das Icon geändert, wenn ein Fehler vorliegt.) 
    *
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   private class ChangeErrorIconStatusListener implements StatusListener<String>{

      @Override
      public void stateChanged(StatusEvent<String> e)
      {
         if (!e.isStatus()) {
            String path = getClass().getResource("/error.png").toExternalForm();
            label.setGraphic(new ImageView(new Image(path)));
         }
         else {
            label.setGraphic(null);
         }           
      }
      
   }

}

