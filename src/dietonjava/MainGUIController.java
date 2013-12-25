/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava;

import dietonjava.foodhandling.Food;
import dietonjava.foodhandling.FoodSQL;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

/**
 *
 * @author vasouv
 */
public class MainGUIController implements Initializable {
    
    FoodSQL fsql = new FoodSQL();
    
    @FXML
    private ObservableList<Food> list = FXCollections.observableArrayList();
    
    @FXML
    private TableView<Food> foodDB;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list = fsql.listFoods();
        foodDB.setItems(list);
    }    
    
}
