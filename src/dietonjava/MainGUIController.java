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
    private TableView<Food> tueBreakfast, tueBreakfast2, tueLunch, tueLunch2, tueDinner, tueTotal;
    
    @FXML
    private TableView<Food> wedBreakfast, wedBreakfast2, wedLunch, wedLunch2, wedDinner, wedTotal;
    
    @FXML
    private TableView<Food> thBreakfast, thBreakfast2, thLunch, thLunch2, thDinner, thTotal;

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
    
    ObservableList<Food> tueBreakfastList = observableArrayList();
    ObservableList<Food> tueBreakfast2List = observableArrayList();
    ObservableList<Food> tueLunchList = observableArrayList();
    ObservableList<Food> tueLunch2List = observableArrayList();
    ObservableList<Food> tueDinnerList = observableArrayList();
    ObservableList<Food> tueTotalList = observableArrayList();
    
    ObservableList<Food> wedBreakfastList = observableArrayList();
    ObservableList<Food> wedBreakfast2List = observableArrayList();
    ObservableList<Food> wedLunchList = observableArrayList();
    ObservableList<Food> wedLunch2List = observableArrayList();
    ObservableList<Food> wedDinnerList = observableArrayList();
    ObservableList<Food> wedTotalList = observableArrayList();
    
    ObservableList<Food> thBreakfastList = observableArrayList();
    ObservableList<Food> thBreakfast2List = observableArrayList();
    ObservableList<Food> thLunchList = observableArrayList();
    ObservableList<Food> thLunch2List = observableArrayList();
    ObservableList<Food> thDinnerList = observableArrayList();
    ObservableList<Food> thTotalList = observableArrayList();

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
    
    /**
     * TableColums for Monday Breakfast2
     */
    @FXML
    private TableColumn<Food, String> shrt_descMBr2, ndb_noMBr2;
    @FXML
    private TableColumn<Food, Double> energ_kcalMBr2, protein_gMBr2, lipid_tot_gMBr2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gMBr2, fiber_td_gMBr2, iron_mgMBr2;
    
    /**
     * TableColums for Monday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descML, ndb_noML;
    @FXML
    private TableColumn<Food, Double> energ_kcalML, protein_gML, lipid_tot_gML;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gML, fiber_td_gML, iron_mgML;
    
    /**
     * TableColums for Monday Lunch 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descML2, ndb_noML2;
    @FXML
    private TableColumn<Food, Double> energ_kcalML2, protein_gML2, lipid_tot_gML2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gML2, fiber_td_gML2, iron_mgML2;
    
    /**
     * TableColumns for Monday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descMD, ndb_noMD;
    @FXML
    private TableColumn<Food, Double> energ_kcalMD, protein_gMD, lipid_tot_gMD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gMD, fiber_td_gMD, iron_mgMD;
    
    /**
     * TableColums for Tuesday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descTBr, ndb_noTBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalTBr, protein_gTBr, lipid_tot_gTBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gTBr, fiber_td_gTBr, iron_mgTBr;
    
    /**
     * TableColums for Tuesday Breakfast 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descTBr2, ndb_noTBr2;
    @FXML
    private TableColumn<Food, Double> energ_kcalTBr2, protein_gTBr2, lipid_tot_gTBr2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gTBr2, fiber_td_gTBr2, iron_mgTBr2;
    
    /**
     * TableColums for Tuesday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descTL, ndb_noTL;
    @FXML
    private TableColumn<Food, Double> energ_kcalTL, protein_gTL, lipid_tot_gTL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gTL, fiber_td_gTL, iron_mgTL;
    
    /**
     * TableColums for Tuesday Lunch 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descTL2, ndb_noTL2;
    @FXML
    private TableColumn<Food, Double> energ_kcalTL2, protein_gTL2, lipid_tot_gTL2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gTL2, fiber_td_gTL2, iron_mgTL2;
    
    /**
     * TableColumns for Tuesday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descTD, ndb_noTD;
    @FXML
    private TableColumn<Food, Double> energ_kcalTD, protein_gTD, lipid_tot_gTD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gTD, fiber_td_gTD, iron_mgTD;
    
    /**
     * TableColums for Wednesday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descWBr, ndb_noWBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalWBr, protein_gWBr, lipid_tot_gWBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gWBr, fiber_td_gWBr, iron_mgWBr;
    
    /**
     * TableColums for Wednesday Breakfast 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descWBr2, ndb_noWBr2;
    @FXML
    private TableColumn<Food, Double> energ_kcalWBr2, protein_gWBr2, lipid_tot_gWBr2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gWBr2, fiber_td_gWBr2, iron_mgWBr2;
    
    /**
     * TableColums for Wednesday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descWL, ndb_noWL;
    @FXML
    private TableColumn<Food, Double> energ_kcalWL, protein_gWL, lipid_tot_gWL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gWL, fiber_td_gWL, iron_mgWL;
    
    /**
     * TableColums for Wednesday Lunch 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descWL2, ndb_noWL2;
    @FXML
    private TableColumn<Food, Double> energ_kcalWL2, protein_gWL2, lipid_tot_gWL2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gWL2, fiber_td_gWL2, iron_mgWL2;
    
    /**
     * TableColumns for Wednesday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descWD, ndb_noWD;
    @FXML
    private TableColumn<Food, Double> energ_kcalWD, protein_gWD, lipid_tot_gWD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gWD, fiber_td_gWD, iron_mgWD;
    
    /**
     * TableColums for Thursday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descThBr, ndb_noThBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalThBr, protein_gThBr, lipid_tot_gThBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThBr, fiber_td_gThBr, iron_mgThBr;
    
    /**
     * TableColums for Thursday Breakfast 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descThBr2, ndb_noThBr2;
    @FXML
    private TableColumn<Food, Double> energ_kcalThBr2, protein_gThBr2, lipid_tot_gThBr2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThBr2, fiber_td_gThBr2, iron_mgThBr2;
    
    /**
     * TableColums for Thursday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descThL, ndb_noThL;
    @FXML
    private TableColumn<Food, Double> energ_kcalThL, protein_gThL, lipid_tot_gThL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThL, fiber_td_gThL, iron_mgThL;
    
    /**
     * TableColums for Thursday Lunch 2
     */
    @FXML
    private TableColumn<Food, String> shrt_descThL2, ndb_noThL2;
    @FXML
    private TableColumn<Food, Double> energ_kcalThL2, protein_gThL2, lipid_tot_gThL2;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThL2, fiber_td_gThL2, iron_mgThL2;
    
    /**
     * TableColumns for Thursday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descThD, ndb_noThD;
    @FXML
    private TableColumn<Food, Double> energ_kcalThD, protein_gThD, lipid_tot_gThD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThD, fiber_td_gThD, iron_mgThD;

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
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monBreakfastList.remove(monBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        monBreakfast2.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                monBreakfast2List.add(toCopyFood);
                monBreakfast2.setItems(monBreakfast2List);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monBreakfast2List.remove(monBreakfast2.getSelectionModel().getSelectedItem());
            }
        });
        
        monLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                monLunchList.add(toCopyFood);
                monLunch.setItems(monLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monLunchList.remove(monLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        monLunch2.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                monLunch2List.add(toCopyFood);
                monLunch2.setItems(monLunch2List);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monLunch2List.remove(monLunch2.getSelectionModel().getSelectedItem());
            }
        });
        
        monDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                monDinnerList.add(toCopyFood);
                monDinner.setItems(monDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monDinnerList.remove(monDinner.getSelectionModel().getSelectedItem());
            }
        });
        
        tueBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                tueBreakfastList.add(toCopyFood);
                tueBreakfast.setItems(tueBreakfastList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                tueBreakfastList.remove(tueBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        tueBreakfast2.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                tueBreakfast2List.add(toCopyFood);
                tueBreakfast2.setItems(tueBreakfast2List);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                tueBreakfast2List.remove(tueBreakfast2.getSelectionModel().getSelectedItem());
            }
        });
        
        tueLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                tueLunchList.add(toCopyFood);
                tueLunch.setItems(tueLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                tueLunchList.remove(tueLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        tueLunch2.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                tueLunch2List.add(toCopyFood);
                tueLunch2.setItems(tueLunch2List);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                tueLunch2List.remove(tueLunch2.getSelectionModel().getSelectedItem());
            }
        });
        
        tueDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                tueDinnerList.add(toCopyFood);
                tueDinner.setItems(tueDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                tueDinnerList.remove(tueDinner.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void createTableViewCells() {

        createMainDBCells();
        
        createMondayBreakfastCells();
        createMondayBreakfast2Cells();
        createMondayLunchCells();
        createMondayLunch2Cells();
        createMondayDinnerCells();
        
        createTuesdayBreakfastCells();
        createTuesdayBreakfast2Cells();
        createTuesdayLunchCells();
        createTuesdayLunch2Cells();
        createTuesdayDinnerCells();
        
        createWednesdayBreakfastCells();
        createWednesdayBreakfast2Cells();
        createWednesdayLunchCells();
        createWednesdayLunch2Cells();
        createWednesdayDinnerCells();
        
        createThursdayBreakfastCells();
        createThursdayBreakfast2Cells();
        createThursdayLunchCells();
        createThursdayLunch2Cells();
        createThursdayDinnerCells();
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
    
    private void createMondayBreakfast2Cells() {
        /**
         * Creates Monday breakfast 2 cells
         */
        ndb_noMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgMBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createMondayLunchCells() {
        /**
         * Creates Monday Lunch cells
         */
        ndb_noML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgML.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createMondayLunch2Cells() {
        /**
         * Creates Monday Lunch 2 cells
         */
        ndb_noML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgML2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createMondayDinnerCells() {
        /**
         * Creates Monday Dinner cells
         */
        ndb_noMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgMD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createTuesdayBreakfastCells() {
        /**
         * Creates Tuesday Breakfast Cells
         */
        ndb_noTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgTBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createTuesdayBreakfast2Cells() {
        /**
         * Creates Tuesday Breakfast2 Cells
         */
        ndb_noTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgTBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createTuesdayLunchCells() {
        /**
         * Creates Tuesday Lunch cells
         */
        ndb_noTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgTL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createTuesdayLunch2Cells() {
        /**
         * Creates Tuesday Lunch cells
         */
        ndb_noTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgTL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createTuesdayDinnerCells() {
        /**
         * Creates Tuesday Dinner cells
         */
        ndb_noTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgTD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createWednesdayBreakfastCells() {
        /**
         * Creates Wednesday breakfast cells
         */
        ndb_noWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgWBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createWednesdayBreakfast2Cells() {
        /**
         * Creates Wednesday breakfast 2 cells
         */
        ndb_noWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgWBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createWednesdayLunchCells() {
        /**
         * Creates Wednesday Lunch cells
         */
        ndb_noWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgWL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createWednesdayLunch2Cells() {
        /**
         * Creates Wednesday Lunch 2 cells
         */
        ndb_noWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgWL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createWednesdayDinnerCells() {
        /**
         * Creates Wednesday Dinner cells
         */
        ndb_noWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgWD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createThursdayBreakfastCells() {
        /**
         * Creates Thursday Breakfast Cells
         */
        ndb_noThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgThBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createThursdayBreakfast2Cells() {
        /**
         * Creates Thursday Breakfast2 Cells
         */
        ndb_noThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgThBr2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createThursdayLunchCells() {
        /**
         * Creates Thursday Lunch cells
         */
        ndb_noThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgThL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createThursdayLunch2Cells() {
        /**
         * Creates Thursday Lunch cells
         */
        ndb_noThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgThL2.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createThursdayDinnerCells() {
        /**
         * Creates Thursday Dinner cells
         */
        ndb_noThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgThD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }

}
