package playField.api.intialize;

import playField.api.intialize.SQLcontoller.SqlStatements;
import playField.cardCollection.Cards;
import playField.cardCollection.cards.*;

import java.sql.*;
import java.util.HashSet;

public class InitDeckBuilderLvl2 extends Init {


    public Card getMinion(String cardID) {
        Card card = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SELECT_MINIONID);
        ) {
            stmt.setString(1, cardID);
            ResultSet minion = stmt.executeQuery();
            HashSet<CardAbility> bla;

            while (minion.next()) {
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
//                boolean spellDamage = minion.getBoolean("spellDamage");
//                int doesDamage = minion.getInt("doesDamage");
//                int doesHealth = minion.getInt("doesHealth");
//                String effectTarget = minion.getString("effectTarget");
//                String onCondition = minion.getString("onCondition");
//                String conditionItSelf = minion.getString("conditionItSelf");
//                String conditionClarification = minion.getString("conditionClarification");
//                String drawCard = minion.getString("drawCard");
//                int amountOfDrawnCards = minion.getInt("amountOfDrawnCards");
//                String battleCryEffectAbilityTarget = minion.getString("battleCryEffectAbilityTarget");
//                int battleCryEffectBoostAttackOfTarget = minion.getInt("battleCryEffectBoostAttackOfTarget");
//                int battleCryEffectBoostHealthOfTarget = minion.getInt("battleCryEffectBoostHealthOfTarget");

                if (extraAbility) {
                    if (windfury) {
                        bla.add(CardAbility.windFury);
                    }
                    if (charge) {
                        bla.add(CardAbility.charge);
                    }
                    if (divineShield) {
                        bla.add(CardAbility.divineShield);
                    }
                    if (battleCry) {
                        bla.add(CardAbility.battlecry);
                    }
                }
                card = new CardMinion(cardId, name, type, mana, heroType, info, img,
                        attack, health, race, mechanicsName, bla);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    public Card getWeapons(String cardID) {
        Card card = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_WEAPONID);
        ) {
            stmt.setString(1, cardID);
            ResultSet minion = stmt.executeQuery();

            while (minion.next()) {
                String cardId = minion.getString("cardId");
                String name = minion.getString("name");
                int mana = minion.getInt("mana");
                int attack = minion.getInt("attack");
                int durability = minion.getInt("durability");
                String info = minion.getString("description");
                String type = minion.getString("type");
                String heroType = minion.getString("heroType");
                String img = minion.getString("img");

                card = new CardWeapon(cardId, name, type, mana, heroType, info, img, attack, durability);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    public Card getSpells(String cardID) {
        Card card = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_SPELLSID);

        ) {
            stmt.setString(1, cardID);
            ResultSet spell = stmt.executeQuery();
            boolean bla2;

            while (spell.next()) {

                bla2 = true;
                String cardId = spell.getString("cardId");
                String name = spell.getString("name");
                String type = spell.getString("type");
                int mana = spell.getInt("mana");
                String heroType = spell.getString("heroType");
                String mechanicsName = spell.getString("mechanicsName");
                String info = spell.getString("description");
                String img = spell.getString("img");
                boolean destroy = spell.getBoolean("destroy");
                int doesDamage = spell.getInt("doesDamage");
                int doesHealth = spell.getInt("doesHealth");
                String damageTarget = spell.getString("damageTarget");
                String healthTarget = spell.getString("healthTarget");
                boolean drawCard = spell.getBoolean("drawCard");
                int amountOfDrawnCards = spell.getInt("amountOfDrawnCards");
                boolean onCondition = spell.getBoolean("onCondition");
                String conditionItSelf = spell.getString("conditionItSelf");

                HashSet<CardAbility> tempset = new HashSet<>();
                card = new CardSpell(cardId, name, type, mana, heroType, info, img, mechanicsName,
                        tempset, doesDamage, doesHealth, damageTarget, healthTarget, drawCard,
                        amountOfDrawnCards, onCondition, conditionItSelf, bla2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    public Cards getMinions(String playerHeroType) {
        Cards cards = new Cards();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet minion = stmt.executeQuery(SqlStatements.SELECT_HEROTYPE_MINIONS)
        ) {
            while (minion.next()) {
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
                String drawCard = minion.getString("drawCard");
                int amountOfDrawnCards = minion.getInt("amountOfDrawnCards");
                String battleCryEffectAbilityTarget = minion.getString("battleCryEffectAbilityTarget");
                int battleCryEffectBoostAttackOfTarget = minion.getInt("battleCryEffectBoostAttackOfTarget");
                int battleCryEffectBoostHealthOfTarget = minion.getInt("battleCryEffectBoostHealthOfTarget");

                HashSet<CardAbility> bla = new HashSet<>();
                //card = new CardMinion(cardId, name,..
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cards;
    }

    private void selectWeapon() {
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet weapon = stmt.executeQuery(SqlStatements.SElECT_WEAPON)
        ) {
            System.out.println("\n\n\n WEAPONS \n");

            while (weapon.next()) {
                String cardId = weapon.getString("cardId");
                String name = weapon.getString("name");
                int cost = weapon.getInt("mana");
                String info = weapon.getString("description");
                String playerClass = weapon.getString("heroType");
                int attack = weapon.getInt("attack");
                int durability = weapon.getInt("durability");
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
        ) {
            System.out.println("\n\n\nSPELL\n");
            while (spell.next()) {
                String cardId = spell.getString("cardId");
                String name = spell.getString("name");
                int cost = spell.getInt("mana");
                String info = spell.getString("description");
                String playerClass = spell.getString("heroType");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}