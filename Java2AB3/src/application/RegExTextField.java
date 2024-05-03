package application;

import java.io.File;
import java.net.MalformedURLException;

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
 * TODO Wie das mit dem MVC-Pattern zusammenhängt!
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
    * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
    */
   private class ChangeErrorIconStatusListener implements StatusListener<String>{

      @Override
      public void stateChanged(StatusEvent<String> e)
      {
         if (!e.isStatus()) {
            try {
               //TODO FILE SOLL NICHT VERWENDET WERDEN. ÄNDERN!!!
               String path = new File("img/error.png").toURI().toURL().toString();
               label.setGraphic(new ImageView(new Image(path)));
            } catch (MalformedURLException e1) {
               e1.printStackTrace();
            }
         }
         else {
            label.setGraphic(null);
         }           
      }
      
   }

}

