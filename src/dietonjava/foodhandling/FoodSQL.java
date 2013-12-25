/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava.foodhandling;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author vasouv
 */
public class FoodSQL {
    
    private Connection connection = null;
    private Statement statement = null;
    
    private void establishConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:foods_abr.sqlite");
            statement = connection.createStatement();
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println("Couldn't connect to DB");
        }
    }
    
    private void terminateConnection() {
        try {
            connection.close();
            statement.close();
        }
        catch(SQLException e) {
            System.err.println("Couldn't close DB connection");
        }
    }
    
    public ObservableList<Food> listFoods() {
        try {
            establishConnection();
        
            ObservableList<Food>tempList = FXCollections.observableArrayList();

            ResultSet rs = statement.executeQuery("select * from foods");
            
            while(rs.next()) {
                Food foo = new Food();
                foo.setShrt_desc(rs.getString("shrt_desc"));
                foo.setWater_g(rs.getDouble("water_g"));
                foo.setEnerg_kcal(rs.getDouble("energ_kcal"));
                foo.setProtein_g(rs.getDouble("protein_g"));
                foo.setLipid_tot_g(rs.getDouble("lipid_tot_g"));
                foo.setAsh_g(rs.getDouble("ash_g"));
                
                tempList.add(foo);
            }
            
            return tempList;
        }
        catch (SQLException e) {
            System.err.println("error");
            return null;
        }
        finally {
            terminateConnection();
        }
        
    }
    
}
