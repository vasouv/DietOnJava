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
    
    private String ndb_no, shrt_desc;
    private double energ_kcal, protein_g, lipid_tot_g;
    private double carbohydrt_g, fiber_td_g, iron_mg;
    
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

    public double getIron_mg() {
        return iron_mg;
    }

    public void setIron_mg(double iron_mg) {
        this.iron_mg = iron_mg;
    }

}