/**
 * Name: AddNewController.java
 * Author: Robert Darrow
 * Description: A controller class for the add new hotel scene
 */

package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNewController {
  @FXML
  private TextField nameField;

  @FXML
  private TextField addressField;

  @FXML
  private TextField cityField;

  @FXML
  private TextField stateField;

  @FXML
  private TextField postalCodeField;

  @FXML
  private TextField countryField;

  @FXML
  private TextField websiteField;

  @FXML
  private ComboBox starSelector;

  private static final String DATABASE_URL = "jdbc:derby:lib/hotels";

  /**
   * Description: creates a new hotel object based on text entered into fields.
   */
  public void submit() {
    double stars;

    // make sure the user has selected a value for stars
    try {
      stars = Double.parseDouble(starSelector.getSelectionModel().getSelectedItem().toString());
    } catch (NullPointerException e) {
      stars = 0;
    }

    // set values to be text entered by user
    String name = nameField.getText();
    String address = addressField.getText();
    String city = cityField.getText();
    String state = stateField.getText();
    String postalCode = postalCodeField.getText();
    String country = countryField.getText();
    String website = websiteField.getText();

    // make sure all the fields have been filled in
    if (stars != 0 && !name.equals("") && !address.equals("") && !city.equals("")
        && !state.equals("") && !postalCode.equals("") && !country.equals("")
        && !website.equals("")) {
      // create a hotel object based on these values
      Hotel hotel = new Hotel(name, stars, address, city, state, postalCode, country, website);
      addToDatabase(hotel);
    }
  }

  /**
   * Adds data from hotel object to the database.
   * @param hotel the hotel object to extract data from
   */
  private void addToDatabase(Hotel hotel) {
    // insert values extracted from hotel object into database
    String insertQuery = "INSERT INTO hotels VALUES " + hotel.toDatabaseQueryString();

    // use try-with-resources to connect to and query the database
    try {
      Connection connection = DriverManager.getConnection(DATABASE_URL);
      Statement statement = connection.createStatement();
      statement.executeUpdate(insertQuery);
      statement.close();
      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Changes scene to hotel viewer scene.
   * @param event the mouse event this method listens for
   * @throws Exception any exception is this method may throw
   */
  public void back(ActionEvent event) throws Exception {
    Parent viewerParent = FXMLLoader.load(getClass().getResource("hotelViewer.fxml"));
    Scene viewerScene = new Scene(viewerParent);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(viewerScene);
    window.show();
  }
}
