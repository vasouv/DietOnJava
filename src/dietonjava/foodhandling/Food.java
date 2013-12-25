/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava.foodhandling;

import java.io.Serializable;

/**
 *
 * @author vasouv
 */
public class Food implements Serializable {
    
    private String ndb_no, shrt_desc, gmwt1_desc, gmwt2_desc;
    private double water_g, energ_kcal, protein_g, lipid_tot_g, ash_g, carbohydrt_g;
    private double fiber_td_g, sugar_tot_g, calcium_mg, iron_mg, magnesium_mg;
    private double phosphorus_mg, potassium_mg, sodium_mg, zinc_mg, copper_mg;
    private double manganese_mg, selenium_microg, vit_c_mg, thiamin_mg, riboflavin_mg;
    private double niacin_mg, panto_acid_mg, vit_b6_mg, folate_tot_microg, folic_acid_microg;
    private double food_folate_microg, folate_dfe_microg, choline_tot_mg, vit_b12_microg;
    private double vit_a_iu, vit_a_rae, retinol_microg, alpha_carot_microg;
    private double beta_carot_microg, beta_crypt_microg, lycopene_microg, lutzea_microg;
    private double vit_e_mg, vit_d_microg, vit_d_iu, vit_k_microg, fa_sat_g;
    private double fa_mono_g, fa_poly_g, cholesterol_mg, gmwt1, gmwt2, refuse_pct;
    
    public Food() {}

    public String getNdb_no() {
        return ndb_no;
    }

    public void setNdb_no(String ndb_no) {
        this.ndb_no = ndb_no;
    }

    public String getShrt_desc() {
        return shrt_desc;
    }

    public void setShrt_desc(String shrt_desc) {
        this.shrt_desc = shrt_desc;
    }

    public String getGmwt1_desc() {
        return gmwt1_desc;
    }

    public void setGmwt1_desc(String gmwt1_desc) {
        this.gmwt1_desc = gmwt1_desc;
    }

    public String getGmwt2_desc() {
        return gmwt2_desc;
    }

    public void setGmwt2_desc(String gmwt2_desc) {
        this.gmwt2_desc = gmwt2_desc;
    }

    public double getWater_g() {
        return water_g;
    }

    public void setWater_g(double water_g) {
        this.water_g = water_g;
    }

    public double getEnerg_kcal() {
        return energ_kcal;
    }

    public void setEnerg_kcal(double energ_kcal) {
        this.energ_kcal = energ_kcal;
    }

    public double getProtein_g() {
        return protein_g;
    }

    public void setProtein_g(double protein_g) {
        this.protein_g = protein_g;
    }

    public double getLipid_tot_g() {
        return lipid_tot_g;
    }

    public void setLipid_tot_g(double lipid_tot_g) {
        this.lipid_tot_g = lipid_tot_g;
    }

    public double getAsh_g() {
        return ash_g;
    }

    public void setAsh_g(double ash_g) {
        this.ash_g = ash_g;
    }

    public double getCarbohydrt_g() {
        return carbohydrt_g;
    }

    public void setCarbohydrt_g(double carbohydrt_g) {
        this.carbohydrt_g = carbohydrt_g;
    }

    public double getFiber_td_g() {
        return fiber_td_g;
    }

    public void setFiber_td_g(double fiber_td_g) {
        this.fiber_td_g = fiber_td_g;
    }

    public double getSugar_tot_g() {
        return sugar_tot_g;
    }

    public void setSugar_tot_g(double sugar_tot_g) {
        this.sugar_tot_g = sugar_tot_g;
    }

    public double getCalcium_mg() {
        return calcium_mg;
    }

    public void setCalcium_mg(double calcium_mg) {
        this.calcium_mg = calcium_mg;
    }

    public double getIron_mg() {
        return iron_mg;
    }

    public void setIron_mg(double iron_mg) {
        this.iron_mg = iron_mg;
    }

    public double getMagnesium_mg() {
        return magnesium_mg;
    }

    public void setMagnesium_mg(double magnesium_mg) {
        this.magnesium_mg = magnesium_mg;
    }

    public double getPhosphorus_mg() {
        return phosphorus_mg;
    }

    public void setPhosphorus_mg(double phosphorus_mg) {
        this.phosphorus_mg = phosphorus_mg;
    }

    public double getPotassium_mg() {
        return potassium_mg;
    }

    public void setPotassium_mg(double potassium_mg) {
        this.potassium_mg = potassium_mg;
    }

    public double getSodium_mg() {
        return sodium_mg;
    }

    public void setSodium_mg(double sodium_mg) {
        this.sodium_mg = sodium_mg;
    }

    public double getZinc_mg() {
        return zinc_mg;
    }

    public void setZinc_mg(double zinc_mg) {
        this.zinc_mg = zinc_mg;
    }

    public double getCopper_mg() {
        return copper_mg;
    }

    public void setCopper_mg(double copper_mg) {
        this.copper_mg = copper_mg;
    }

    public double getManganese_mg() {
        return manganese_mg;
    }

    public void setManganese_mg(double manganese_mg) {
        this.manganese_mg = manganese_mg;
    }

    public double getSelenium_microg() {
        return selenium_microg;
    }

    public void setSelenium_microg(double selenium_microg) {
        this.selenium_microg = selenium_microg;
    }

    public double getVit_c_mg() {
        return vit_c_mg;
    }

    public void setVit_c_mg(double vit_c_mg) {
        this.vit_c_mg = vit_c_mg;
    }

    public double getThiamin_mg() {
        return thiamin_mg;
    }

    public void setThiamin_mg(double thiamin_mg) {
        this.thiamin_mg = thiamin_mg;
    }

