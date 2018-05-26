package playfield.api.intialize;

import playfield.api.intialize.SQLcontoller.SqlStatements;
import playfield.cardCollection.Cards;
import playfield.cardCollection.cards.*;

import java.sql.*;
import java.util.HashSet;

public class InitDeckBuilderLvl2 extends Init {

    public Card getMinion(String cardID) {
        Card card = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.RETRIEVE_MINIONS_BY_ID);
        ) {
            stmt.setString(1, cardID);
            final ResultSet minion = stmt.executeQuery();
            HashSet<CardAbility> bla;
            while (minion.next()) {
                bla = new HashSet<>();
                final int mana = minion.getInt("mana");
                final int attack = minion.getInt("attack");
                final int health = minion.getInt("health");
                //final int doesDamage = minion.getInt("doesDamage");
                //final int doesHealth = minion.getInt("doesHealth");
                //final int amountOfDrawnCards = minion.getInt("amountOfDrawnCards");
                //final int battleCryEffectBoostAttackOfTarget = minion.getInt("battleCryEffectBoostAttackOfTarget");
                //final int battleCryEffectBoostHealthOfTarget = minion.getInt("battleCryEffectBoostHealthOfTarget");
                final boolean extraAbility = minion.getBoolean("extraAbility");
                final boolean windfury = minion.getBoolean("windfury");
                final boolean charge = minion.getBoolean("charge");
                final boolean battleCry = minion.getBoolean("battleCry");
                final boolean divineShield = minion.getBoolean("divineShield");
                //boolean spellDamage = minion.getBoolean("spellDamage");
                final String cardId = minion.getString("cardId");
                final String name = minion.getString("name");
                final String info = minion.getString("description");
                final String type = minion.getString("type");
                final String heroType = minion.getString("heroType");
                final String img = minion.getString("img");
                final String race = minion.getString("race");
                final String mechanicsName = minion.getString("mechanicsName");
                //final String effectTarget = wichOne.getString("effectTarget");
                //final String onCondition = wichOne.getString("onCondition");
                //final String conditionItSelf = wichOne.getString("conditionItSelf");
                //final String conditionClarification = wichOne.getString("conditionClarification");
                //final String drawCard = wichOne.getString("drawCard");
                //final String battleCryEffectAbilityTarget = wichOne.getString("battleCryEffectAbilityTarget");


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
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.RETRIEVE_WEAPON_BY_ID);
        ) {
            stmt.setString(1, cardID);
            final ResultSet minion = stmt.executeQuery();

            while (minion.next()) {
                final String cardId = minion.getString("cardId");
                final String name = minion.getString("name");
                final int mana = minion.getInt("mana");
                final int attack = minion.getInt("attack");
                final int durability = minion.getInt("durability");
                final String info = minion.getString("description");
                final String type = minion.getString("type");
                final String heroType = minion.getString("heroType");
                final String img = minion.getString("img");

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
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.RETRIEVE_SPELL_BY_ID);

        ) {
            stmt.setString(1, cardID);
            final ResultSet spell = stmt.executeQuery();
            boolean bla2;

            while (spell.next()) {

                bla2 = true;
                final String cardId = spell.getString("cardId");
                final String name = spell.getString("name");
                final String type = spell.getString("type");
                final int mana = spell.getInt("mana");
                final String heroType = spell.getString("heroType");
                final String mechanicsName = spell.getString("mechanicsName");
                final String info = spell.getString("description");
                final String img = spell.getString("img");
                final boolean destroy = spell.getBoolean("destroy");
                final int doesDamage = spell.getInt("doesDamage");
                final int doesHealth = spell.getInt("doesHealth");
                final String damageTarget = spell.getString("damageTarget");
                final String healthTarget = spell.getString("healthTarget");
                final boolean drawCard = spell.getBoolean("drawCard");
                final int amountOfDrawnCards = spell.getInt("amountOfDrawnCards");
                final boolean onCondition = spell.getBoolean("onCondition");
                final String conditionItSelf = spell.getString("conditionItSelf");

                final HashSet<CardAbility> tempset = new HashSet<>();
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
        final Cards cards = new Cards();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet minion = stmt.executeQuery(SqlStatements.RETRIEVE_MINIONS_BY_HERO)
        ) {
            while (minion.next()) {
                final String cardId = minion.getString("cardId");
                final String name = minion.getString("name");
                final int mana = minion.getInt("mana");
                final int attack = minion.getInt("attack");
                final int health = minion.getInt("health");
                final String info = minion.getString("description");
                final String type = minion.getString("type");
                final String heroType = minion.getString("heroType");
                final String img = minion.getString("img");
                final String race = minion.getString("race");
                final String mechanicsName = minion.getString("mechanicsName");
                final int extraAbility = minion.getInt("extraAbility");
                final boolean windfury = minion.getBoolean("windfury");
                final boolean charge = minion.getBoolean("charge");
                final boolean battleCry = minion.getBoolean("battleCry");
                final boolean divineShield = minion.getBoolean("divineShield");
                final boolean spellDamage = minion.getBoolean("spellDamage");
                final int doesDamage = minion.getInt("doesDamage");
                final int doesHealth = minion.getInt("doesHealth");
                final String effectTarget = minion.getString("effectTarget");
                final String onCondition = minion.getString("onCondition");
                final String conditionItSelf = minion.getString("conditionItSelf");
                final String conditionClarification = minion.getString("conditionClarification");
                final String drawCard = minion.getString("drawCard");
                final int amountOfDrawnCards = minion.getInt("amountOfDrawnCards");
                final String battleCryEffectAbilityTarget = minion.getString("battleCryEffectAbilityTarget");
                final int battleCryEffectBoostAttackOfTarget = minion.getInt("battleCryEffectBoostAttackOfTarget");
                final int battleCryEffectBoostHealthOfTarget = minion.getInt("battleCryEffectBoostHealthOfTarget");
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
                ResultSet weapon = stmt.executeQuery(SqlStatements.SELECT_WEAPON)
        ) {
            System.out.println("\n\n\n WEAPONS \n");

            while (weapon.next()) {
                final String cardId = weapon.getString("cardId");
                final String name = weapon.getString("name");
                final int cost = weapon.getInt("mana");
                final String info = weapon.getString("description");
                final String playerClass = weapon.getString("heroType");
                final int attack = weapon.getInt("attack");
                final int durability = weapon.getInt("durability");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void selectSpell() {
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet spell = stmt.executeQuery(SqlStatements.SELECT_SPELL)
        ) {
            System.out.println("\n\n\nSPELL\n");
            while (spell.next()) {
                final String cardId = spell.getString("cardId");
                final String name = spell.getString("name");
                final int cost = spell.getInt("mana");
                final String info = spell.getString("description");
                final String playerClass = spell.getString("heroType");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
