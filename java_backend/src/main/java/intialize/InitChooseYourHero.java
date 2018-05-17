package intialize;

import SQLcontoller.SqlStatements;
import heroes.Hero;
import heroes.HeroPower;

import java.sql.*;

public class InitChooseYourHero extends Init {


    public Hero getHero(String HeroName){
        Hero hero = null;
        try (
                Connection conn = db.getConnection();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_HERO_HERONAME);
        ){
            stmt.setString(1, HeroName);

            ResultSet heroResult = stmt.executeQuery(SqlStatements.SElECT_HERO_HERONAME);

            if (heroResult.next()) {
                String heroName = heroResult.getString("heroName");

                String img = heroResult.getString("img");

                HeroPower heroPower = getHeroPower(heroResult.getString("heroPower"));

                hero = new Hero(heroName, img, heroPower);
            } else {
                // TODO: 17/05/2018
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(hero);
        return hero;
    }

    public HeroPower getHeroPower(String playerHeroPowerName){
        HeroPower heroPower = null;
        try (
                Connection conn = db.getConnection();
//                Statement stmt = conn.createStatement();
                PreparedStatement stmt = conn.prepareStatement(SqlStatements.SElECT_HEROPOWER_HERONAME);

        ){

            stmt.setString(1, playerHeroPowerName);
            ResultSet heroPowerResult = stmt.executeQuery(SqlStatements.SElECT_HEROPOWER_HERONAME);

            if(heroPowerResult.next()) {

                String heroPowerName = heroPowerResult.getString("heroPowerName");

                int mana = heroPowerResult.getInt("mana");

                String tags = heroPowerResult.getString("tags");

                String abilityType = heroPowerResult.getString("abilityType");

                int abilityValue = heroPowerResult.getInt("abilityValue");

                int duration = heroPowerResult.getInt("duration");

                String img = heroPowerResult.getString("img");

                heroPower = new HeroPower(heroPowerName, mana, tags, abilityType, abilityValue, duration, img, true);
            } else {
                // TODO: 17/05/2018
            }

            } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(heroPower);
        return heroPower;
    }
}
