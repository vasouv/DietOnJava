/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dietonjava;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dietonjava.foodhandling.Food;
import dietonjava.foodhandling.FoodSQL;
import dietonjava.foodhandling.NutrientNames;
import dietonjava.iomanager.DietSchedule;
import dietonjava.iomanager.FileHandling;
import dietonjava.iomanager.MealLists;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;

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
    private TableView<Food> monBreakfast, monLunch, monDinner;
    
    @FXML
    private TableView<Food> tueBreakfast, tueLunch, tueDinner;
    
    @FXML
    private TableView<Food> wedBreakfast, wedLunch, wedDinner;
    
    @FXML
    private TableView<Food> thuBreakfast, thuLunch, thuDinner;
    
    @FXML
    private TableView<Food> friBreakfast, friLunch, friDinner;
    
    @FXML
    private TableView<Food> satBreakfast, satLunch, satDinner;
    
    @FXML
    private TableView<Food> sunBreakfast, sunLunch, sunDinner;
    
    @FXML
    private Button openFile, saveFile;

    /**
     * The following variables hold each person's data
     */
    @FXML
    private TextField searchBox;
    
    @FXML
    private TextField nameText, surnameText, addressText, telText, dateText;
    
    @FXML
    private TextField kgText, ageText, heightText;
    
    @FXML
    private TextArea notesTextArea;
    
    DietSchedule schedule;
    MealLists meals;
    
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    FileHandling fileIO = new FileHandling();

    /**
     * Temp food that is drag'n'dropped from the DB
     */
    Food toCopyFood;

    /**
     * Temp lists that holds the food to be added to the specified day TableView
     */
    ObservableList<Food> monBreakfastList = observableArrayList();
    ObservableList<Food> monLunchList = observableArrayList();
    ObservableList<Food> monDinnerList = observableArrayList();
    
    ObservableList<Food> tueBreakfastList = observableArrayList();
    ObservableList<Food> tueLunchList = observableArrayList();
    ObservableList<Food> tueDinnerList = observableArrayList();
    
    ObservableList<Food> wedBreakfastList = observableArrayList();
    ObservableList<Food> wedLunchList = observableArrayList();
    ObservableList<Food> wedDinnerList = observableArrayList();
    
    ObservableList<Food> thuBreakfastList = observableArrayList();
    ObservableList<Food> thuLunchList = observableArrayList();
    ObservableList<Food> thuDinnerList = observableArrayList();
    
    ObservableList<Food> friBreakfastList = observableArrayList();
    ObservableList<Food> friLunchList = observableArrayList();
    ObservableList<Food> friDinnerList = observableArrayList();
    
    ObservableList<Food> satBreakfastList = observableArrayList();
    ObservableList<Food> satLunchList = observableArrayList();
    ObservableList<Food> satDinnerList = observableArrayList();
    
    ObservableList<Food> sunBreakfastList = observableArrayList();
    ObservableList<Food> sunLunchList = observableArrayList();
    ObservableList<Food> sunDinnerList = observableArrayList();

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
     * TableColums for Monday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descML, ndb_noML;
    @FXML
    private TableColumn<Food, Double> energ_kcalML, protein_gML, lipid_tot_gML;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gML, fiber_td_gML, iron_mgML;
    
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
     * TableColums for Tuesday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descTL, ndb_noTL;
    @FXML
    private TableColumn<Food, Double> energ_kcalTL, protein_gTL, lipid_tot_gTL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gTL, fiber_td_gTL, iron_mgTL;
    
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
     * TableColums for Wednesday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descWL, ndb_noWL;
    @FXML
    private TableColumn<Food, Double> energ_kcalWL, protein_gWL, lipid_tot_gWL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gWL, fiber_td_gWL, iron_mgWL;
    
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
     * TableColums for Thursday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descThL, ndb_noThL;
    @FXML
    private TableColumn<Food, Double> energ_kcalThL, protein_gThL, lipid_tot_gThL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThL, fiber_td_gThL, iron_mgThL;
    
    /**
     * TableColumns for Thursday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descThD, ndb_noThD;
    @FXML
    private TableColumn<Food, Double> energ_kcalThD, protein_gThD, lipid_tot_gThD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gThD, fiber_td_gThD, iron_mgThD;
    
    /**
     * TableColums for Friday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descFBr, ndb_noFBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalFBr, protein_gFBr, lipid_tot_gFBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gFBr, fiber_td_gFBr, iron_mgFBr;
    
    /**
     * TableColums for Friday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descFL, ndb_noFL;
    @FXML
    private TableColumn<Food, Double> energ_kcalFL, protein_gFL, lipid_tot_gFL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gFL, fiber_td_gFL, iron_mgFL;
    
    /**
     * TableColumns for Friday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descFD, ndb_noFD;
    @FXML
    private TableColumn<Food, Double> energ_kcalFD, protein_gFD, lipid_tot_gFD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gFD, fiber_td_gFD, iron_mgFD;
    
    /**
     * TableColums for Saturday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descSBr, ndb_noSBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalSBr, protein_gSBr, lipid_tot_gSBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gSBr, fiber_td_gSBr, iron_mgSBr;
    
    /**
     * TableColums for Saturday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descSL, ndb_noSL;
    @FXML
    private TableColumn<Food, Double> energ_kcalSL, protein_gSL, lipid_tot_gSL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gSL, fiber_td_gSL, iron_mgSL;
    
    /**
     * TableColumns for Saturday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descSD, ndb_noSD;
    @FXML
    private TableColumn<Food, Double> energ_kcalSD, protein_gSD, lipid_tot_gSD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gSD, fiber_td_gSD, iron_mgSD;
    
    /**
     * TableColums for Sunday Breakfast
     */
    @FXML
    private TableColumn<Food, String> shrt_descSuBr, ndb_noSuBr;
    @FXML
    private TableColumn<Food, Double> energ_kcalSuBr, protein_gSuBr, lipid_tot_gSuBr;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gSuBr, fiber_td_gSuBr, iron_mgSuBr;
    
    /**
     * TableColums for Saturday Lunch
     */
    @FXML
    private TableColumn<Food, String> shrt_descSuL, ndb_noSuL;
    @FXML
    private TableColumn<Food, Double> energ_kcalSuL, protein_gSuL, lipid_tot_gSuL;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gSuL, fiber_td_gSuL, iron_mgSuL;
    
    /**
     * TableColumns for Saturday Dinner
     */
    @FXML
    private TableColumn<Food, String> shrt_descSuD, ndb_noSuD;
    @FXML
    private TableColumn<Food, Double> energ_kcalSuD, protein_gSuD, lipid_tot_gSuD;
    @FXML
    private TableColumn<Food, Double> carbohydrt_gSuD, fiber_td_gSuD, iron_mgSuD;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createTableViewCells();

        list = fsql.listFoods();
        foodDB.setItems(list);
        
        populateInfo();
    }
    
    /**
     * Temporary data to populate the TableViews while testing
     */
    private void populateInfo() {
        
        nameText.setText("Xristos");
        surnameText.setText("Laukas");
        addressText.setText("Pera dw8e");
        telText.setText("123456789");
        dateText.setText("30-3-2014");
        kgText.setText("120");
        ageText.setText("27");
        heightText.setText("1.80");
        notesTextArea.setText("These are some notes that are supposed to be included here about this specific client's diet");
        
        monBreakfastList.add(list.get(1));
        monBreakfast.setItems(monBreakfastList);
        monLunchList.add(list.get(2));
        monLunch.setItems(monLunchList);
        monDinnerList.add(list.get(3));
        monDinner.setItems(monDinnerList);
        
        tueBreakfastList.add(list.get(4));
        tueBreakfast.setItems(tueBreakfastList);
        tueLunchList.add(list.get(5));
        tueLunch.setItems(tueLunchList);
        tueDinnerList.add(list.get(6));
        tueDinner.setItems(tueDinnerList);
        
        wedBreakfastList.add(list.get(7));
        wedBreakfast.setItems(wedBreakfastList);
        wedLunchList.add(list.get(8));
        wedLunch.setItems(wedLunchList);
        wedDinnerList.add(list.get(9));
        wedDinner.setItems(wedDinnerList);
        
        thuBreakfastList.add(list.get(10));
        thuBreakfast.setItems(thuBreakfastList);
        thuLunchList.add(list.get(11));
        thuLunch.setItems(thuLunchList);
        thuDinnerList.add(list.get(12));
        thuDinner.setItems(thuDinnerList);
        
        friBreakfastList.add(list.get(13));
        friBreakfast.setItems(friBreakfastList);
        friLunchList.add(list.get(14));
        friLunch.setItems(friLunchList);
        friDinnerList.add(list.get(15));
        friDinner.setItems(friDinnerList);
        
        satBreakfastList.add(list.get(16));
        satBreakfast.setItems(satBreakfastList);
        satLunchList.add(list.get(17));
        satLunch.setItems(satLunchList);
        satDinnerList.add(list.get(18));
        satDinner.setItems(satDinnerList);
        
        sunBreakfastList.add(list.get(19));
        sunBreakfast.setItems(sunBreakfastList);
        sunLunchList.add(list.get(20));
        sunLunch.setItems(sunLunchList);
        sunDinnerList.add(list.get(21));
        sunDinner.setItems(sunDinnerList);
        
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
     * When the button New is pressed, it clears all fields and meal tables
     */
    @FXML
    private void createNewProgram(MouseEvent event) {
        nameText.setText("");
        surnameText.setText("");
        addressText.setText("");
        telText.setText("");
        dateText.setText("");
        notesTextArea.setText("");
        kgText.setText("");
        ageText.setText("");
        heightText.setText("");
        
        monBreakfastList.clear();
        monLunchList.clear();
        monDinnerList.clear();
        
        tueBreakfastList.clear();
        tueLunchList.clear();
        tueDinnerList.clear();
        
        wedBreakfastList.clear();
        wedLunchList.clear();
        wedDinnerList.clear();
        
        thuBreakfastList.clear();
        thuLunchList.clear();
        thuDinnerList.clear();
        
        friBreakfastList.clear();
        friLunchList.clear();
        friDinnerList.clear();
        
        satBreakfastList.clear();
        satLunchList.clear();
        satDinnerList.clear();
        
        sunBreakfastList.clear();
        sunLunchList.clear();
        sunDinnerList.clear();
    }
    
    /**
     * NOT FINISHED
     */
    @FXML
    private void openJSONFile(MouseEvent event) {
        openFile.setOnMouseClicked((MouseEvent e1) -> {
            FileChooser fChooser = new FileChooser();
            File file = fChooser.showOpenDialog(openFile.getScene().getWindow());
            try {
//                System.out.println(fileIO.readJSONFile(file.getPath()));
                String jsonContents = fileIO.readJSONFile(file.getPath());
                schedule = gson.fromJson(jsonContents, DietSchedule.class);
                replaceFields(schedule);
            } catch (IOException ex) {
                Logger.getLogger(MainGUIController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    //TABLEVIEWS DO NOT SHOW THE DATA!!!
    private void replaceFields(DietSchedule ds){
        nameText.setText(ds.getName());
        surnameText.setText(ds.getSurname());
        addressText.setText(ds.getAddress());
        telText.setText(ds.getTelephone());
        dateText.setText(ds.getDate());
        kgText.setText(ds.getKg());
        ageText.setText(ds.getAge());
        heightText.setText(ds.getHeight());
        notesTextArea.setText(ds.getNotes());
        
        monBreakfastList.setAll(ds.getMealLists().getMondayBr());
        monBreakfast.setItems(monBreakfastList);
        monLunchList.setAll(ds.getMealLists().getMondayLu());
        monLunch.setItems(monLunchList);
        monDinnerList.setAll(ds.getMealLists().getMondayDi());
        monDinner.setItems(monDinnerList);
        
        tueBreakfastList.setAll(ds.getMealLists().getTueBr());
        tueBreakfast.setItems(tueBreakfastList);
        tueLunchList.setAll(ds.getMealLists().getTueLu());
        tueLunch.setItems(tueLunchList);
        tueDinnerList.setAll(ds.getMealLists().getTueDi());
        tueDinner.setItems(tueDinnerList);
        
        wedBreakfastList.setAll(ds.getMealLists().getWedBr());
        wedBreakfast.setItems(wedBreakfastList);
        wedLunchList.setAll(ds.getMealLists().getWedLu());
        wedLunch.setItems(wedLunchList);
        wedDinnerList.setAll(ds.getMealLists().getWedDi());
        wedDinner.setItems(wedDinnerList);
        
        thuBreakfastList.setAll(ds.getMealLists().getThuBr());
        thuBreakfast.setItems(thuBreakfastList);
        thuLunchList.setAll(ds.getMealLists().getThuBr());
        thuLunch.setItems(thuLunchList);
        thuDinnerList.setAll(ds.getMealLists().getThuDi());
        thuDinner.setItems(thuDinnerList);
        
        friBreakfastList.setAll(ds.getMealLists().getFriBr());
        friBreakfast.setItems(friBreakfastList);
        friLunchList.setAll(ds.getMealLists().getFriLu());
        friLunch.setItems(friLunchList);
        friDinnerList.setAll(ds.getMealLists().getFriDi());
        friDinner.setItems(friDinnerList);
        
        satBreakfastList.setAll(ds.getMealLists().getSatBr());
        satBreakfast.setItems(satBreakfastList);
        satLunchList.setAll(ds.getMealLists().getSatLu());
        satLunch.setItems(satBreakfastList);
        satDinnerList.setAll(ds.getMealLists().getSatDi());
        satDinner.setItems(satDinnerList);
        
        sunBreakfastList.setAll(ds.getMealLists().getSunBr());
        sunBreakfast.setItems(sunBreakfastList);
        sunLunchList.setAll(ds.getMealLists().getSunLu());
        sunLunch.setItems(sunLunchList);
        sunDinnerList.setAll(ds.getMealLists().getSunDi());
        sunDinner.setItems(sunDinnerList);
        
    }
    
    @FXML
    private void saveJSONFile(MouseEvent event) throws IOException {
        meals = new MealLists(monBreakfastList, monLunchList, monDinnerList,
            tueBreakfastList, tueLunchList, tueDinnerList, 
            wedBreakfastList, wedLunchList, wedDinnerList,
            thuBreakfastList, thuLunchList, thuDinnerList,
            friBreakfastList, friLunchList, friDinnerList,
            satBreakfastList, satLunchList, satDinnerList,
            sunBreakfastList, sunLunchList, sunDinnerList);
        
        schedule = new DietSchedule(nameText.getText(), surnameText.getText(), 
                addressText.getText(), telText.getText(), dateText.getText(), 
                kgText.getText(), ageText.getText(), heightText.getText(), 
                notesTextArea.getText(), meals);
        
        String firstJSON = gson.toJson(schedule, DietSchedule.class);
        
        fileIO.writeJSONFile(firstJSON, "test.json");
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
        
        monLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                monLunchList.add(toCopyFood);
                monLunch.setItems(monLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                monLunchList.remove(monLunch.getSelectionModel().getSelectedItem());
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
        
        tueLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                tueLunchList.add(toCopyFood);
                tueLunch.setItems(tueLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                tueLunchList.remove(tueLunch.getSelectionModel().getSelectedItem());
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
        
        wedBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                wedBreakfastList.add(toCopyFood);
                wedBreakfast.setItems(wedBreakfastList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                wedBreakfastList.remove(wedBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        wedLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                wedLunchList.add(toCopyFood);
                wedLunch.setItems(wedLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                wedLunchList.remove(wedLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        wedDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                wedDinnerList.add(toCopyFood);
                wedDinner.setItems(wedDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                wedDinnerList.remove(wedDinner.getSelectionModel().getSelectedItem());
            }
        });
        
        thuBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                thuBreakfastList.add(toCopyFood);
                thuBreakfast.setItems(thuBreakfastList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                thuBreakfastList.remove(thuBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        thuLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                thuLunchList.add(toCopyFood);
                thuLunch.setItems(thuLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                thuLunchList.remove(thuLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        thuDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                thuDinnerList.add(toCopyFood);
                thuDinner.setItems(thuDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                thuDinnerList.remove(thuDinner.getSelectionModel().getSelectedItem());
            }
        });
        
        friBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                friBreakfastList.add(toCopyFood);
                friBreakfast.setItems(friBreakfastList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                friBreakfastList.remove(friBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        friLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                friLunchList.add(toCopyFood);
                friLunch.setItems(friLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                friLunchList.remove(friLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        friDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                friDinnerList.add(toCopyFood);
                friDinner.setItems(friDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                friDinnerList.remove(friDinner.getSelectionModel().getSelectedItem());
            }
        });
        
        satBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                satBreakfastList.add(toCopyFood);
                satBreakfast.setItems(satBreakfastList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                satBreakfastList.remove(satBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        satLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                satLunchList.add(toCopyFood);
                satLunch.setItems(satLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                satLunchList.remove(satLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        satDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                satDinnerList.add(toCopyFood);
                satDinner.setItems(satDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                satDinnerList.remove(satDinner.getSelectionModel().getSelectedItem());
            }
        });
        
        sunBreakfast.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                sunBreakfastList.add(toCopyFood);
                sunBreakfast.setItems(sunBreakfastList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                sunBreakfastList.remove(sunBreakfast.getSelectionModel().getSelectedItem());
            }
        });
        
        sunLunch.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                sunLunchList.add(toCopyFood);
                sunLunch.setItems(sunLunchList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                sunLunchList.remove(sunLunch.getSelectionModel().getSelectedItem());
            }
        });
        
        sunDinner.setOnMouseClicked((MouseEvent event1) -> {
            if (event1.getClickCount() == 2) {
                sunDinnerList.add(toCopyFood);
                sunDinner.setItems(sunDinnerList);
            }
            if (event1.isControlDown() && event1.getClickCount() == 1) {
                sunDinnerList.remove(sunDinner.getSelectionModel().getSelectedItem());
            }
        });
    }

    private void createTableViewCells() {

        createMainDBCells();
        
        createMondayBreakfastCells();
        createMondayLunchCells();
        createMondayDinnerCells();
        
        createTuesdayBreakfastCells();
        createTuesdayLunchCells();
        createTuesdayDinnerCells();
        
        createWednesdayBreakfastCells();
        createWednesdayLunchCells();
        createWednesdayDinnerCells();
        
        createThursdayBreakfastCells();
        createThursdayLunchCells();
        createThursdayDinnerCells();
        
        createFridayBreakfastCells();
        createFridayLunchCells();
        createFridayDinnerCells();
        
        createSaturdayBreakfastCells();
        createSaturdayLunchCells();
        createSaturdayDinnerCells();
        
        createSundayBreakfastCells();
        createSundayLunchCells();
        createSundayDinnerCells();
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
    
    private void createFridayBreakfastCells() {
        /**
         * Creates Friday Breakfast Cells
         */
        ndb_noFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgFBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createFridayLunchCells() {
        /**
         * Creates Friday Lunch cells
         */
        ndb_noFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgFL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createFridayDinnerCells() {
        /**
         * Creates Friday Dinner cells
         */
        ndb_noFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgFD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createSaturdayBreakfastCells() {
        /**
         * Creates Saturday Breakfast Cells
         */
        ndb_noSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgSBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createSaturdayLunchCells() {
        /**
         * Creates Saturday Lunch cells
         */
        ndb_noSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgSL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createSaturdayDinnerCells() {
        /**
         * Creates Saturday Dinner cells
         */
        ndb_noSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgSD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createSundayBreakfastCells() {
        /**
         * Creates Sunday Breakfast Cells
         */
        ndb_noSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgSuBr.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createSundayLunchCells() {
        /**
         * Creates Sunday Lunch cells
         */
        ndb_noSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgSuL.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }
    
    private void createSundayDinnerCells() {
        /**
         * Creates Sunday Dinner cells
         */
        ndb_noSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.NDB_NO));
        shrt_descSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.SHRT_DESC));
        energ_kcalSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.ENERGY));
        protein_gSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.PROTEIN));
        lipid_tot_gSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.LIPIDS));
        carbohydrt_gSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.CARBS));
        fiber_td_gSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.FIBER));
        iron_mgSuD.setCellValueFactory(new PropertyValueFactory<>(NutrientNames.IRON));
    }

}
