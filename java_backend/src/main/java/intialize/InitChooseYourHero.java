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

    public HeroPower getMinions(String playerHeroType){
        HeroPower heroPower;
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet minion = stmt.executeQuery(SqlStatements.SELECT_HEROTYPE_MINIONS)
        ){
            System.out.println("\n\n\n NEUTRAL \n");

            while(minion.next()) {
                String heroPowerName = minion.getString("heroPowerName");
                int mana = minion.getInt("mana");
                int tags = minion.getInt("tags");
                int abilityType = minion.getInt("abilityType");
                String duration = minion.getString("duration");
//                String abilityValue = minion.getString("abilityValue");
                String img = minion.getString("img");

//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
                heroPower = new HeroPower(heroPowerName,mana, tags, abilityType,duration, img )

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(heroPower);
        return heroPower;
    }
}
