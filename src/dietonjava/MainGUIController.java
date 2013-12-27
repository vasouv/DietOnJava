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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    @FXML
    private TableColumn<Food,String> shrt_desc, ndb_no, gmwt1_desc, gmwt2_desc;
    @FXML
    private TableColumn<Food,Double> water_g, energ_kcal, protein_g, lipid_tot_g, ash_g;
    @FXML
    private TableColumn<Food,Double> carbohydrt_g, fiber_td_g, sugar_tot_g, calcium_mg, iron_mg, magnesium_mg;
    @FXML
    private TableColumn<Food,Double> phosphorus_mg, potassium_mg, sodium_mg, zinc_mg, copper_mg;
    @FXML
    private TableColumn<Food,Double> manganese_mg, selenium_microg, vit_c_mg, thiamin_mg, riboflavin_mg;
    @FXML
    private TableColumn<Food,Double> niacin_mg, panto_acid_mg, vit_b6_mg, folate_tot_microg, folic_acid_microg;
    @FXML
    private TableColumn<Food,Double> food_folate_microg, folate_dfe_microg, choline_tot_mg, vit_b12_microg;
    @FXML
    private TableColumn<Food,Double> vit_a_iu, vit_a_rae, retinol_microg, alpha_carot_microg;
    @FXML
    private TableColumn<Food,Double> beta_carot_microg, beta_crypt_microg, lycopene_microg, lutzea_microg;
    @FXML
    private TableColumn<Food,Double> vit_e_mg, vit_d_microg, vit_d_iu, vit_k_microg, fa_sat_g;
    @FXML
    private TableColumn<Food,Double> fa_mono_g, fa_poly_g, cholesterol_mg, gmwt1, gmwt2, refuse_pct;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        createDBCells();
        
        list = fsql.listFoods();
        foodDB.setItems(list);
    }

    private void createDBCells() {
        ndb_no.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.NDB_NO));
        shrt_desc.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.SHRT_DESC));
        water_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.WATER));
        energ_kcal.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.ENERGY));
        protein_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.PROTEIN));
        lipid_tot_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.LIPIDS));
        ash_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.ASH));
        carbohydrt_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.CARBS));
        fiber_td_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FIBER));
        sugar_tot_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.SUGAR));
        calcium_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.CALCIUM));
        iron_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.IRON));
        magnesium_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.MAGNESIUM));
        phosphorus_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.PHOSPHORUS));
        potassium_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.POTASSIUM));
        sodium_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.SODIUM));
        zinc_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.ZINC));
        copper_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.COPPER));
        manganese_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.MANGANESE));
        selenium_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.SELENIUM));
        vit_c_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_C));
        thiamin_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.THIAMIN));
        riboflavin_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.RIBOFLAVIN));
        niacin_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.NIACIN));
        panto_acid_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.PANTO_ACID));
        vit_b6_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_B6));
        folate_tot_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FOLATE));
        folic_acid_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FOLIC_ACID));
        food_folate_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FOOD_FOLATE));
        folate_dfe_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FOLATE_DFE));
        choline_tot_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.CHOLINE));
        vit_b12_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_B12));
        vit_a_iu.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_A_IU));
        vit_a_rae.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_A_RAE));
        retinol_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.RETINOL));
        alpha_carot_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.ALPHA_CAROT));
        beta_carot_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.BETA_CAROT));
        beta_crypt_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.BETA_CRYPT));
        lycopene_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.LYCOPENE));
        lutzea_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.LUTZEA));
        vit_e_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_E));
        vit_d_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_D));
        vit_d_iu.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_D_IU));
        vit_k_microg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.VIT_K));
        fa_sat_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FA_SAT));
        fa_mono_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FA_MONO));
        fa_poly_g.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.FA_POLY));
        cholesterol_mg.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.CHOLESTEROL));
        gmwt1.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.GMWT1));
        gmwt1_desc.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.GMWT1_DESC));
        gmwt2.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.GMWT2));
        gmwt2_desc.setCellValueFactory(new PropertyValueFactory<Food,String>(NutrientNames.GMWT2_DESC));
        refuse_pct.setCellValueFactory(new PropertyValueFactory<Food,Double>(NutrientNames.REFUSE));
    }    
    
}
