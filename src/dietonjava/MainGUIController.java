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
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
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
    private ObservableList<Food> list = observableArrayList();

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
    ObservableList<Food> monBreakfastList = observableArrayList();
    ObservableList<Food> monBreakfast2List = observableArrayList();
    ObservableList<Food> monLunchList = observableArrayList();
    ObservableList<Food> monLunch2List = observableArrayList();
    ObservableList<Food> monDinnerList = observableArrayList();
    ObservableList<Food> monTotalList = observableArrayList();

    /**
     * TableColumns for the DB
     */
    @FXML
    private TableColumn<Food, String> shrt_desc, ndb_no;
    @FXML
    private TableColumn<Food, Double> energ_kcal, protein_g, lipid_tot_g;
    @FXML
    private TableColumn<Food, Double> carbohydrt_g, fiber_td_g, iron_mg;

    /**
     * TableColumns for Monday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descMBr, ndb_noMBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalMBr, protein_gMBr, lipid_tot_gMBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gMBr, fiber_td_gMBr, iron_mgMBr;

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
        if (event.getCode() == KeyCode.ENTER) {
            createTableViewCells();
            list = fsql.searchDB(searchBox.getText());
            foodDB.setItems(list);
        }
    }

    /**
     * When a food in foodDB is clicked, its values are assigned to a temp
     * object to be added to the corresponding meal tableview
     */
    @FXML
    private void copyFood(MouseEvent event) {

        foodDB.setOnMouseClicked((MouseEvent event1) -> {
            toCopyFood = new Food(foodDB.getSelectionModel().getSelectedItem());
        });
    }

    /**
     * If user double clicks the meal tableviews, foods are added to them. If
     * Ctrl + Click on a specific food, that food is removed
     */
    @FXML
    private void addRemoveFood(MouseEvent event) {

        monBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                monBreakfastList.add(toCopyFood);
                monBreakfast.setItems(monBreakfastList);
                updateMondayTotal();
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monBreakfastList.remove(monBreakfast.getSelectionModel().getSelectedItem());
                updateMondayTotal();
            }
            updateMondayTotal();
        });
    }

    /**
     * DOESN'T WORK
     */
    public void updateMondayTotal() {
        if (!monTotalList.isEmpty()) {
            double energy = 0.0, protein = 0.0, lipid = 0.0, carbs = 0.0, fiber = 0.0, iron = 0.0;
            for (Food food : monBreakfastList) {
                energy += food.getEnerg_kcal();
                protein += food.getProtein_g();
                lipid += food.getLipid_tot_g();
                carbs += food.getCarbohydrt_g();
                fiber += food.getFiber_td_g();
                iron += food.getIron_mg();
                System.out.println("Total energy:" + energy);
            }
            monTotalList.add(new Food("", "", energy, protein, lipid, carbs, fiber, iron));
            monTotal.setItems(monTotalList);
        }

    }

    private void createTableViewCells() {

        createMainDBCells();
        createMondayBreakfastCells();
    }

    private void createMainDBCells() {
        /**
         * Main DB cells
         */
        ndb_no.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_desc.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcal.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_g.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_g.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_g.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_g.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mg.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }

    private void createMondayBreakfastCells() {
        /**
         * Creates Monday breakfast cells
         */
        ndb_noMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgMBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }

}
