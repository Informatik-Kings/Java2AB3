package de.fhswf.fbin.java2fx.validation;

import java.io.File;
import java.net.MalformedURLException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class TextChangesFX extends Application
{
   @Override
   public void start(Stage primaryStage)
   {
      try
      {
         GridPane gridpane = new GridPane();

         ColumnConstraints column1 = new ColumnConstraints(50, 50,
               Double.MAX_VALUE);
         ColumnConstraints column2 = new ColumnConstraints(100, 200,
               Double.MAX_VALUE);
         column2.setHgrow(Priority.ALWAYS);
         gridpane.getColumnConstraints().addAll(column1, column2);
         
         // Places the button at the first row and first column
         Label label = new Label("Label");
         label.setAlignment(Pos.CENTER);
         label.setContentDisplay(ContentDisplay.RIGHT);
         GridPane.setRowIndex(label, 0);
         GridPane.setColumnIndex(label, 0);

         // or convenience methods set more than one constraint at once...
         TextField textField = new TextField();
         IntegerValidator iv = new IntegerValidator();
         iv.addStatusListener(e -> {
            if (!e.isStatus()) {
				try {
					String path = new File("img/error.png").toURI().toURL().toString();
					System.out.println(path);
					label.setGraphic(new ImageView(new Image(path)));
				} catch (MalformedURLException e1) {
					e1.printStackTrace();
				}
            }
            else
               label.setGraphic(null);
         });

         textField.textProperty().addListener(iv);
         GridPane.setConstraints(textField, 1, 0); // column=1 row=0

         // don't forget to add children to gridpane
         gridpane.getChildren().addAll(label, textField);

         Scene scene = new Scene(gridpane);
         primaryStage.setScene(scene);
         primaryStage.show();
      }
      catch (Exception e)
      {
         e.printStackTrace();
      }
   }

   public static void main(String[] args)
   {
      launch(args);
   }
}