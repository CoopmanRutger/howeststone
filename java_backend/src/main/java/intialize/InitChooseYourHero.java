package intialize;

import SQLcontoller.SqlStatements;
import cardCollection.Cards;
import cards.CardMinion;
import heroes.Hero;
import heroes.HeroPower;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InitChooseYourHero extends Init {


    public Hero getHero(String HeroName){
        Hero hero = null;
        try (
                Connection conn = db.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet heroResult = stmt.executeQuery(SqlStatements.SElECT_HERO_HERONAME)
        ){
            System.out.println("\n\n\n NEUTRAL \n");

            while(heroResult.next()) {
                String heroName = heroResult.getString("heroName");
                String img = heroResult.getString("img");
                HeroPower heroPower = getHeroPower(heroResult.getString("heroPower"));

//                System.out.printf(" cardId: %s, name: %s, mana: %d, attack: %d, health: %d, description: %s \n", cardId,name , mana, attack, health, info);
                hero = new Hero(heroName, img, heroPower );

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(hero);
        return hero;
    }

    public HeroPower getHeroPower(String heroPowerName){
        HeroPower heroPower;
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
