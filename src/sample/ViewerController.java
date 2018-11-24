package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.concurrent.SynchronousQueue;

public class ViewerController {
  @FXML
  private ImageView hotelPhotos;

  @FXML
  private Label hotelName;

  @FXML
  private Label stars;

  @FXML
  private Label address;

  @FXML
  private Label city;

  @FXML
  private Label zipCode;

  @FXML
  private Label state;

  @FXML
  private Label country;

  @FXML
  private Label website;

  @FXML
  private TableView hotelTable;

  @FXML
  private TableColumn nameCol;

  @FXML
  private TableColumn starCol;

  @FXML
  private TableColumn addressCol;

  @FXML
  private TableColumn cityCol;

  @FXML
  private TableColumn stateCol;

  @FXML
  private TableColumn postalCodeCol;

  @FXML
  private TableColumn countryCol;

  @FXML
  private TableColumn websiteCol;

  private final String DATABASE_URL = "jdbc:derby:lib/hotels";
  static int index;
  static ObservableList<Hotel> data;

  public void initialize() {
    updateTable();
  }

  public void addNewEntry(ActionEvent event) throws Exception{
    Parent addNewParent = FXMLLoader.load(getClass().getResource("addNew.fxml"));
    Scene addNewScene = new Scene(addNewParent);

    Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
    window.setScene(addNewScene);
    window.show();
  }

  public void removeEntry() {
    // delete entry in database that has the name of the selected hotel
    final String DELETE_QUERY = "DELETE FROM hotels WHERE hName = \'" + data.get(index).getName() + "\'";

    // use try-with-resources to connect to and query the database
    try {
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        Statement statement = connection.createStatement();
        statement.executeUpdate(DELETE_QUERY);
    } catch (SQLException e) {
      e.printStackTrace();
    }

    updateTable();
  }

  private void updateTable() {
    final String SELECT_QUERY = "SELECT * FROM hotels";

    data = FXCollections.observableArrayList();

    // use try-with-resources to connect to and query the database
    try (
        Connection connection = DriverManager.getConnection(DATABASE_URL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_QUERY))
    {
      // create objects from query results and add to data list
      while (resultSet.next())
      {
        Hotel hotel = new Hotel(resultSet.getString(1),
                                resultSet.getDouble(2),
                                resultSet.getString(3),
                                resultSet.getString(4),
                                resultSet.getString(5),
                                resultSet.getString(6),
                                resultSet.getString(7),
                                resultSet.getString(8));

        data.add(hotel);
      }

      // populate each column in table with data from each object
      nameCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("name"));
      starCol.setCellValueFactory(new PropertyValueFactory<Hotel,Double>("stars"));
      addressCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("address"));
      cityCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("city"));
      stateCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("state"));
      postalCodeCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("zipCode"));
      countryCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("country"));
      websiteCol.setCellValueFactory(new PropertyValueFactory<Hotel,String>("website"));

      hotelTable.setItems(data);

      // allow selection of row in TableView to update information on side of screen
      hotelTable.setOnMouseClicked((MouseEvent e) -> {
        if (hotelTable.getSelectionModel().getSelectedItem() != null) {
          index = hotelTable.getSelectionModel().getSelectedIndex();

          // set all labels
          hotelName.setText(data.get(index).getName());
          stars.setText("" + data.get(index).getStars());
          address.setText(data.get(index).getAddress());
          city.setText(data.get(index).getCity());
          state.setText(data.get(index).getState());
          zipCode.setText(data.get(index).getZipCode());
          country.setText(data.get(index).getCountry());
          website.setText(data.get(index).getWebsite());
      }
      });
    } catch (SQLException sqlException) {
      sqlException.printStackTrace();
    }
  }
}
