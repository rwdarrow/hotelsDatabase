/**
 * Name: Main.java
 * Author: Robert Darrow
 * Description: Main start class for JavaFX application
 */

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("hotelViewer.fxml"));
    primaryStage.setTitle("Hotel Viewer");
    Scene scene = new Scene(root, 1735, 776);
    scene.getStylesheets().add("style.css");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}