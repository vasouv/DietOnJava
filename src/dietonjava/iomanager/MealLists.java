/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava.iomanager;

import dietonjava.foodhandling.Food;
import java.util.List;

/**
 * This class holds the meal lists
 * 
 * @author vasouv
 */
public class MealLists {
    
    private List<Food> mondayBr, mondayLu, mondayDi, tueBr, tueLu, tueDi;
    private List<Food> wedBr, wedLu, wedDi, thuBr, thuLu, thuDi;
    private List<Food> friBr, friLu, friDi, satBr, satLu, satDi, sunBr, sunLu, sunDi;

    public MealLists(List<Food> mondayBr, List<Food> mondayLu, List<Food> mondayDi, 
            List<Food> tueBr, List<Food> tueLu, List<Food> tueDi, 
            List<Food> wedBr, List<Food> wedLu, List<Food> wedDi, 
            List<Food> thuBr, List<Food> thuLu, List<Food> thuDi, 
            List<Food> friBr, List<Food> friLu, List<Food> friDi, 
            List<Food> satBr, List<Food> satLu, List<Food> satDi, 
            List<Food> sunBr, List<Food> sunLu, List<Food> sunDi) {
        this.mondayBr = mondayBr;
        this.mondayLu = mondayLu;
        this.mondayDi = mondayDi;
        this.tueBr = tueBr;
        this.tueLu = tueLu;
        this.tueDi = tueDi;
        this.wedBr = wedBr;
        this.wedLu = wedLu;
        this.wedDi = wedDi;
        this.thuBr = thuBr;
        this.thuLu = thuLu;
        this.thuDi = thuDi;
        this.friBr = friBr;
        this.friLu = friLu;
        this.friDi = friDi;
        this.satBr = satBr;
        this.satLu = satLu;
        this.satDi = satDi;
        this.sunBr = sunBr;
        this.sunLu = sunLu;
        this.sunDi = sunDi;
    }

    public List<Food> getMondayBr() {
        return mondayBr;
    }

    public void setMondayBr(List<Food> mondayBr) {
        this.mondayBr = mondayBr;
    }

    public List<Food> getMondayLu() {
        return mondayLu;
    }

    public void setMondayLu(List<Food> mondayLu) {
        this.mondayLu = mondayLu;
    }

    public List<Food> getMondayDi() {
        return mondayDi;
    }

    public void setMondayDi(List<Food> mondayDi) {
        this.mondayDi = mondayDi;
    }

    public List<Food> getTueBr() {
        return tueBr;
    }

    public void setTueBr(List<Food> tueBr) {
        this.tueBr = tueBr;
    }

    public List<Food> getTueLu() {
        return tueLu;
    }

    public void setTueLu(List<Food> tueLu) {
        this.tueLu = tueLu;
    }

    public List<Food> getTueDi() {
        return tueDi;
    }

    public void setTueDi(List<Food> tueDi) {
        this.tueDi = tueDi;
    }

    public List<Food> getWedBr() {
        return wedBr;
    }

    public void setWedBr(List<Food> wedBr) {
        this.wedBr = wedBr;
    }

    public List<Food> getWedLu() {
        return wedLu;
    }

    public void setWedLu(List<Food> wedLu) {
        this.wedLu = wedLu;
    }

    public List<Food> getWedDi() {
        return wedDi;
    }

    public void setWedDi(List<Food> wedDi) {
        this.wedDi = wedDi;
    }

    public List<Food> getThuBr() {
        return thuBr;
    }

    public void setThuBr(List<Food> thuBr) {
        this.thuBr = thuBr;
    }

    public List<Food> getThuLu() {
        return thuLu;
    }

    public void setThuLu(List<Food> thuLu) {
        this.thuLu = thuLu;
    }

    public List<Food> getThuDi() {
        return thuDi;
    }

    public void setThuDi(List<Food> thuDi) {
        this.thuDi = thuDi;
    }

    public List<Food> getFriBr() {
        return friBr;
    }

    public void setFriBr(List<Food> friBr) {
        this.friBr = friBr;
    }

    public List<Food> getFriLu() {
        return friLu;
    }

    public void setFriLu(List<Food> friLu) {
        this.friLu = friLu;
    }

    public List<Food> getFriDi() {
        return friDi;
    }

    public void setFriDi(List<Food> friDi) {
        this.friDi = friDi;
    }

    public List<Food> getSatBr() {
        return satBr;
    }

    public void setSatBr(List<Food> satBr) {
        this.satBr = satBr;
    }

    public List<Food> getSatLu() {
        return satLu;
    }

    public void setSatLu(List<Food> satLu) {
        this.satLu = satLu;
    }

    public List<Food> getSatDi() {
        return satDi;
    }

    public void setSatDi(List<Food> satDi) {
        this.satDi = satDi;
    }

    public List<Food> getSunBr() {
        return sunBr;
    }

    public void setSunBr(List<Food> sunBr) {
        this.sunBr = sunBr;
    }

    public List<Food> getSunLu() {
        return sunLu;
    }

    public void setSunLu(List<Food> sunLu) {
        this.sunLu = sunLu;
    }

    public List<Food> getSunDi() {
        return sunDi;
    }

    public void setSunDi(List<Food> sunDi) {
        this.sunDi = sunDi;
    }

    
    
}
