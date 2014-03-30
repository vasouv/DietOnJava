/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava.iomanager;

import java.util.List;

/**
 * This class holds the meal lists
 * 
 * @author vasouv
 */
public class MealLists {
    
    private List mondayBr, mondayLu, mondayDi, tueBr, tueLu, tueDi;
    private List wedBr, wedLu, wedDi, thuBr, thuLu, thuDi;
    private List friBr, friLu, friDi, satBr, satLu, satDi, sunBr, sunLu, sunDi;

    public MealLists(List mondayBr, List mondayLu, List mondayDi, 
            List tueBr, List tueLu, List tueDi, List wedBr, 
            List wedLu, List wedDi, List thuBr, List thuLu, 
            List thuDi, List friBr, List friLu, List friDi, 
            List satBr, List satLu, List satDi, List sunBr, 
            List sunLu, List sunDi) {
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
    
    public MealLists(List mon) {
        mondayBr = mon;
    }
    
    

    public List getMondayBr() {
        return mondayBr;
    }

    public void setMondayBr(List mondayBr) {
        this.mondayBr = mondayBr;
    }

    public List getMondayLu() {
        return mondayLu;
    }

    public void setMondayLu(List mondayLu) {
        this.mondayLu = mondayLu;
    }

    public List getMondayDi() {
        return mondayDi;
    }

    public void setMondayDi(List mondayDi) {
        this.mondayDi = mondayDi;
    }

    public List getTueBr() {
        return tueBr;
    }

    public void setTueBr(List tueBr) {
        this.tueBr = tueBr;
    }

    public List getTueLu() {
        return tueLu;
    }

    public void setTueLu(List tueLu) {
        this.tueLu = tueLu;
    }

    public List getTueDi() {
        return tueDi;
    }

    public void setTueDi(List tueDi) {
        this.tueDi = tueDi;
    }

    public List getWedBr() {
        return wedBr;
    }

    public void setWedBr(List wedBr) {
        this.wedBr = wedBr;
    }

    public List getWedLu() {
        return wedLu;
    }

    public void setWedLu(List wedLu) {
        this.wedLu = wedLu;
    }

    public List getWedDi() {
        return wedDi;
    }

    public void setWedDi(List wedDi) {
        this.wedDi = wedDi;
    }

    public List getThuBr() {
        return thuBr;
    }

    public void setThuBr(List thuBr) {
        this.thuBr = thuBr;
    }

    public List getThuLu() {
        return thuLu;
    }

    public void setThuLu(List thuLu) {
        this.thuLu = thuLu;
    }

    public List getThuDi() {
        return thuDi;
    }

    public void setThuDi(List thuDi) {
        this.thuDi = thuDi;
    }

    public List getFriBr() {
        return friBr;
    }

    public void setFriBr(List friBr) {
        this.friBr = friBr;
    }

    public List getFriLu() {
        return friLu;
    }

    public void setFriLu(List friLu) {
        this.friLu = friLu;
    }

    public List getFriDi() {
        return friDi;
    }

    public void setFriDi(List friDi) {
        this.friDi = friDi;
    }

    public List getSatBr() {
        return satBr;
    }

    public void setSatBr(List satBr) {
        this.satBr = satBr;
    }

    public List getSatLu() {
        return satLu;
    }

    public void setSatLu(List satLu) {
        this.satLu = satLu;
    }

    public List getSatDi() {
        return satDi;
    }

    public void setSatDi(List satDi) {
        this.satDi = satDi;
    }

    public List getSunBr() {
        return sunBr;
    }

    public void setSunBr(List sunBr) {
        this.sunBr = sunBr;
    }

    public List getSunLu() {
        return sunLu;
    }

    public void setSunLu(List sunLu) {
        this.sunLu = sunLu;
    }

    public List getSunDi() {
        return sunDi;
    }

    public void setSunDi(List sunDi) {
        this.sunDi = sunDi;
    }
    
}
