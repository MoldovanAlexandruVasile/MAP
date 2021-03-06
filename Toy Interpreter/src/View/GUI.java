/**************************************************************************************************
 *       Copyright(c):                                                                            *
 *                         Program made by @Moldovan Alexandru-Vasile.                            *
 *                                                                                                *
 **************************************************************************************************/

package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GUI extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        try {
            StackPane root = FXMLLoader.load(getClass().getResource("../Controller/JavaFX.fxml"));
            Scene scene = new Scene(root, 1292, 632, Color.DARKBLUE);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Toy interpretor.");
            primaryStage.show();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
