package intialize;

import SQLcontoller.SqlStatements;
import cardCollection.Cards;
import cards.CardMinion;

import java.sql.*;

public class InitDeckBuilderLvl2 extends Init {


    public void selectMinion(){
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet minion = stmt.executeQuery(SqlStatements.SElECT_MINION)
        ){


            Cards cards = new Cards();
            cards
            System.out.println("\n\n\n MINION \n");

            while(minion.next()) {
                String cardId = minion.getString("cardId");
                String name = minion.getString("name");
                int mana = minion.getInt("mana");
                int attack = minion.getInt("attack");
                int health = minion.getInt("health");
                String info = minion.getString("description");
                String type = minion.getString("type");
                String heroType = minion.getString("heroType");
                String img = minion.getString("img");
                String race = minion.getString("race");
                String imgBack = minion.getString("imgBack");
                String mechanicsName = minion.getString("mechanicsName");

//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
                CardMinion kaart = new CardMinion(cardId, name, type, mana, heroType, info, img, attack, health, race, imgBack, mechanicsName );

                System.out.println(kaart);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }







//
//
//    private void selectOneMinion(String minionName) {
//        try (
//                Connection conn = db.getConnection();
//                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SELECT_ONE_MINION);
//        ){
//            stmt.setString(1, minionName);
//            try (ResultSet minion = stmt.executeQuery()) {
//                if (minion.next()) {
//                    String cardId = minion.getString("cardId");
//                    String name = minion.getString("name");
//                    int cost = minion.getInt("mana");
//                    int attack = minion.getInt("attack");
//                    int health = minion.getInt("health");
//                    String info = minion.getString("description");
//
//                    System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , cost, attack, health, info);
//                } else {
//                    System.err.println("No "+ minionName +" found!");
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }






    private void selectWeapon() {
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet weapon = stmt.executeQuery(SqlStatements.SElECT_WEAPON)
        ){
            System.out.println("\n\n\n WEAPONS \n");

            while(weapon.next()) {
                String cardId = weapon.getString("cardId");
                String name = weapon.getString("name");
                int cost = weapon.getInt("mana");
                String info = weapon.getString("description");
                String playerClass = weapon.getString("heroType");
                int attack = weapon.getInt("attack");
                int durability = weapon.getInt("durability");

                System.out.printf(" cardID: %s, name: %s, mana: %d, attack: %d, durability: %d, heroType: %s description: %s \n", cardId,name , cost, attack, durability, playerClass, info);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void selectSpell() {
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet spell = stmt.executeQuery(SqlStatements.SElECT_SPELL)
        ){
            System.out.println("\n\n\nSPELL\n");
            while(spell.next()) {
                String cardId = spell.getString("cardId");
                String name = spell.getString("name");
                int cost = spell.getInt("mana");
                String info = spell.getString("description");
                String playerClass = spell.getString("heroType");

                System.out.printf(" cardID: %s, name: %s, mana: %d, info: %s, heroType %s \n", cardId,name , cost, info, playerClass);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    private void insertCity(String city, String district){
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.INSERT_CITY,
                        Statement.RETURN_GENERATED_KEYS);
        ){
            stmt.setString(1, city);
            stmt.setString(2, district);
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("No city created: no rows affected.");
            }

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    long id = rs.getLong(1);
                    System.out.printf("%s now has ID %d", city, id);
                }
                else {
                    throw new SQLException("No city created: no id obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
