/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava;

import dietonjava.foodhandling.Food;
import dietonjava.foodhandling.FoodSQL;
import dietonjava.foodhandling.NutrientNames;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author vasouv
 */
public class MainGUIController implements Initializable {
    
    /**
     * It performs all SQL queries to the DB
     */
    FoodSQL fsql = new FoodSQL();
    
    /**
     * It holds all food elements that populate the DB TableView
     */
    @FXML
    private ObservableList<Food> list = FXCollections.observableArrayList();
     
    @FXML
    private TableView<Food> foodDB;
    
    @FXML
    private TableView<Food> monBreakfast, monBreakfast2, monLunch, monLunch2, monDinner, monTotal;
    
    @FXML
    private TextField searchBox;
    
    /**
     * Temp food that is drag'n'dropped from the DB
     */
    Food toCopyFood;
    
    /**
     * Temp lists that holds the food to be added to the specified day TableView
     */
    ObservableList<Food> monBreakfastList = FXCollections.observableArrayList();
    ObservableList<Food> monBreakfast2List = FXCollections.observableArrayList();
    ObservableList<Food> monLunchList = FXCollections.observableArrayList();
    ObservableList<Food> monLunch2List = FXCollections.observableArrayList();
    ObservableList<Food> monDinnerList = FXCollections.observableArrayList();
    ObservableList<Food> monTotalList = FXCollections.observableArrayList();
    
    /**
     * TableColumns for the DB
     */
    @FXML
    private TableColumn<Food,String> shrt_desc, ndb_no;
    @FXML
    private TableColumn<Food,Double> energ_kcal, protein_g, lipid_tot_g;
    @FXML
    private TableColumn<Food,Double> carbohydrt_g, fiber_td_g, iron_mg;
    
    /**
     * TableColumns for Monday Breakfast
     */
    @FXML
    private TableColumn<Food,String> shrt_descMBr, ndb_noMBr;
    @FXML
    private TableColumn<Food,Double> energ_kcalMBr, protein_gMBr, lipid_tot_gMBr;
    @FXML
    private TableColumn<Food,Double> carbohydrt_gMBr, fiber_td_gMBr, iron_mgMBr;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createTableViewCells();
        
        list = fsql.listFoods();
        foodDB.setItems(list);
    }
    
    /**
     * Searches the database for the search term by pressing ENTER
     */
    @FXML
    private void searchTerm(KeyEvent event) {
        if(event.getCode() == KeyCode.ENTER) {
            createTableViewCells();
            list = fsql.searchDB(searchBox.getText());
            foodDB.setItems(list);
        }
    }
    
    @FXML
    private void copyFood(MouseEvent event) {
        
        foodDB.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                toCopyFood = new Food(foodDB.getSelectionModel().getSelectedItem());
            }
        });
    }
    
    @FXML
    private void addRemoveFood(MouseEvent event) {
        
        monBreakfast.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if(event.getClickCount() == 2) {
                    monBreakfastList.add(toCopyFood);
                    monBreakfast.setItems(monBreakfastList);
                }
                if(event.isControlDown() && event.getClickCount() == 1) {
                    monBreakfast.getItems().remove(monBreakfast.getSelectionModel().getSelectedItem());
                }
            }
        });
    }
    
    private void createTableViewCells() {

        createMainDBCells();
        createMondayBreakfastCells();
    }    

    private void createMainDBCells() {
        /**
         * Main DB cells
         */
        ndb_no.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.NDB_NO));
        shrt_desc.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.SHRT_DESC));
        energ_kcal.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.ENERGY));
        protein_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.PROTEIN));
        lipid_tot_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.LIPIDS));
        carbohydrt_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.CARBS));
        fiber_td_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FIBER));
        iron_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.IRON));
    }
    
    private void createMondayBreakfastCells() {
        /**
         * Creates Monday breakfast cells
         */
        ndb_noMBr.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.NDB_NO));
        shrt_descMBr.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.SHRT_DESC));
        energ_kcalMBr.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.ENERGY));
        protein_gMBr.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.PROTEIN));
        lipid_tot_gMBr.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.LIPIDS));
        carbohydrt_gMBr.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.CARBS));
        fiber_td_gMBr.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FIBER));
        iron_mgMBr.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.IRON));
    }
    
}
