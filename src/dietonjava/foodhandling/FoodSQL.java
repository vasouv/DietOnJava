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

        ObservableList<Food> search = FXCollections.observableArrayList();

        ResultSet rs = null;

        try {
            if (term.isEmpty()) {
                rs = statement.executeQuery("select * from foods");
            } else {
                rs = statement.executeQuery("select * from foods where shrt_desc like '%" + term + "%';");
            }

            while (rs.next()) {
                Food foo = new Food();

                foo.setNdb_no(rs.getString(1));
                foo.setShrt_desc(rs.getString(2));
                foo.setWater_g(rs.getDouble(3));
                foo.setEnerg_kcal(rs.getDouble(4));
                foo.setProtein_g(rs.getDouble(5));
                foo.setLipid_tot_g(rs.getDouble(6));
                foo.setAsh_g(rs.getDouble(7));
                foo.setCarbohydrt_g(rs.getDouble(8));
                foo.setFiber_td_g(rs.getDouble(9));
                foo.setSugar_tot_g(rs.getDouble(10));
                foo.setCalcium_mg(rs.getDouble(11));
                foo.setIron_mg(rs.getDouble(12));
                foo.setMagnesium_mg(rs.getDouble(13));
                foo.setPhosphorus_mg(rs.getDouble(14));
                foo.setPotassium_mg(rs.getDouble(15));
                foo.setSodium_mg(rs.getDouble(16));
                foo.setZinc_mg(rs.getDouble(17));
                foo.setCopper_mg(rs.getDouble(18));
                foo.setManganese_mg(rs.getDouble(19));
                foo.setSelenium_microg(rs.getDouble(20));
                foo.setVit_c_mg(rs.getDouble(21));
                foo.setThiamin_mg(rs.getDouble(22));
                foo.setRiboflavin_mg(rs.getDouble(23));
                foo.setNiacin_mg(rs.getDouble(24));
                foo.setPanto_acid_mg(rs.getDouble(25));
                foo.setVit_b6_mg(rs.getDouble(26));
                foo.setFolate_tot_microg(rs.getDouble(27));
                foo.setFolic_acid_microg(rs.getDouble(28));
                foo.setFood_folate_microg(rs.getDouble(29));
                foo.setFolate_dfe_microg(rs.getDouble(30));
                foo.setCholine_tot_mg(rs.getDouble(31));
                foo.setVit_b12_microg(rs.getDouble(32));
                foo.setVit_a_iu(rs.getDouble(33));
                foo.setVit_a_rae(rs.getDouble(34));
                foo.setRetinol_microg(rs.getDouble(35));
                foo.setAlpha_carot_microg(rs.getDouble(36));
                foo.setBeta_carot_microg(rs.getDouble(37));
                foo.setBeta_crypt_microg(rs.getDouble(38));
                foo.setLycopene_microg(rs.getDouble(39));
                foo.setLutzea_microg(rs.getDouble(40));
                foo.setVit_e_mg(rs.getDouble(41));
                foo.setVit_d_microg(rs.getDouble(42));
                foo.setVit_d_iu(rs.getDouble(43));
                foo.setVit_k_microg(rs.getDouble(44));
                foo.setFa_sat_g(rs.getDouble(45));
                foo.setFa_mono_g(rs.getDouble(46));
                foo.setFa_poly_g(rs.getDouble(47));
                foo.setCholesterol_mg(rs.getDouble(48));
                foo.setGmwt1(rs.getDouble(49));
                foo.setGmwt1_desc(rs.getString(50));
                foo.setGmwt2(rs.getDouble(51));
                foo.setGmwt2_desc(rs.getString(52));
                foo.setRefuse_pct(rs.getDouble(53));
                
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
                foo.setWater_g(rs.getDouble(3));
                foo.setEnerg_kcal(rs.getDouble(4));
                foo.setProtein_g(rs.getDouble(5));
                foo.setLipid_tot_g(rs.getDouble(6));
                foo.setAsh_g(rs.getDouble(7));
                foo.setCarbohydrt_g(rs.getDouble(8));
                foo.setFiber_td_g(rs.getDouble(9));
                foo.setSugar_tot_g(rs.getDouble(10));
                foo.setCalcium_mg(rs.getDouble(11));
                foo.setIron_mg(rs.getDouble(12));
                foo.setMagnesium_mg(rs.getDouble(13));
                foo.setPhosphorus_mg(rs.getDouble(14));
                foo.setPotassium_mg(rs.getDouble(15));
                foo.setSodium_mg(rs.getDouble(16));
                foo.setZinc_mg(rs.getDouble(17));
                foo.setCopper_mg(rs.getDouble(18));
                foo.setManganese_mg(rs.getDouble(19));
                foo.setSelenium_microg(rs.getDouble(20));
                foo.setVit_c_mg(rs.getDouble(21));
                foo.setThiamin_mg(rs.getDouble(22));
                foo.setRiboflavin_mg(rs.getDouble(23));
                foo.setNiacin_mg(rs.getDouble(24));
                foo.setPanto_acid_mg(rs.getDouble(25));
                foo.setVit_b6_mg(rs.getDouble(26));
                foo.setFolate_tot_microg(rs.getDouble(27));
                foo.setFolic_acid_microg(rs.getDouble(28));
                foo.setFood_folate_microg(rs.getDouble(29));
                foo.setFolate_dfe_microg(rs.getDouble(30));
                foo.setCholine_tot_mg(rs.getDouble(31));
                foo.setVit_b12_microg(rs.getDouble(32));
                foo.setVit_a_iu(rs.getDouble(33));
                foo.setVit_a_rae(rs.getDouble(34));
                foo.setRetinol_microg(rs.getDouble(35));
                foo.setAlpha_carot_microg(rs.getDouble(36));
                foo.setBeta_carot_microg(rs.getDouble(37));
                foo.setBeta_crypt_microg(rs.getDouble(38));
                foo.setLycopene_microg(rs.getDouble(39));
                foo.setLutzea_microg(rs.getDouble(40));
                foo.setVit_e_mg(rs.getDouble(41));
                foo.setVit_d_microg(rs.getDouble(42));
                foo.setVit_d_iu(rs.getDouble(43));
                foo.setVit_k_microg(rs.getDouble(44));
                foo.setFa_sat_g(rs.getDouble(45));
                foo.setFa_mono_g(rs.getDouble(46));
                foo.setFa_poly_g(rs.getDouble(47));
                foo.setCholesterol_mg(rs.getDouble(48));
                foo.setGmwt1(rs.getDouble(49));
                foo.setGmwt1_desc(rs.getString(50));
                foo.setGmwt2(rs.getDouble(51));
                foo.setGmwt2_desc(rs.getString(52));
                foo.setRefuse_pct(rs.getDouble(53));

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
