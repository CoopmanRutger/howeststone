package playField.api.intialize;

import playField.api.intialize.SQLcontoller.SqlStatements;
import playField.cardCollection.Cards;
import playField.cardCollection.cards.*;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class InitDeckBuilderLvl2 extends Init {


    public Card getMinion(String cardID){
        Card card = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SELECT_MINIONID);

        ){
            stmt.setString(1, cardID);
            ResultSet minion = stmt.executeQuery();

            HashSet<CardAbility> bla;

            while(minion.next()) {

                bla = new HashSet<>();

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
                String mechanicsName = minion.getString("mechanicsName");

                boolean extraAbility = minion.getBoolean("extraAbility");
                boolean windfury = minion.getBoolean("windfury");
                boolean charge = minion.getBoolean("charge");
                boolean battleCry = minion.getBoolean("battleCry");
                boolean divineShield = minion.getBoolean("divineShield");
                boolean spellDamage = minion.getBoolean("spellDamage");

                int doesDamage = minion.getInt("doesDamage");
                int doesHealth = minion.getInt("doesHealth");
                String effectTarget = minion.getString("effectTarget");

                String onCondition = minion.getString("onCondition");
                String conditionItSelf = minion.getString("conditionItSelf");
                String conditionClarification = minion.getString("conditionClarification");

                String drawCard= minion.getString("drawCard");
                int amountOfDrawnCards = minion.getInt("amountOfDrawnCards");

                String battleCryEffectAbilityTarget = minion.getString("battleCryEffectAbilityTarget");
                int battleCryEffectBoostAttackOfTarget = minion.getInt("battleCryEffectBoostAttackOfTarget");
                int battleCryEffectBoostHealthOfTarget = minion.getInt("battleCryEffectBoostHealthOfTarget");

                // blablablablabal

                if (extraAbility){
                    if (windfury) bla.add(CardAbility.windFury);
                    if (charge) bla.add(CardAbility.charge);
                    if (charge) bla.add(CardAbility.divineShield);

                }




//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
                card = new CardMinion(cardId, name, type, mana, heroType, info, img, attack, health, race, mechanicsName, bla);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }


    public Card getWeapons(String cardID){
        Card card = null;
        try (
                Connection conn = db.getConnection();
//                Statement stmt = conn.createStatement();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_WEAPONID);

        ){
            stmt.setString(1, cardID);
            ResultSet minion = stmt.executeQuery();

            while(minion.next()) {
                String cardId = minion.getString("cardId");
                String name = minion.getString("name");
                int mana = minion.getInt("mana");
                int attack = minion.getInt("attack");
                int durability = minion.getInt("durability");
                String info = minion.getString("description");
                String type = minion.getString("type");
                String heroType = minion.getString("heroType");
                String img = minion.getString("img");


//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
                card = new CardWeapon(cardId, name, type, mana, heroType, info, img, attack,durability);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }


    public Card getSpells(String cardID){
        Card card = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_SPELLSID);

        ){
            stmt.setString(1, cardID);
            ResultSet spell = stmt.executeQuery();

            while(spell.next()) {
                String cardId = spell.getString("cardId");
                String name = spell.getString("name");
                String type = spell.getString("type");
                int mana = spell.getInt("mana");
                String heroType = spell.getString("heroType");
                String mechanicsName = spell.getString("mechanicsName");
                String info = spell.getString("description");
                String img = spell.getString("img");
                card = new CardSpell(cardId, name, type, mana, heroType, info, img, mechanicsName, new HashSet<CardAbility>(),0,0,1, 1, 1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }


//    public Cards getMinions(){
//        Cards cards = new Cards();
//        try (
//                Connection conn = db.getConnection();
//        Statement stmt = conn.createStatement();
//                ResultSet minion = stmt.executeQuery(SqlStatements.SElECT_MINION)
//        ){
//            System.out.println("\n\n\n MINION \n");
//
//            while(minion.next()) {
//                String cardId = minion.getString("cardId");
//                String name = minion.getString("name");
//                int mana = minion.getInt("mana");
//                int attack = minion.getInt("attack");
//                int health = minion.getInt("health");
//                String info = minion.getString("description");
//                String type = minion.getString("type");
//                String heroType = minion.getString("heroType");
//                String img = minion.getString("img");
//                String race = minion.getString("race");
//                String mechanicsName = minion.getString("mechanicsName");
//
////                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
//                CardMinion card = new CardMinion(cardId, name, type, mana, heroType, info, img, attack, health, race, mechanicsName );
//                cards.addCard(card);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(cards);
//        return cards;
//    }

    public Cards getMinions(String playerHeroType){
        Cards cards = new Cards();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet minion = stmt.executeQuery(SqlStatements.SELECT_HEROTYPE_MINIONS)
        ){
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
                String mechanicsName = minion.getString("mechanicsName");

                int extraAbility = minion.getInt("extraAbility");
                boolean windfury = minion.getBoolean("windfury");
                boolean charge = minion.getBoolean("charge");
                boolean battleCry = minion.getBoolean("battleCry");
                boolean divineShield = minion.getBoolean("divineShield");
                boolean spellDamage = minion.getBoolean("spellDamage");

                int doesDamage = minion.getInt("doesDamage");
                int doesHealth = minion.getInt("doesHealth");
                String effectTarget = minion.getString("effectTarget");

                String onCondition = minion.getString("onCondition");
                String conditionItSelf = minion.getString("conditionItSelf");
                String conditionClarification = minion.getString("conditionClarification");

                String drawCard= minion.getString("drawCard");
                int amountOfDrawnCards = minion.getInt("amountOfDrawnCards");

                String battleCryEffectAbilityTarget = minion.getString("battleCryEffectAbilityTarget");
                int battleCryEffectBoostAttackOfTarget = minion.getInt("battleCryEffectBoostAttackOfTarget");
                int battleCryEffectBoostHealthOfTarget = minion.getInt("battleCryEffectBoostHealthOfTarget");





                HashSet<CardAbility> bla = new HashSet<>();
//
////                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
//                card = new CardMinion(cardId, name, type, mana, heroType, info, img, attack, health, race, mechanicsName, extraAbility, windfury, charge, battleCry, divineShield,
//                        spellDamage, doesDamage, doesHealth, effectTarget, onCondition, conditionItSelf, conditionClarification, drawCard, amountOfDrawnCards, battleCryEffectAbilityTarget,
//                        battleCryEffectBoostAttackOfTarget, battleCryEffectBoostHealthOfTarget, bla);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }



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



//
//
//    private void insertCity(String city, String district){
//        try (
//                Connection conn = db.getConnection();
//                PreparedStatement stmt = conn.prepareStatement(SqlStatements.INSERT_CITY,
//                        Statement.RETURN_GENERATED_KEYS);
//        ){
//            stmt.setString(1, city);
//            stmt.setString(2, district);
//            int affectedRows = stmt.executeUpdate();
//
//            if (affectedRows == 0) {
//                throw new SQLException("No city created: no rows affected.");
//            }
//
//            try (ResultSet rs = stmt.getGeneratedKeys()) {
//                if (rs.next()) {
//                    long id = rs.getLong(1);
//                    System.out.printf("%s now has ID %d", city, id);
//                }
//                else {
//                    throw new SQLException("No city created: no id obtained.");
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

}
