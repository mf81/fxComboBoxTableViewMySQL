package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    MySqlConn mySqlConn = MySqlConn.getInstance();

    @FXML
    Button buttonFirst;

    @FXML
    ComboBox<String> comboBox;


    @FXML
    private TableView<Model> tableView;
    @FXML
    private TableColumn<Model, Integer> id;
    @FXML
    private TableColumn<Model, String> name;
    @FXML
    private TableColumn<Model, String> number;


    public void initialize(URL location, ResourceBundle resources) {

        try {
            ObservableList<String> list = FXCollections.observableArrayList(ModelDAO.getStringList());
            comboBox.setItems(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void comboActionSet(ActionEvent event){

        id.setCellValueFactory(new PropertyValueFactory<Model, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<Model, String>("name"));
        number.setCellValueFactory(new PropertyValueFactory<Model, String>("number"));

        try {
            ObservableList<Model> list = FXCollections.observableArrayList(ModelDAO.getSingel(comboBox.getValue()));
            tableView.getItems().clear();
            tableView.getItems().addAll(list);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





}
