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
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Couldn't connect to DB");
        }
    }

    private void terminateConnection() {
        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            System.err.println("Couldn't close DB connection");
        }
    }

    public ObservableList<Food> searchDB(String term) {

        establishConnection();
        
        ObservableList<Food> search = FXCollections.observableArrayList();

        ResultSet rs = null;
        
        String sqlQuery = new String();

        try {
            if (term == null) {
                sqlQuery = "select * from foods";
            } else {
                sqlQuery = "select * from foods where short_desc like '%" + term + "%';";
            }
            
            rs = statement.executeQuery(sqlQuery);

            while (rs.next()) {
                Food foo = new Food();

                foo.setNdb_no(rs.getString(1));
                foo.setShrt_desc(rs.getString(2));
                foo.setEnerg_kcal(rs.getDouble(3));
                foo.setProtein_g(rs.getDouble(4));
                foo.setLipid_tot_g(rs.getDouble(5));
                foo.setCarbohydrt_g(rs.getDouble(6));
                foo.setFiber_td_g(rs.getDouble(7));
                foo.setCalcium_mg(rs.getDouble(8));
                foo.setIron_mg(rs.getDouble(9));
                
                search.add(foo);
            }
            
            return search;
            
        } catch (SQLException e) {
            System.err.println("SQL Exception caught");
            return null;
        } finally {
            terminateConnection();
        }
    }

    public ObservableList<Food> listFoods() {
        try {
            establishConnection();

            ObservableList<Food> tempList = FXCollections.observableArrayList();

            ResultSet rs = statement.executeQuery("select * from foods");

            while (rs.next()) {
                Food foo = new Food();

                foo.setNdb_no(rs.getString(1));
                foo.setShrt_desc(rs.getString(2));
                foo.setEnerg_kcal(rs.getDouble(3));
                foo.setProtein_g(rs.getDouble(4));
                foo.setLipid_tot_g(rs.getDouble(5));
                foo.setCarbohydrt_g(rs.getDouble(6));
                foo.setFiber_td_g(rs.getDouble(7));
                foo.setCalcium_mg(rs.getDouble(8));
                foo.setIron_mg(rs.getDouble(9));

                tempList.add(foo);
            }

            return tempList;
        } catch (SQLException e) {
            System.err.println("Couldn't retrieve from DB");
            return null;
        } finally {
            terminateConnection();
        }

    }

}
