package intialize;

import SQLcontoller.SqlStatements;
import cardCollection.Cards;
import cards.CardMinion;
import heroes.HeroPower;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitChooseYourHero extends Init {


    public Cards getMinions(String playerHeroType){
        Cards cards = new Cards();
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet minion = stmt.executeQuery(SqlStatements.SELECT_HEROTYPE_MINIONS)
        ){
            System.out.println("\n\n\n NEUTRAL \n");

            while(minion.next()) {
                String heroName = minion.getString("heroName");
                String img = minion.getString("img");
                int mana = minion.getInt("heroPower");

//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
                CardMinion card = new CardMinion(cardId, name, type, mana, heroType, info, img, attack, health, race, mechanicsName );
                cards.addCard(card);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(cards);
        return cards;
    }

    public HeroPower getHeroPower(String playerHeroPower){
        HeroPower heroPower = null;
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet heroPowerResult = stmt.executeQuery(SqlStatements.SELECT_HEROTYPE_MINIONS)
        ){
            while(heroPowerResult.next()) {

                String heroPowerName = heroPowerResult.getString("heroPowerName");

                int mana = heroPowerResult.getInt("mana");

                String tags = heroPowerResult.getString("tags");

                String abilityType = heroPowerResult.getString("abilityType");

                int abilityValue = heroPowerResult.getInt("abilityValue");

                int duration = heroPowerResult.getInt("duration");

                String img = heroPowerResult.getString("img");

                heroPower = new HeroPower(heroPowerName, mana, tags, abilityType, abilityValue, duration, img, true);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(heroPower);
        return heroPower;
    }
}
