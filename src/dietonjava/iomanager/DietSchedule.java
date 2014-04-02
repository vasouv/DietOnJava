/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava.iomanager;

/**
 * This class holds data to be written or read to/from XML files. Basically
 * it's the data from the GUI.
 * 
 * @author vasouv
 */
public class DietSchedule {
    
    private String name, surname, address, telephone, date, kg, age, height, notes;
    private MealLists mealLists;

    public DietSchedule(String name, String surname, String address, String telephone, 
            String date, String kg, String age, String height, String notes, MealLists mealLists) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.telephone = telephone;
        this.date = date;
        this.kg = kg;
        this.age = age;
        this.height = height;
        this.notes = notes;
        this.mealLists = mealLists;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public MealLists getMealLists() {
        return mealLists;
    }

    public void setMealLists(MealLists mealLists) {
        this.mealLists = mealLists;
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname();
    }
}