    public double getRiboflavin_mg() {
        return riboflavin_mg;
    }

    public void setRiboflavin_mg(double riboflavin_mg) {
        this.riboflavin_mg = riboflavin_mg;
    }

    public double getNiacin_mg() {
        return niacin_mg;
    }

    public void setNiacin_mg(double niacin_mg) {
        this.niacin_mg = niacin_mg;
    }

    public double getPanto_acid_mg() {
        return panto_acid_mg;
    }

    public void setPanto_acid_mg(double panto_acid_mg) {
        this.panto_acid_mg = panto_acid_mg;
    }

    public double getVit_b6_mg() {
        return vit_b6_mg;
    }

    public void setVit_b6_mg(double vit_b6_mg) {
        this.vit_b6_mg = vit_b6_mg;
    }

    public double getFolate_tot_microg() {
        return folate_tot_microg;
    }

    public void setFolate_tot_microg(double folate_tot_microg) {
        this.folate_tot_microg = folate_tot_microg;
    }

    public double getFolic_acid_microg() {
        return folic_acid_microg;
    }

    public void setFolic_acid_microg(double folic_acid_microg) {
        this.folic_acid_microg = folic_acid_microg;
    }

    public double getFood_folate_microg() {
        return food_folate_microg;
    }

    public void setFood_folate_microg(double food_folate_microg) {
        this.food_folate_microg = food_folate_microg;
    }

    public double getFolate_dfe_microg() {
        return folate_dfe_microg;
    }

    public void setFolate_dfe_microg(double folate_dfe_microg) {
        this.folate_dfe_microg = folate_dfe_microg;
    }

    public double getCholine_tot_mg() {
        return choline_tot_mg;
    }

    public void setCholine_tot_mg(double choline_tot_mg) {
        this.choline_tot_mg = choline_tot_mg;
    }

    public double getVit_b12_microg() {
        return vit_b12_microg;
    }

    public void setVit_b12_microg(double vit_b12_microg) {
        this.vit_b12_microg = vit_b12_microg;
    }

    public double getVit_a_iu() {
        return vit_a_iu;
    }

    public void setVit_a_iu(double vit_a_iu) {
        this.vit_a_iu = vit_a_iu;
    }

    public double getVit_a_rae() {
        return vit_a_rae;
    }

    public void setVit_a_rae(double vit_a_rae) {
        this.vit_a_rae = vit_a_rae;
    }

    public double getRetinol_microg() {
        return retinol_microg;
    }

    public void setRetinol_microg(double retinol_microg) {
        this.retinol_microg = retinol_microg;
    }

    public double getAlpha_carot_microg() {
        return alpha_carot_microg;
    }

    public void setAlpha_carot_microg(double alpha_carot_microg) {
        this.alpha_carot_microg = alpha_carot_microg;
    }

    public double getBeta_carot_microg() {
        return beta_carot_microg;
    }

    public void setBeta_carot_microg(double beta_carot_microg) {
        this.beta_carot_microg = beta_carot_microg;
    }

    public double getBeta_crypt_microg() {
        return beta_crypt_microg;
    }

    public void setBeta_crypt_microg(double beta_crypt_microg) {
        this.beta_crypt_microg = beta_crypt_microg;
    }

    public double getLycopene_microg() {
        return lycopene_microg;
    }

    public void setLycopene_microg(double lycopene_microg) {
        this.lycopene_microg = lycopene_microg;
    }

    public double getLutzea_microg() {
        return lutzea_microg;
    }

    public void setLutzea_microg(double lutzea_microg) {
        this.lutzea_microg = lutzea_microg;
    }

    public double getVit_e_mg() {
        return vit_e_mg;
    }

    public void setVit_e_mg(double vit_e_mg) {
        this.vit_e_mg = vit_e_mg;
    }

    public double getVit_d_microg() {
        return vit_d_microg;
    }

    public void setVit_d_microg(double vit_d_microg) {
        this.vit_d_microg = vit_d_microg;
    }

    public double getVit_d_iu() {
        return vit_d_iu;
    }

    public void setVit_d_iu(double vit_d_iu) {
        this.vit_d_iu = vit_d_iu;
    }

    public double getVit_k_microg() {
        return vit_k_microg;
    }

    public void setVit_k_microg(double vit_k_microg) {
        this.vit_k_microg = vit_k_microg;
    }

    public double getFa_sat_g() {
        return fa_sat_g;
    }

    public void setFa_sat_g(double fa_sat_g) {
        this.fa_sat_g = fa_sat_g;
    }

    public double getFa_mono_g() {
        return fa_mono_g;
    }

    public void setFa_mono_g(double fa_mono_g) {
        this.fa_mono_g = fa_mono_g;
    }

    public double getFa_poly_g() {
        return fa_poly_g;
    }

    public void setFa_poly_g(double fa_poly_g) {
        this.fa_poly_g = fa_poly_g;
    }

    public double getCholesterol_mg() {
        return cholesterol_mg;
    }

    public void setCholesterol_mg(double cholesterol_mg) {
        this.cholesterol_mg = cholesterol_mg;
    }

    public double getGmwt1() {
        return gmwt1;
    }

    public void setGmwt1(double gmwt1) {
        this.gmwt1 = gmwt1;
    }

    public double getGmwt2() {
        return gmwt2;
    }

    public void setGmwt2(double gmwt2) {
        this.gmwt2 = gmwt2;
    }

    public double getRefuse_pct() {
        return refuse_pct;
    }

    public void setRefuse_pct(double refuse_pct) {
        this.refuse_pct = refuse_pct;
    }
    
    
    
}
