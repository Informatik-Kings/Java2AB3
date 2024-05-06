package application;

import exception.InvalidSourceException;
import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

/**
 * Stellt ein GridPane mit zwei Textfeldern zu Verfügung, welche mit regulären Ausdrücken geprüft werden.
 * Ein Textfeld darf nur Zahlen enthalten, dass andere prüft nach E-Mails.
 *
 * @author Markus Suchalla, Cheng-Fu Ye, Dominik Schwabe
 */
public class RegExGridPane extends GridPane
{

/**
 * 
 * Legt das Layout der RegExGridPane fest. Die Textfelder, mit passendem Fehler-Icon,
 * werden auf dem Grid von oben nach unten plaziert.
 *
 * @throws InvalidSourceException Siehe {@link RegExTextField#RegExTextField(String, Label)}.
 */
   public RegExGridPane() throws InvalidSourceException
   {      

      ColumnConstraints column1 = new ColumnConstraints(75, 75,
            75);
      ColumnConstraints column2 = new ColumnConstraints();
      column2.setPercentWidth(25);
      column2.setHgrow(Priority.ALWAYS);
      getColumnConstraints().addAll(column1, column2);

      //Beispiel RegEx welches prüft ob nur Zahlen eingegeben werden
      Label label = new Label("Zahlen");
      TextField textField = new RegExTextField("[0-9]+", label);
      label.setAlignment(Pos.CENTER);
      label.setContentDisplay(ContentDisplay.RIGHT);
      GridPane.setConstraints(label, 0, 0); // Spalte=0 Zeile=0  
      GridPane.setConstraints(textField, 1, 0); // Spalte=1 Zeile=0      
      getChildren().addAll(label, textField);      
      
      
      //Aufgabenteil für E-Mail RegEx
      label = new Label("E-Mail");
      textField = new EmailTextField(label);
      label.setAlignment(Pos.CENTER);
      label.setContentDisplay(ContentDisplay.RIGHT);
      GridPane.setConstraints(label, 0, 1); // Spalte=0 Zeile=1  
      GridPane.setConstraints(textField, 1, 1); // Spalte=1 Zeile=1      
      getChildren().addAll(label, textField);   
      
   }

}


